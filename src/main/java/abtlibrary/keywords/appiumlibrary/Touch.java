package abtlibrary.keywords.appiumlibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.selenium2library.BrowserManagement;
import abtlibrary.keywords.selenium2library.Element;
import abtlibrary.keywords.selenium2library.Logging;
import abtlibrary.keywords.selenium2library.SelectElement;

@RobotKeywords
public class Touch extends RunOnFailureKeywordsAdapter {
	/**
	 * Instantiated BrowserManagement keyword bean
	 */
	@Autowired
	protected BrowserManagement browserManagement;

	/**
	 * Instantiated Logging keyword bean
	 */
	@Autowired
	protected Logging logging;
	
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

	@RobotKeyword
	@ArgumentNames({"startx", "starty", "endx", "endy", "duration"})
	public void swipe(int startx,int starty,int endx,int endy,int duration){
		((AppiumDriver<?>) browserManagement.getCurrentWebDriver()).swipe(startx, starty, endx, endy, duration);
	}
	
	@RobotKeyword
	@ArgumentNames({"locator"})
	public void zoom(String locator){
		AppiumDriver<?> driver = (AppiumDriver<?>) browserManagement.getCurrentWebDriver();
		WebElement item = element.elementFind(locator, true, true).get(0);
		driver.zoom(item);
	}
	
	@RobotKeyword
	@ArgumentNames({"locator"})
	public void longPress(String locator){
		AppiumDriver<?> driver = (AppiumDriver<?>) browserManagement.getCurrentWebDriver();
		WebElement item = element.elementFind(locator, true, true).get(0);
		TouchAction longPress = new TouchAction(driver).longPress(item);
		longPress.perform();
	}
	
	@RobotKeyword
	@ArgumentNames({"coordinate_X","coordinate_Y"})
	public void clickElementAtCoorDinates(int x, int y){
		AppiumDriver<?> driver = (AppiumDriver<?>) browserManagement.getCurrentWebDriver();
		TouchAction longPress = new TouchAction(driver).press(x, y).release();
		longPress.perform();
	}
}
