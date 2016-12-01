package abtlibrary.keywords.appiumlibrary;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

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
		((MobileDriver) browserManagement.getCurrentWebDriver()).swipe(startx, starty, endx, endy, duration);
	}
	
	@RobotKeyword
	@ArgumentNames({"window", "locator"})
	public void zoom(String window, String locator){
		MobileDriver driver = (MobileDriver) browserManagement.getCurrentWebDriver();
		WebElement item = element.elementFind(window, locator, true, true).get(0);
		driver.zoom(item);
	}
	
	@RobotKeyword
	@ArgumentNames({"window", "locator"})
	public void longPress(String window, String locator){
		MobileDriver driver = (MobileDriver) browserManagement.getCurrentWebDriver();
		WebElement item = element.elementFind(window, locator, true, true).get(0);
		TouchAction longPress = new TouchAction(driver).longPress(item);
		longPress.perform();
	}
	
//	@RobotKeyword
//	@ArgumentNames({"coordinate_X","coordinate_Y"})
//	public void clickElementAtCoorDinates(int x, int y){
//		MobileDriver driver = (MobileDriver) browserManagement.getCurrentWebDriver();
//		TouchAction longPress = new TouchAction(driver).press(x, y).release();
//		longPress.perform();
//	}
}
