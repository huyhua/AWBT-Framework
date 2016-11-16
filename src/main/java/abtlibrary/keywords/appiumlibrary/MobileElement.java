package abtlibrary.keywords.appiumlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.keywords.selenium2library.Element;
import abtlibrary.keywords.selenium2library.Logging;
import abtlibrary.keywords.selenium2library.SelectElement;

@RobotKeywords
public class MobileElement {
	/**
	 * Instantiated ApplicationManagement keyword bean
	 */
	@Autowired
	protected ApplicationManagement applicationManagement;

	/**
	 * Instantiated Element keyword bean
	 */
	@Autowired
	protected Element element;

	/**
	 * Instantiated Element keyword bean
	 */
	@Autowired
	protected SelectElement selectElement;

	/**
	 * Instantiated Logging keyword bean
	 */
	@Autowired
	protected Logging logging;

	// ##############################
	// Keywords
	// ##############################

	/**
	 * Returns the values in the select list view identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * Get list keywords work on mobile's list view . Key attributes for get
	 * lists are id and name. See `Introduction` for details about locators.<br>
	 * 
	 * @param locator
	 *            The locator to locate the select list.
	 * @return The select list values
	 */
	@RobotKeyword
	@ArgumentNames({ "locator" })
	public List<String> getListViewLabels(String locator) {
		WebElement listView = element.elementFind(locator, true, true).get(0);
		List<WebElement> options = listView.findElements(By.xpath("//android.widget.TextView"));

		if (options.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("Listview '%s' does not have any options", locator));
		}

		return selectElement.getLabelsForOptions(options);
	}

	/**
	 * Select the given <b>index</b> of the list view identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * Tries to select by value AND by label. It's generally faster to use 'by
	 * index/value/label' keywords.<br>
	 * <br>
	 * Select list keywords work on mobile's list view. Key attributes for
	 * select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param locator
	 *            The locator to locate the list view.
	 * @param index
	 *            The index of item selected (first item indexed by 0)
	 */
	@RobotKeyword
	@ArgumentNames({ "locator", "index" })
	public void selectFromListViewByIndex(String locator, String index) {
		WebElement listView = element.elementFind(locator, true, true).get(0);
		List<WebElement> options = listView.findElements(By.xpath("//*"));

		if (options.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("Listview '%s' does not have any options", locator));
		}

		options.get(Integer.parseInt(index)).click();
	}

	/**
	 * Selects the tab by Name in tab menu identified by <b>locator</b> <br>
	 * 
	 * @param menuLocator
	 *            locator to locate tab menu
	 * @param tabName
	 *            name of tab
	 */
	@RobotKeyword
	@ArgumentNames({ "locator", "tab" })
	public void selectTabByName(String menuLocator, String tabName) {
		WebElement tabMenu = element.elementFind(menuLocator, true, true).get(0);
		List<WebElement> childElements = tabMenu.findElements(By.xpath("//*[contains(@class,\"Tab\")]"));

		if (childElements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("Menu '%s' does not have any tabs", menuLocator));
		}

		for (int i = 0; i < childElements.size(); i++) {
			String tab = childElements.get(i).findElement(By.xpath("//*[contains(@class,\"TextView\")]")).getText();
			if (tabName.equals(tab)) {
				childElements.get(i).click();
				break;
			}
			if (i == childElements.size() - 1) {
				throw new ABTLibraryNonFatalException(String.format("Tab '%s' is not located", tabName));
			}
		}
	}

	/**
	 * Selects the tab by Index in tab menu identified by <b>locator</b> <br>
	 * 
	 * @param menuLocator
	 *            locator to locate tab menu
	 * @param index
	 *            the index of selected tab (first tab is indexed by 1)
	 */
	@RobotKeyword
	@ArgumentNames({ "locator", "tab" })
	public void selectTabByIndex(String menuLocator, String index) {
		WebElement tabMenu = element.elementFind(menuLocator, true, true).get(0);
		List<WebElement> childElements = tabMenu.findElements(By.xpath("//*[contains(@class,\"Tab\")]"));

		if (childElements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("Menu '%s' does not have any tabs", menuLocator));
		}

		if (childElements.size() < Integer.parseInt(index) || Integer.parseInt(index) < 0) {
			throw new ABTLibraryNonFatalException(
					String.format("Index '%s' is out of range (0,'%s')", index, childElements.size()));
		}

		childElements.get(Integer.parseInt(index)).click();
	}

	/**
	 * Select item identified by <b>text</b> in list.
	 * 
	 * @param text
	 *            displayed text of selected item.
	 */
	@RobotKeyword
	@ArgumentNames({"text"})
	public void selectItemByText(String text) {
		applicationManagement.scrollTo(text).click();
	}
	
	
	@RobotKeyword
	@ArgumentNames({"locator"})
	public List<String>	scrollAndGetItemNames(String locator){
		List<String> results = new ArrayList<>();
//		WebElement scrollable = element.elementFind(scrollableLocator, true, true).get(0);
		List<WebElement> itemOnScreen;
		itemOnScreen = element.elementFind(locator, false, true);
		
		if(itemOnScreen.isEmpty()){
			logging.warn(String.format("List with locator '%s' contains no item", locator));
			throw new ABTLibraryNonFatalException();
		}
		
		WebElement firstElement = itemOnScreen.get(0);
		WebElement lastElement = itemOnScreen.get(itemOnScreen.size()-1);
		
		Point start = lastElement.getLocation();
		Point stop = firstElement.getLocation();
		
		int safeRetry=0;
		
		while(true){
			itemOnScreen.forEach(item -> results.add(item.getAttribute("name")));
			applicationManagement.swipe(start.getX(), start.getY(), stop.getX(), stop.getY(), 1500);
			itemOnScreen = element.elementFind(locator, false, true);
			String currentLastElement = itemOnScreen.get(itemOnScreen.size()-1).getAttribute("name");
			
			if(currentLastElement.equals(results.get(results.size()-1)) && safeRetry++ == 3){
				break;
			}
		}
		
		List<String> finalResults = results.stream().distinct().collect(Collectors.toList());
		return finalResults;
	}
	
	

	// ##############################
	// Internal Methods
	// ##############################

}