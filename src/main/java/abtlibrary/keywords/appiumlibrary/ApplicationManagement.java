package abtlibrary.keywords.appiumlibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;

import abtlibrary.ABTLibraryFatalException;
import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.selenium2library.BrowserManagement;
import abtlibrary.keywords.selenium2library.Logging;

@SuppressWarnings("deprecation")
@RobotKeywords
public class ApplicationManagement extends RunOnFailureKeywordsAdapter {

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
	
	protected Eyes eyes;

	// ##############################
	// Keywords
	// ##############################

	/**
	 * Close the current application.
	 */
	@RobotKeyword
	public void closeApplication() {
		if (browserManagement.webDriverCache.getCurrentSessionId() != null) {
			logging.debug(String.format("Closing application with session id %s",
					browserManagement.webDriverCache.getCurrentSessionId()));
			browserManagement.webDriverCache.close();
		}
	}

	/**
	 * Closes all open application instances and resets the browser cache.<br>
	 */
	@RobotKeyword
	public void closeAllApplications() {
		logging.debug("Closing all applications");
		browserManagement.webDriverCache.closeAll();
	}

	/**
	 * Opens a new application to given Appium server. <br>
	 * Capabilities of appium server, Android and iOS, Please check
	 * http://appium.io/slate/en/master/?python#appium-server-capabilities<br>
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td><b>Option</b></td>
	 * <td><b>Man.<b></td>
	 * <td><b>Description</b></td>
	 * </tr>
	 * <tr>
	 * <td>remoteUrl</td>
	 * <td>Yes</td>
	 * <td>appium server url</td>
	 * </tr>
	 * <tr>
	 * <td>alias</td>
	 * <td>No</td>
	 * <td>alias</td>
	 * </tr>
	 * <tr>
	 * <td>appPath</td>
	 * <td>Yes</td>
	 * <td>path to application under test</td>
	 * </tr>
	 * <tr>
	 * <td>deviceName</td>
	 * <td>Yes</td>
	 * <td>device name of android device or udid of iOS device</td>
	 * </tr>
	 * <tr>
	 * <td>platformVersion</td>
	 * <td>Yes</td>
	 * <td>OS version</td>
	 * </tr>
	 * </table>
	 * <br>
	 * <b>Example</b>
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td>Open Application</td>
	 * <td>http://localhost:4723/wd/hub</td>
	 * <td>MyAndroidApp</td>
	 * <td>${CURDIR}/demoapp/Android.apk</td>
	 * <td>16f48745</td>
	 * <td>5.0</td>
	 * </tr>
	 * </table>
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td>Open Application</td>
	 * <td>http://localhost:4723/wd/hub</td>
	 * <td>${CURDIR}/demoapp/iOS.app</td>
	 * <td>16f48745456323</td>
	 * <td>5.0</td>
	 * </tr>
	 * </table>
	 * 
	 * @param remoteUrl
	 *            remoteURl
	 * @param alias
	 *            alias of application instance
	 * @param appPath
	 *            Absolute path to apk file
	 * @param deviceName
	 *            Device name or udid
	 * @param platformVersion
	 *            Platform version
	 * @return Session Id
	 */
	@RobotKeyword
	@ArgumentNames({ "remoteUrl", "alias", "appPath", "deviceName", "platformVersion" })
	public String openApplication(String remoteUrl, String alias, String appPath, String deviceName,
			String platformVersion) {
		WebDriver driver;
		String platformName = appPath.contains(".apk") ? "Android" : "iOS";
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", appPath);
		cap.setCapability("platformName", platformName);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("deviceName", deviceName);
		

		try {
			if (platformName.equals("Android")) {
				driver = new AndroidDriver<>(new URL(remoteUrl), cap);
				
			} else{
				cap.setCapability("autoAcceptAlerts", false);
				driver = new IOSDriver<>(new URL(remoteUrl), cap);
			}

			String sessionId = browserManagement.webDriverCache.register(driver, alias, platformName);
			logging.debug(String.format("Openning '%s' driver to base application '%s'", platformName, appPath));
			driver.manage().timeouts().implicitlyWait((int) (browserManagement.implicitWait * 1000.0),
					TimeUnit.MILLISECONDS);
			return sessionId;
		} catch (Throwable t) {
			logging.warn(String.format("Openning '%s' driver to base application '%s' failed", platformName, appPath));
			throw new ABTLibraryFatalException(t);
		}
	}

	/**
	 * Scroll screen to the specified text.
	 * 
	 * @param text
	 *            specified text.
	 */
	@RobotKeyword
	@ArgumentNames({"text"})
	public WebElement scrollTo(String text) {
		return ((AppiumDriver<?>) browserManagement.getCurrentWebDriver()).scrollTo(text);
	}

	/**
	 * Scroll screen to the specified text.
	 * 
	 * @param text
	 *            specified text.
	 */
	@RobotKeyword
	@ArgumentNames({"text"})
	public WebElement scrollToExact(String text) {
		return ((AppiumDriver<?>) browserManagement.getCurrentWebDriver()).scrollToExact(text);
	}
	
	
	
	/**
	 * Enable applitool to run cloud server 
	 * 
	 * @param APIKey 
	 * 				test
	 * @param matchLevel 
	 * 					test
	 * @param deviceName 
	 * 					test
	 */
	@RobotKeyword
	@ArgumentNames({"APIKey", "matchLevel", "deviceName"})
	public void enableApplitool(String APIKey, String matchLevel, String deviceName){
				eyes = new Eyes();
				//eyes.setApiKey("Eyt18cF9exK4109txbzzE2ij0isWh8D2zFdts3vYVOhIg110");
				eyes.setApiKey(APIKey);
				eyes.setMatchLevel(MatchLevel.valueOf(matchLevel));
				//eyes.setMatchLevel(MatchLevel.LAYOUT2);
				eyes.setHostOS(deviceName);
				
	}
	
	// ##############################
	// Internal Methods
	// ##############################
	/*
	 * protected DesiredCapabilities createDesiredCapabilities(String
	 * desiredCapabilitiesString) { DesiredCapabilities desiredCapabilities =
	 * new DesiredCapabilities();
	 * 
	 * if (desiredCapabilitiesString != null &&
	 * !"None".equals(desiredCapabilitiesString)) { JSONObject jsonObject =
	 * (JSONObject) JSONValue.parse(desiredCapabilitiesString); if (jsonObject
	 * != null) { // Valid JSON Iterator<?> iterator =
	 * jsonObject.entrySet().iterator(); while (iterator.hasNext()) { Entry<?,
	 * ?> entry = (Entry<?, ?>) iterator.next();
	 * desiredCapabilities.setCapability(entry.getKey().toString(),
	 * entry.getValue()); } } else { // Invalid JSON. Old style key-value pairs
	 * for (String capability : desiredCapabilitiesString.split(",")) { String[]
	 * keyValue = capability.split(":"); if (keyValue.length == 2) {
	 * desiredCapabilities.setCapability(keyValue[0], keyValue[1]); } else {
	 * logging.warn("Invalid desiredCapabilities: " +
	 * desiredCapabilitiesString); } } } } return desiredCapabilities; }
	 */
	
}