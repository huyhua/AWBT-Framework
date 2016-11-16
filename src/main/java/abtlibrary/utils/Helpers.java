package abtlibrary.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Helpers {

	private static TouchAction action;
	private static AppiumDriver<MobileElement> driver;
	private static WebDriverWait driverWait;

	/**
	 * Find element based on its AccessibilityID/ContentDescription
	 * 
	 * @param id
	 * @return 1st MobileElement that satisfies the requirements
	 */
	public static MobileElement accessibilityId(String id) {
		return element(for_accessibilityId(id));
	}

	/**
	 * Find element based on its AccessibilityID/ContentDescription
	 * 
	 * @param id
	 * @return a List of mobileElement satisfying the requirements
	 */
	public static List<MobileElement> accessibilityIds(String id) {
		return elements(for_accessibilityId(id));
	}

	/**
	 * Press the back button *
	 */
	public static void back() {
		driver.navigate().back();
	}

	/**
	 * return all child elements of an element by locator
	 */
	public static List<MobileElement> childElement(MobileElement element,
			By locator) {
		return element.findElements(locator);
		
	}

	/**
	 * Use the keyboard to delete text instead of Appium Default method
	 */
	public static void clearText(By locator) {
		MobileElement element = element(locator);
		String text = element.getText();

		for (int i = 0; i < text.length(); i++) {
			driver.getKeyboard().sendKeys(Keys.BACK_SPACE);
		}
	}

	public static void confirmAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * Modify the timeOut duration of the driver.
	 * 
	 * @param seconds
	 */
	public static void timeOut(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Return an element by locator *
	 */
	public static MobileElement element(By locator) {
		return w(driver.findElement(locator));
	}

	/**
	 * Return a list of elements by locator *
	 */
	public static List<MobileElement> elements(By locator) {
		return driver.findElements(locator);
	}

	/**
	 * By Object is used as a locator for Wait methods. this utilizes
	 * accessibilityID
	 * 
	 * @param id
	 * @return
	 */
	public static By for_accessibilityId(String id) {
		return MobileBy.AccessibilityId(id);
	}

	/**
	 * By Object is used as a locator for Wait methods. this utilizes
	 * UiAutomator by android
	 * 
	 * @param id
	 * @return
	 */
	public static By for_android(String path) {
		return MobileBy.AndroidUIAutomator(path);
	}

	/**
	 * Return button that matches the text
	 */

	public static By for_id(String id) {
		return By.id(id);
	}

	public static By for_resourceId(String id) {
		return MobileBy
				.AndroidUIAutomator("new UiSelector().resourceId(UiDevice.getInstance(getInstrumentation()).getCurrentPackageName() + \":/id\" + \""
						+ id + "\")");
	}

	public static By for_ios(String path) {
		return MobileBy
				.IosUIAutomation("UIATarget.localTarget().frontMostApp().mainWindow()."
						+ path);
	}

	/**
	 * Return a tag name locator *
	 */
	public static By for_tags(String tagName) {
		return By.className(tagName);
	}

	/**
	 * Return a static text locator that contains text *
	 */
	public static By for_text(String text) {
		String up = text.toUpperCase();
		String down = text.toLowerCase();
		return By
				.xpath("//*[@visible=\"true\" and (contains(translate(@name,\""
						+ up + "\",\"" + down + "\"), \"" + down
						+ "\") or contains(translate(@hint,\"" + up + "\",\""
						+ down + "\"), \"" + down
						+ "\") or contains(translate(@label,\"" + up + "\",\""
						+ down + "\"), \"" + down
						+ "\") or contains(translate(@value,\"" + up + "\",\""
						+ down + "\"), \"" + down + "\"))]");
	}

	/**
	 * 
	 * @param tag
	 * @param text
	 * @return Mobile Element that matches both tag and text name
	 */
	public static By for_text_and_tag(String tag, String text) {
		String up = text.toUpperCase();
		String down = text.toLowerCase();
		return By.xpath("//" + tag
				+ "[@visible=\"true\" and (contains(translate(@name,\"" + up
				+ "\",\"" + down + "\"), \"" + down
				+ "\") or contains(translate(@hint,\"" + up + "\",\"" + down
				+ "\"), \"" + down + "\") or contains(translate(@label,\"" + up
				+ "\",\"" + down + "\"), \"" + down
				+ "\") or contains(translate(@value,\"" + up + "\",\"" + down
				+ "\"), \"" + down + "\"))]");
	}

	/**
	 * Return a static text locator by exact text *
	 */
	public static By for_text_exact(String text) {
		return By.xpath("//*[@visible='true' and (@name='" + text
				+ "' or @hint='" + text + "' or @label='" + text
				+ "' or @value='" + text + "')]");
	}

	/**
	 * Return element using Google uiAutomator. Valid for android test only
	 */
	public static AndroidElement googleAutomator(String text) {

		return (AndroidElement) element(for_android(text));
	}
	
	

	/**
	 * Return element using Google uiAutomator. Valid for android test only
	 * 
	 * @param text
	 * @return A list of all android element satisfying requirements
	 */
	public static List<MobileElement> googleAutomators(String text) {

		return elements(for_android(text));
	}

	/**
	 * Initialize the webdriver. Must be called before using any helper methods.
	 * *
	 */
	public static void init(AppiumDriver<MobileElement> webDriver) {
		driver = webDriver;
		action = new TouchAction(webDriver);
		int timeoutInSeconds = 60;
		// must wait at least 60 seconds for running on Sauce.
		// waiting for 30 seconds works locally however it fails on Sauce.
		driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
	}

	public static MobileElement resourceId(String id) {
		return element(for_resourceId(id));
	}

	public static List<MobileElement> resourceIds(String id) {
		return elements(for_resourceId(id));
	}

	public static void scrollPage() {
		int scrHeight = driver.manage().window().getSize().height;
		int scrWidth = driver.manage().window().getSize().width;

		action.press(scrWidth / 2, scrHeight - 1).moveTo(0, -scrHeight / 2)
				.release().perform();
	}

	/**
	 * Scroll to an element
	 */
	@SuppressWarnings("serial")
	public static Object scrollTo(final MobileElement el) {
		return driver.executeScript("mobile: scrollTo",
				new HashMap<String, String>() {
					{
						put("element", el.getId());
					}
				});
	}

	/**
	 * Search for element using its className. Should be "android.widget..." or
	 * "UIA..." in case of iOS
	 * 
	 * @param tagName
	 * @return A list of all element satisfying requirements
	 */
	public static MobileElement tag(String tagName) {
		return element(for_tags(tagName));
	}

	/**
	 * Search for element using its className. Should be "android.widget..." or
	 * "UIA..." in case of iOS
	 * 
	 * @param tagName
	 * @return
	 */
	public static List<MobileElement> tags(String tagName) {
		return elements(for_tags(tagName));
	}

	@SuppressWarnings("serial")
	public static void tapElementExact(By locator) {
		final double x = element(locator).getCenter().getX();
		final double y = element(locator).getCenter().getY();
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {
			{
				put("tapCount", 1.0);
				put("touchCount", 1.0);
				put("duration", 0.3);
				put("x", x);
				put("y", y);
			}
		});
	}
	
	@SuppressWarnings("serial")
	public static void tapElementExact(MobileElement el) {
		final double x = el.getCenter().getX();
		final double y = el.getCenter().getY();
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {
			{
				put("tapCount", 1.0);
				put("touchCount", 1.0);
				put("duration", 0.3);
				put("x", x);
				put("y", y);
			}
		});
	}


	/**
	 * Return a static text element that contains text *
	 */
	public static MobileElement text(String text) {
		return element(for_text(text));
	}

	/**
	 * Return a static text element by exact text *
	 */
	public static MobileElement text_exact(String text) {
		return element(for_text_exact(text));
	}

	public static List<MobileElement> text_exacts(String text) {
		return elements(for_text_exact(text));
	}

	public static List<MobileElement> texts(String text) {
		return elements(for_text(text));
	}

	public static boolean tryAction(Consumer<AppiumDriver<MobileElement>> action) {
		try {
			timeOut(2);
			action.accept(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			timeOut(30);
		}
	}

	/**
	 * Allow user to turn the page in android test
	 * 
	 * @param direction
	 */
	public static void androidTurnPage(SwipeElementDirection direction) {
		int scrHeight = driver.manage().window().getSize().height;
		int scrWidth = driver.manage().window().getSize().width;
		switch (direction) {
		case LEFT:
			driver.swipe(scrWidth - 1, scrHeight * 2 / 3, 1, scrHeight * 2 / 3,
					500);
			break;
		case RIGHT:
			driver.swipe(200, scrHeight * 2 / 3, scrWidth - 2,
					scrHeight * 2 / 3, 500);
			break;
		default:
			break;
		}
		waitSec(1);

	}

	/**
	 * Rather than the set value method, this fills text using Keyboard. Slow
	 * but sure.
	 */
	public static void typeKeyboard(String text) {
		String[] fracture = text.split("");
		for (int i = 0; i < fracture.length; i++) {
			driver.getKeyboard().sendKeys(fracture[i]);
		}
	}

	/**
	 * Return element using uiAutomation strategy. Valid for iOS only
	 */
	public static IOSElement uiAutomation(String text) {
		return (IOSElement) element(for_ios(text));
	}

	public static List<MobileElement> uiAutomations(String text) {
		return elements(for_ios(text));
	}

	/**
	 * Wrap WebElement in MobileElement *
	 */
	private static List<MobileElement> w(List<WebElement> elements) {
		List<MobileElement> list = new ArrayList<MobileElement>(elements.size());
		for (WebElement element : elements) {
			list.add(w(element));
		}

		return list;
	}

	/**
	 * Wrap WebElement in MobileElement *
	 */
	private static MobileElement w(WebElement element) {
		return (MobileElement) element;
	}

	/**
	 * Wait 30 seconds for locator to find an element *
	 */
	public static MobileElement wait(By locator) {
		return w(driverWait.until(ExpectedConditions.presenceOfElementLocated(locator)));
	}
	
	public static MobileElement wait(By locator, int timeout) {
		return w(driverWait.withTimeout(timeout, TimeUnit.SECONDS).until(ExpectedConditions
				.visibilityOfElementLocated(locator)));
	}
	

	/**
	 * 
	 * wait 10 secs for an element to disappear. If element is not disappear,
	 * throw TimeoutException. If element cannot be found, skip the method after
	 * 10 sec as if it is passed.
	 */
	public static boolean waitUntilDisappear(By locator) {
		try {
			timeOut(5);
			driverWait.withTimeout(10, TimeUnit.SECONDS).until(ExpectedConditions
					.invisibilityOfElementLocated(locator));
			return true;
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;
		} finally {
			timeOut(30);
		}
	}
	
	public static void waitUntilDisappear(By locator, int timeout) {
		try {
			timeOut(5);
			driverWait.withTimeout(timeout, TimeUnit.SECONDS).until(ExpectedConditions
					.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			timeOut(30);
		}
	}

	public static void waitUntilDisappear(MobileElement el) {
		try {
			timeOut(5);
			driverWait.until(ExpectedConditions.stalenessOf(el));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			timeOut(30);
		}
	}

	/**
	 * wait until there's an alert present. Default time is current default
	 * driver wait time
	 */
	public static Alert waitForPopUp() {
		driverWait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}

	/**
	 * wait until there's an alert present. Default time is current default
	 * driver wait time
	 */
	public static void waitForPopUp(int timeout) {
		driverWait.withTimeout(timeout, TimeUnit.SECONDS).until(
				ExpectedConditions.alertIsPresent());
	}

	/**
	 * Wait 60 seconds for locator to find all elements *
	 */
	public static List<MobileElement> waitAll(By locator) {
		return w(driverWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(locator)));
	}

	/**
	 * Sleep the thread for an amount of time
	 */
	public static void waitMsec(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sleep the thread for an amount of time
	 */
	public static void waitSec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static MobileElement xpath(String path) {
		return element(By.xpath(path));
	}

	public static List<MobileElement> xpaths(String path) {
		return elements(By.xpath(path));
	}

	/**
	 * Allow user to turn the page in ios test
	 * 
	 * @param direction
	 */
	public static void iosScrollUp(MobileElement element) {
		String id = element.getId();
		waitMsec(500);
		driver.executeScript("au.getElement('" + id + "').scrollUp()");
	}

	/**
	 * Allow user to turn the page in ios test
	 * 
	 * @param direction
	 */
	public static void iosScrollLeft(MobileElement element) {
		
		String id = element.getId();
		waitMsec(500);
		driver.executeScript("au.getElement('" + id + "').scrollLeft()");
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "rigth");
		scrollObject.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scroll", scrollObject);*/
	}

	/**
	 * Allow user to turn the page in ios test
	 * 
	 * @param direction
	 */
	public static void iosScrollDown(MobileElement element) {
		String id = element.getId();
		waitMsec(500);
		driver.executeScript("au.getElement('" + id + "').scrollDown()");
	}
	
	public static void iosDragdown(MobileElement element) {
		String id = element.getId();
		waitMsec(500);
		driver.executeScript("au.getElement('" + id + "').dragInsideWithOptions({startOffset:{x:0.5, y:0.75}, endOffset:{x:0.5, y:0.25}, duration:0.25})");
	}

	/**
	 * Allow user to turn the page in ios test
	 * 
	 * @param direction
	 */
	public static void iosScrollRight(MobileElement element) {

		String id = element.getId();
		waitMsec(500);
		driver.executeScript("au.getElement('" + id + "').scrollRight()");
	}

	/**
	 * Find element using name strategy
	 */
	public static MobileElement name(String name) {
		return element(By.name(name));
	}

	/**
	 * Search the element using name strategy. This equals the Text of said
	 * element.
	 * 
	 * @param names
	 * @return
	 */
	public static List<MobileElement> names(String names) {
		return elements(By.name(names));
	}

	/**
	 * Check if there's any element available using the supplied By strategy.
	 * return false if NoSuchElementException is thrown. Default check time is a
	 * fixed 2 seconds.
	 * 
	 * @param locator
	 * @return
	 */
	public static boolean elementIsDisplayed(By locator) {
		try {
			timeOut(2);
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			timeOut(30);
		}
	}

	/**
	 * Minimize the app for a duration of time
	 * 
	 * @param seconds
	 */
	public static void mimimizeApp(int seconds) {
		driver.runAppInBackground(seconds);
		try {
			waitForPopUp(3);
		} catch (TimeoutException e) {
			System.out.println("No Pop Up present. Skipping");
		}
	}
	
	public static void switchOutOfApp(){
		waitSec(2);
		String context = (String) driver.getContextHandles().toArray()[1];
		driver.context(context);
	}
	
	public static void switchBackToApp(){
		waitMsec(600);
		driver.context("NATIVE_APP");
	}
	

}
