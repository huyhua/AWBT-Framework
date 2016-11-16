import org.robotframework.remoteserver.RemoteServer;

public class ABTLibrary extends abtlibrary.ABTLibrary {

	public ABTLibrary(String timeout, String implicitWait, String runOnFailure) {
		super(timeout, implicitWait, runOnFailure);
	}

	public ABTLibrary(String timeout, String implicitWait) {
		super(timeout, implicitWait);
	}

	public ABTLibrary(String timeout) {
		super(timeout);
	}

	public ABTLibrary() {
		super();
	}

	public static void main(String[] args) throws Exception {
		int port = Integer.parseInt("8270");
		RemoteServer.configureLogging();
		RemoteServer server = new RemoteServer();
		server.putLibrary("/RPC2",new ABTLibrary());
		server.setPort(port);
		server.start();
		
		String appium_url= "http://localhost:4732/wd/hub";
		String android_app= "/Users/jenkins/Downloads/is24-alpha-v3.2.2_522670.apk";
		String android_device="192.168.56.101:5555";
		String android_version="5.1";
		ABTLibrary test = new ABTLibrary();
		test.applicationManagement.openApplication(appium_url, "android", android_app, android_device, android_version);
		test.element.clickElement("android=text(\"English\")");
		Thread.sleep(1000);
		test.element.clickElement("android=text(\"Dismiss\")");
		test.element.clickElement("content_desc=Navigate up");
		test.element.clickElement("//*[@text=\"Sign in\"]");
		test.formElement.inputText("content_desc=Login_TxtEmail", "noahh@gmail.com");
		test.formElement.inputPassword("content_desc=Login_TxtPassword", "testtest");
		test.element.clickElement("content_desc=Login_BtnLogin");
		test.element.clickElement("content_desc=Navigate up");
		test.element.clickElement("content_desc=Global_BtnFavorites");
		test.mobileElement.getResultList();
	}
}
