package abtlibrary.keywords.appiumlibrary;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import com.applitools.eyes.EyesException;
import com.applitools.eyes.TestResults;

import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.keywords.selenium2library.BrowserManagement;
import abtlibrary.keywords.selenium2library.Element;
import abtlibrary.keywords.selenium2library.Logging;
import abtlibrary.keywords.selenium2library.SelectElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.applitools.eyes.TestResults;

@RobotKeywords
public class MobileElement {
	/**
	 * Instantiated ApplicationManagement keyword bean
	 */
	@Autowired
	protected ApplicationManagement applicationManagement;

	/**
	 * Instantiated Touch keyword bean
	 */
	protected Touch touch;
	
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
	 * Returns the values in the select list view identified by <b>locator</b>.
	 * <br>
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
	@ArgumentNames({ "text" })
	public void selectItemByText(String text) {
		applicationManagement.scrollToExact(text).click();
		element.elementFind("name="+text, true, true).get(0).click();
//		if(applicationManagement.browserManagement.getCurrentPlatform().equalsIgnoreCase("android")){
//			
//			applicationManagement.scrollToExact(text).click();
//		}else{
//			applicationManagement.browserManagement.getCurrentWebDriver().findElement(By.id(text)).click();
//		}
	}
	
	
	@RobotKeyword
	@ArgumentNames({"locator"})
	public List<String>	scrollAndGetItemNames(String locator){
		try {
			List<String> results = new ArrayList<>();
//		WebElement scrollable = element.elementFind(scrollableLocator, true, true).get(0);
			List<WebElement> itemsOnScreen;
			itemsOnScreen = element.elementFind(locator, false, false);
			
			if(itemsOnScreen.isEmpty()){
				logging.warn(String.format("List with locator '%s' contains no item", locator));
				throw new ABTLibraryNonFatalException();
			}
			
			if(itemsOnScreen.size() < 2){
				itemsOnScreen.forEach(item -> {
					String id = item.getAttribute("name");
					if(!id.equals(""))
						results.add(id);
				});
				
				List<String> finalResults = results.stream().distinct().collect(Collectors.toList());
				return finalResults;
			}
			
			WebElement firstElement = itemsOnScreen.get(0);
			WebElement lastElement = itemsOnScreen.get(itemsOnScreen.size()-1);
			
			Point start = lastElement.getLocation();
			Point stop = firstElement.getLocation();
			
			int safeRetry=0;
			
			while(true){
				itemsOnScreen.forEach(item -> {
					String id = item.getAttribute("name");
					if(!id.equals(""))
						results.add(id);
				});
				
				touch.swipe(start.getX(), start.getY(), stop.getX(), stop.getY(), 1500);
				itemsOnScreen = element.elementFind(locator, false, true);
				String currentLastElement = itemsOnScreen.get(itemsOnScreen.size()-1).getAttribute("name");
				String previousLastElement = results.get(results.size()-1);
				if(!currentLastElement.equals(previousLastElement)){
					safeRetry = 0;
				}
				
				if(currentLastElement.equals(previousLastElement) && safeRetry++ == 2){
					break;
				}
			}
			
			List<String> finalResults = results.stream().distinct().collect(Collectors.toList());
			return finalResults;
		} catch (Exception e) {
			logging.warn(e.getMessage());
			throw e;
		}
	}
	
	
	
	public Point getCenter(WebElement el) {

		Point point = new Point(0, 0);
		point = el.getLocation();
//		 System.out.print("Location " + el.getLocation());
//		 System.out.println();
//		 System.out.print("height "+ el.getSize().getHeight());
//		 System.out.print(" width "+ el.getSize().getWidth());
		point.x = point.getX() + (el.getSize().getWidth() / 2);
		point.y = point.getY() + (el.getSize().getHeight() / 2);

		return point;
	}
	
	public boolean checkElementVisibility(String id, long secondWait) {
		WebDriverWait  wait = new WebDriverWait(applicationManagement.browserManagement.getCurrentWebDriver(),secondWait);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.id(id))));
		} catch (Exception e) {
			//System.out.println("No element");
			//Reporter.log(e.getMessage());
			return false;
		}
		return true;
	}
	
	// convert when input data to app
	public String convertFromUnicode(String target){
		return Normalizer.normalize(target, Normalizer.Form.NFC);
	}
			
	// convert when get data from app
	public String convertToUnicode(String target){
		return Normalizer.normalize(target, Normalizer.Form.NFD);
	}
	
	// scroll to text value at android 
	public void androidScrollToText(String text){
		text = convertFromUnicode(text);
		applicationManagement.browserManagement
		.getCurrentWebDriver()
		.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""+ text + "\"))")).click();
	}
	
	/**
	 * Get Favorite List 
	 * 
	 * @author Drake
	 * @return list of item id of scroll list
	 * @throws InterruptedException 
	 */
	@RobotKeyword
	public List<String> getResultList() throws InterruptedException {
		@SuppressWarnings("unchecked")
		AndroidDriver<WebElement> driver = (AndroidDriver<WebElement>) applicationManagement.browserManagement.getCurrentWebDriver();
		WebDriverWait driverwaitBase = new WebDriverWait(applicationManagement.browserManagement.getCurrentWebDriver(), 300);
		//
		// List<String> favorList = new ArrayList<String>();
		// if(platform.equalsIgnoreCase(Constants.PLATFORM_IOS)){
		// if(!checkElementVisibility(noResult, 10)){
		// for(MobileElement item:listResult){
		// //System.out.println(item.findElementByName("List_Button_Favourite").getAttribute("value"));
		// if(("1").equalsIgnoreCase(item.findElementByName("List_Button_Favourite").getAttribute("value"))){
		// waitMsec(200);
		// favorList.add(item.getAttribute("name"));
		// }
		// waitMsec(300);
		// }
		// }
		// }else{
		// if(!checkElementVisibility(noResult, 10)){
		// driverwaitBase.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.id("ch.autoscout24.autoscout24.alpha:id/list"))));

		List<String> resultList = new ArrayList<String>();

		List<String> lastList = new ArrayList<String>();
		Thread.sleep(5000);
		
		boolean flag = true;
		String breakItem = "";
		// waitMsec(500);

		while (flag) {
			try {
				/**
				 * Drake : Specific elements to scroll for each application
				 * 
				 */
				List<WebElement> listRealResult = driver.findElementsById("ch.immoscout24.ImmoScout24.alpha:id/cardViewIncluder");
				List<WebElement> listValue = driver.findElementsByXPath("//*[@resource-id ='ch.immoscout24.ImmoScout24.alpha:id/recycleView']/android.widget.FrameLayout");
				//List<WebElement> listResult = driver.findElementsById("ch.immoscout24.ImmoScout24.alpha:id/index_view");
				List<WebElement> listScroll = driver.findElementsById("ch.immoscout24.ImmoScout24.alpha:id/view_pager");
				
//				List<WebElement> listRealResult = element.elementFind("id=ch.immoscout24.ImmoScout24.alpha:id/cardViewIncluder", false, true);
//				List<WebElement> listValue = element.elementFind("//*[@resource-id ='ch.immoscout24.ImmoScout24.alpha:id/recycleView']/android.widget.FrameLayout", false, true);
//				List<WebElement> listResult = element.elementFind("id=ch.immoscout24.ImmoScout24.alpha:id/index_view", false, true);
//				List<WebElement> listScroll = element.elementFind("id=ch.immoscout24.ImmoScout24.alpha:id/image_view", false, true);
				
				TouchAction action = new TouchAction ((MobileDriver) applicationManagement.browserManagement.getCurrentWebDriver());
				int listSize = listRealResult.size() - 1;
				if (listSize == 0)
					listSize = 1;

				List<String> compareList = new ArrayList<String>();
				for (int i = 0; i <= listSize - 1 ; i++) {
					compareList.add(listValue.get(i).getAttribute("name"));
				}
//				System.out.println("Last list " + lastList);
//				System.out.println("compare list " + compareList);

				// this part is used to list has page break
//				if(checkElementVisibility("ch.autoscout24.autoscout24.alpha:id/txtLoadingMessage",3)){
//					 WebDriverWait driverwaitBase2 = new WebDriverWait(driver, 5);
//					 driverwaitBase2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ch.autoscout24.autoscout24.alpha:id/txtLoadingMessage")));
//				 //compareList.remove(0);
//				 }

				if (lastList.containsAll(compareList)) {
					System.out.println("Duplicate");
					flag = false;

//					System.out.println("compare list " + compareList);
					resultList.add(listValue.get(listSize).getAttribute("name"));
				} else {

					lastList = new ArrayList<String>();
					lastList.addAll(compareList);

					if (compareList.indexOf(breakItem) != -1) {
						List<String> tempList = compareList.subList(compareList.indexOf(breakItem) + 1,
								compareList.size());

						resultList.addAll(tempList);
					} else
						resultList.addAll(compareList);

//					System.out.println("Result list " + resultList);

					breakItem = listValue.get((listSize - 1)).getAttribute("name");

					Thread.sleep(1000);
					
//					int scrHeight = driver.manage().window().getSize().height;
//					int scrWidth = driver.manage().window().getSize().width;
					

					Point start = new Point(0, 0);
					Point end = new Point(0, 0);
					start.x = getCenter(listScroll.get(1)).x;
					start.y = listScroll.get(listSize-1).getLocation().y;
					end.x = getCenter(listScroll.get(0)).x;

					action.longPress(start.x, start.y).moveTo(end.x, 130).release().perform();
					Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}
		}
		// }
		// }
		System.out.println("Result list " + resultList);
		System.out.println("Result list size " + resultList.size());
		return resultList;
		// }
	}
	
	@RobotKeyword
	@ArgumentNames({"appName", "testName"})
	public void startEyesTest(String appName, String testName){
		applicationManagement.eyes.open(applicationManagement.browserManagement.getCurrentWebDriver(), appName, testName);
		applicationManagement.eyes.setSaveNewTests(true);
	}
	
	@RobotKeyword
	@ArgumentNames({"desciption"})
	public void checkWindow(String desciption){
		applicationManagement.eyes.checkWindow(desciption);
	}
	
	@RobotKeyword
	public void endEyesTest(){
		try{
			TestResults testResults = applicationManagement.eyes.close(false);		
		}
		finally {
			applicationManagement.eyes.abortIfNotClosed();
		}
	}

	public void testApplitool() throws InterruptedException{
		AndroidDriver<WebElement> driver = (AndroidDriver<WebElement>) applicationManagement.browserManagement.getCurrentWebDriver();
		WebDriver driver2 = applicationManagement.browserManagement.getCurrentWebDriver();
//		applicationManagement.eyes.open(applicationManagement.browserManagement.getCurrentWebDriver(), "Immo24", "TestImmo");
//		applicationManagement.eyes.checkWindow("Popup Screen");
		startEyesTest("Immo24", "TestImmo");
		checkWindow("Popup Screen");
		element.clickElement("android=text(\"English\")");
		Thread.sleep(1000);
		checkWindow("Popup Screen 2");
//		applicationManagement.eyes.checkWindow("Popup Screen 2");
//		try{
//			TestResults testResults = applicationManagement.eyes.close(false);		
//			//applicationManagement.eyes.close();
//		}catch (EyesException e){
//			
//		}
//		finally {
//			applicationManagement.eyes.abortIfNotClosed();
//		}
//		
		endEyesTest();
		startEyesTest("Immo24", "TestImmo 2");
		element.clickElement("android=text(\"Dismiss\")");
		Thread.sleep(1000);
		element.clickElement("content_desc=Navigate up");
		Thread.sleep(2000);
		
		checkWindow("Menu Screen");
		endEyesTest();
		
//		applicationManagement.eyes.open(applicationManagement.browserManagement.getCurrentWebDriver(), "Immo24", "Test Element");
//		WebElement test = (WebElement) driver2.findElement(By.className("android.widget.ImageButton"));
//		//WebElement test = element.elementFind("content_desc=Navigate up)", true, true).get(0);
//		//test.click();
//		applicationManagement.eyes.checkRegion(test,10,"test");
//		try{
//			TestResults testResults = applicationManagement.eyes.close(false);		
//		}
//		finally {
//			applicationManagement.eyes.abortIfNotClosed();
//		}
//
		applicationManagement.closeApplication();
		
		
		
		
	}
	// ##############################
	// Internal Methods
	// ##############################

}