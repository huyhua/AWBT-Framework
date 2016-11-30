package abtlibrary.keywords.appiumlibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;

import abtlibrary.ABTLibraryFatalException;
import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.selenium2library.BrowserManagement;
import abtlibrary.keywords.selenium2library.Logging;
import abtlibrary.utils.HttpRequestUtils;

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
			logging.debug(String.format(
					"Closing application with session id %s",
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
	@ArgumentNames({ "remoteUrl", "alias", "appPath", "deviceName",
			"platformVersion" })
	public String openApplication(String remoteUrl, String alias,
			String appPath, String deviceName, String platformVersion) {
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

			} else {
				cap.setCapability("autoAcceptAlerts", false);
				driver = new IOSDriver<>(new URL(remoteUrl), cap);
			}

			String sessionId = browserManagement.webDriverCache.register(
					driver, alias, platformName);
			logging.debug(String.format(
					"Openning '%s' driver to base application '%s'",
					platformName, appPath));
			driver.manage()
					.timeouts()
					.implicitlyWait(
							(int) (browserManagement.implicitWait * 1000.0),
							TimeUnit.MILLISECONDS);
			return sessionId;
		} catch (Throwable t) {
			logging.warn(String.format(
					"Openning '%s' driver to base application '%s' failed",
					platformName, appPath));
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
	@ArgumentNames({ "text" })
	public WebElement scrollTo(String text) {
		return ((AppiumDriver<?>) browserManagement.getCurrentWebDriver())
				.scrollTo(text);
	}

	/**
	 * Scroll screen to the specified text.
	 * 
	 * @param text
	 *            specified text.
	 */
	@RobotKeyword
	@ArgumentNames({ "text" })
	public WebElement scrollToExact(String text) {
		return ((AppiumDriver<?>) browserManagement.getCurrentWebDriver())
				.scrollToExact(text);
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
	
	@RobotKeywordOverload
	@ArgumentNames({ "appId", "versionId"})
	public void downloadFromHockeyApp(String appId, String versionId){
		
		String defaultAPIToken = "19c4f87dde6444e89388a33b1077624e";
		downloadFromHockeyApp(appId, versionId, defaultAPIToken);
	}
	
	@RobotKeywordOverload
	@ArgumentNames({ "appId", "versionId","apiToken=19c4f87dde6444e89388a33b1077624e"})
	public void downloadFromHockeyApp(String appId, String versionId, String apiToken){
		downloadFromHockeyApp(appId, versionId, apiToken, null);
	}

	@RobotKeywordOverload
	@ArgumentNames({ "appId", "versionId","apiToken=19c4f87dde6444e89388a33b1077624e", "appPath=NONE"})
	public void downloadFromHockeyApp(String appId, String versionId,
			String apiToken, String appPath){
		downloadFromHockeyApp(appId, versionId, apiToken, appPath, null);
	}
	
	@RobotKeyword
	@ArgumentNames({ "appId", "versionId","apiToken=19c4f87dde6444e89388a33b1077624e", "appPath=NONE", "appFileName=NONE" })
	public void downloadFromHockeyApp(String appId, String versionId,
			String apiToken, String appPath, String appFileName) {
		FileOutputStream fos;
		String unfilteredURL = getHockeyAppDownloadURL(appId, versionId, apiToken);
		try {
			String fileExtension = "";
			if (appFileName == null || appFileName.isEmpty()){
				fileExtension = unfilteredURL.substring(unfilteredURL.lastIndexOf("/")+1);
			}else{
				fileExtension = appFileName.substring(appFileName.lastIndexOf(".") + 1);
			}
			
			//Remove the sneaky /appExtension at the end and change download link so that it actually contains the file.
			String filteredURL = unfilteredURL.substring(0,unfilteredURL.lastIndexOf("/")).replace("/apps/", "/api/2/apps/");
			
			String baseURL = filteredURL + "?format="+fileExtension+"&avtoken=" + apiToken;
			System.out.println(baseURL);
			HttpURLConnection con = (HttpURLConnection) new URL(baseURL).openConnection();

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				
				// If appPath is not specified
				if (appPath == null || appPath.isEmpty()) {
					appPath = System.getProperty("user.dir") + File.separator + "target";
				}
				
				// If filename is not specified
				if (appFileName == null || appFileName.isEmpty()) {
					String disposition = con
							.getHeaderField("Content-Disposition");
					if (disposition == null
							|| !disposition.contains("filename=\"")) {
						// extracts file name from URL
						appFileName = baseURL.substring(
								baseURL.lastIndexOf("/") + 1, baseURL.length()) + fileExtension;
					} else {
						// extracts file name from header field
						int index = disposition.indexOf("filename=\"");
						appFileName = disposition.substring(index + 10, disposition.length() - 1);
					}
				}
				File appFile = new File(appPath + File.separator + appFileName);
				appFile.getParentFile().mkdirs();
				ReadableByteChannel rbc = Channels.newChannel(con
						.getInputStream());
				fos = new FileOutputStream(appFile);
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
				rbc.close();
			} else {
				System.out.println("No file to download. Server replied HTTP code: " + responseCode);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getHockeyAppDownloadURL(String appId, String appVersion,
			String apiToken) {
		String request = "https://rink.hockeyapp.net/api/2/apps/" + appId
				+ "/app_versions";

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("X-HockeyAppToken", apiToken);

		String jsonResponse = HttpRequestUtils.getResponse(request, "GET",
				headers);
		JSONObject doc = HttpRequestUtils.parseStringIntoJson(jsonResponse);
		JSONArray arr = (JSONArray) doc.get("app_versions");
		Iterator<JSONObject> it = arr.iterator();
		while (it.hasNext()) {
			JSONObject item = it.next();
			if (item.containsValue(appVersion)) {
				if(((String)item.get("title")).contains("Android")){
					return (String) item.get("download_url") + "/apk";
				} else {
					return (String) item.get("download_url") + "/ipa";
				}
				
			}
		}

		return null;
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