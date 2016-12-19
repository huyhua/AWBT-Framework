package abtlibrary.keywords.appiumlibrary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.script.ScriptException;

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
import abtlibrary.keywords.frameworklibrary.Action;
import abtlibrary.keywords.selenium2library.BrowserManagement;
import abtlibrary.keywords.selenium2library.Logging;
import abtlibrary.utils.HttpRequestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

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

	@Autowired
	protected Action action;

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
	 * <br>
	 * <b>Example</b>
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td></td>
	 * <td><b>device</b></td>
	 * <td><b>version</b></td>
	 * <td><b>alias</b></td>
	 * <td><b>file path</b></td>
	 * <td><b>appium server</b></td>
	 * </tr>
	 * <tr>
	 * <td><b>Open Application</b></td>
	 * <td>16f48745</td>
	 * <td>5.0</td>
	 * <td>/demoapp/Android.apk</td>
	 * <td>MyAndApp</td>
	 * <td>http://localhost:4723/wd/hub</td>
	 * </tr>
	 * </table>
	 * <br>
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td></td>
	 * <td><b>device</b></td>
	 * <td><b>version</b></td>
	 * <td><b>alias</b></td>
	 * <td><b>file path</b></td>
	 * <td><b>appium server</b></td>
	 * </tr>
	 * <tr>
	 * <td><b>Open Application</b></td>
	 * <td>16f48745</td>
	 * <td>9.0.3</td>
	 * <td>/demoapp/iOS.ipa</td>
	 * <td>MyiOSApp</td>
	 * <td>http://localhost:4723/wd/hub</td>
	 * </tr>
	 * </table>
	 * <br>
	 * 
	 * @param device
	 *            Name of android device or udid of ios device.
	 * @param version
	 *            Android or iOS version.
	 * @param filePath
	 *            Absolute path to application file. application instance.
	 * @param alias
	 *            Alias of application instance. This alias is used to switch to
	 * @param appiumServer
	 *            Address of appium server.
	 * @return Application session id.
	 */
	@RobotKeyword
	@ArgumentNames({ "device", "version", "filePath", "alias=NONE", "appiumServer=NONE" })
	public String openApplication(String device, String version, String filePath, String alias, String appiumServer) {
		WebDriver driver;
		String platform = filePath.contains(".apk") ? "Android" : "iOS";

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", filePath);
		cap.setCapability("platformName", platform);
		// cap.setCapability("platformVersion", version);
		cap.setCapability("deviceName", device);

		try {
			if (platform.equals("Android")) {
				driver = new AndroidDriver<>(new URL(appiumServer), cap);

			} else {
				cap.setCapability("autoAcceptAlerts", false);
				driver = new IOSDriver<>(new URL(appiumServer), cap);
			}

			String sessionId = browserManagement.webDriverCache.register(driver, alias, platform);
			logging.debug(String.format("Openning '%s' driver to base application '%s'", platform, filePath));
			driver.manage().timeouts().implicitlyWait((int) (browserManagement.implicitWait * 1000.0),
					TimeUnit.MILLISECONDS);
			return sessionId;
		} catch (Throwable t) {
			logging.warn(String.format("Openning '%s' driver to base application '%s' failed", platform, filePath));
			throw new ABTLibraryFatalException(t);
		}
	}

	@RobotKeywordOverload
	public String openApplication(String device, String version, String filePath, String alias) {
		return openApplication(device, version, filePath, alias, "http://localhost:4723/wd/hub");
	}

	@RobotKeywordOverload
	public String openApplication(String device, String version, String filePath) {
		return openApplication(device, version, filePath, "");
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
		return ((AppiumDriver<?>) browserManagement.getCurrentWebDriver()).scrollTo(text);
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
		return ((AppiumDriver<?>) browserManagement.getCurrentWebDriver()).scrollToExact(text);
	}

	/**
	 * Enable applitool to run cloud server
	 * 
	 * @param APIKey
	 *            test
	 * @param matchLevel
	 *            test
	 * @param deviceName
	 *            test
	 */
	@RobotKeyword
	@ArgumentNames({ "APIKey", "matchLevel", "deviceName" })
	public void enableApplitool(String APIKey, String matchLevel, String deviceName) {
		eyes = new Eyes();
		// eyes.setApiKey("Eyt18cF9exK4109txbzzE2ij0isWh8D2zFdts3vYVOhIg110");
		eyes.setApiKey(APIKey);
		eyes.setMatchLevel(MatchLevel.valueOf(matchLevel));
		// eyes.setMatchLevel(MatchLevel.LAYOUT2);
		eyes.setHostOS(deviceName);
	}

	@RobotKeywordOverload
	public String downloadFromHockeyApp(String appId, String path) throws ScriptException {
		return downloadFromHockeyApp(appId, null, path);
	}

	@RobotKeywordOverload
	public String downloadFromHockeyApp(String appId, String versionId, String path) throws ScriptException {
		return downloadFromHockeyApp(appId, versionId, null, path);
	}

	@RobotKeywordOverload
	public String downloadFromHockeyApp(String appId, String versionId, String appPath, String path)
			throws ScriptException {
		return downloadFromHockeyApp(appId, versionId, appPath, null, path);
	}

	@RobotKeywordOverload
	public String downloadFromHockeyApp(String appId, String versionId, String appPath, String appFileName, String path)
			throws ScriptException {
		return downloadFromHockeyApp(appId, versionId, appPath, appFileName, null, path);
	}

	/**
	 * Fetch the app file from Hockeyapps using the <b>appId</b> and
	 * <b>versionId</b> <br>
	 * <br>
	 * 
	 * @param appId
	 *            The id of the app as specified in the manage page of
	 *            HockeyApps
	 * @param versionId
	 *            Default=NONE. The absolute version id of the app, as seen in
	 *            the "code" column on HockeyApps manage site. If empty get
	 *            latest.
	 * @param appPath
	 *            Default=NONE. Location of the download app. If not specify it
	 *            will be located in the target folder inside the project.
	 * @param appFileName
	 *            Default=NONE. Name of the app file. If not specified it will
	 *            be the first word of the app title retrieved from HockeyApps.
	 * @param apiToken
	 *            Default=19c4f87dde6444e89388a33b1077624e. Optional apiKey.
	 * @param return
	 *            Name of variable is used to store app path after downloading.
	 * @return The appPath + appName
	 * @throws ScriptException
	 */
	@RobotKeyword
	@ArgumentNames({ "appId", "versionId=NONE", "appPath=NONE", "appFileName=NONE",
			"apiToken=19c4f87dde6444e89388a33b1077624e", "return=NONE" })
	public String downloadFromHockeyApp(String appId, String versionId, String appPath, String appFileName,
			String apiToken, String path) throws ScriptException {
		FileOutputStream fos;
		if (apiToken == null || apiToken.isEmpty()) {
			apiToken = "19c4f87dde6444e89388a33b1077624e";
		}

		HockeyAppVersionItem downloadVersion = getHockeyAppVersion(appId, versionId, apiToken);

		try {
			String fileExtension = "";
			if (appFileName == null || appFileName.isEmpty()) {
				if (downloadVersion.title.contains("Android")) {
					fileExtension = "apk";
				} else {
					fileExtension = "ipa";
				}
			} else {
				fileExtension = appFileName.substring(appFileName.lastIndexOf(".") + 1);
			}

			// Change the download link to direct download link that contains
			// the actual file
			String baseURL = downloadVersion.downloadURL.replace("/apps/", "/api/2/apps/") + "?format=" + fileExtension
					+ "&avtoken=" + apiToken;
			HttpURLConnection con = (HttpURLConnection) new URL(baseURL).openConnection();
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {

				// If appPath is not specified
				if (appPath == null || appPath.isEmpty()) {
					appPath = System.getProperty("user.dir") + File.separator + "target";
				}

				// If filename is not specified
				if (appFileName == null || appFileName.isEmpty()) {
					String redirect = con.getURL().toString();
					if (redirect == null) {
						// extracts file name from downloadVersion
						appFileName = downloadVersion.title.substring(0, downloadVersion.title.indexOf(" ")) + "-"
								+ downloadVersion.version + "." + fileExtension;
					} else {
						// extracts file name from URL
						int index = redirect.lastIndexOf("/");
						appFileName = redirect.substring(index + 1);
					}
				}
				File appFile = new File(appPath + File.separator + appFileName);
				appFile.getParentFile().mkdirs();

				if (appFile.exists() && !appFile.isDirectory() && appFile.length() == downloadVersion.fileSize) {
					if (!path.equalsIgnoreCase("NONE")) {
						action.setVariable(path, appFile.getCanonicalPath());
					}
					return appFile.getCanonicalPath();
				}

				ReadableByteChannel rbc = Channels.newChannel(con.getInputStream());
				fos = new FileOutputStream(appFile);
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
				rbc.close();

				// check file size and log a warning if the size is different
				if (appFile.length() != downloadVersion.fileSize) {
					logging.warn("App size different! Downloaded size is " + appFile.length() + ". Expected size is "
							+ downloadVersion.fileSize);
				}
				if (!path.equalsIgnoreCase("NONE")) {
					action.setVariable(path, appFile.getCanonicalPath());
				}
				return appFile.getCanonicalPath();
			} else {
				throw new ABTLibraryFatalException("No file to download. Server replied HTTP code: " + responseCode);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private HockeyAppVersionItem getHockeyAppVersion(String appId, String appVersion, String apiToken) {
		String request = "https://rink.hockeyapp.net/api/2/apps/" + appId + "/app_versions";

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("X-HockeyAppToken", apiToken);

		String jsonResponse = HttpRequestUtils.getResponse(request, "GET", headers);
		JSONObject doc = HttpRequestUtils.parseStringIntoJson(jsonResponse);
		JSONArray arr = (JSONArray) doc.get("app_versions");

		// Get latest item if appVersion is empty
		if (appVersion == null || appVersion.isEmpty()) {
			return new HockeyAppVersionItem((JSONObject) arr.get(0));
		}

		Iterator<JSONObject> it = arr.iterator();
		while (it.hasNext()) {
			HockeyAppVersionItem item = new HockeyAppVersionItem(it.next());
			if (item.version.equals(appVersion)) {
				return item;
			}
		}
		throw new ABTLibraryFatalException(
				"Could not get download link. Probably app id or app version is not correct");
	}

	protected static class HockeyAppVersionItem {
		String version;
		String shortVersion;
		String title;
		String id;
		String appId;
		String downloadURL;
		Long fileSize;

		public HockeyAppVersionItem(JSONObject item) {
			version = (String) item.get("version");
			shortVersion = (String) item.get("shortversion");
			title = (String) item.get("title");
			id = ((Long) item.get("id")).toString();
			appId = ((Long) item.get("app_id")).toString();
			downloadURL = (String) item.get("download_url");
			fileSize = (Long) item.get("appsize");
		}
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