import java.util.List;

import abtlibrary.keywords.appiumlibrary.ApplicationManagement;
import abtlibrary.keywords.appiumlibrary.KeyEvent;
import abtlibrary.keywords.appiumlibrary.MobileElement;
import abtlibrary.keywords.selenium2library.Element;

public class test {
	
	static ApplicationManagement applicationManagement = new ApplicationManagement();
	static MobileElement mobile = new MobileElement();
	static Element element = new Element();
	static KeyEvent key = new KeyEvent();
	
	
	public static void main(String[] args) throws InterruptedException{
		applicationManagement.openApplication("http://localhost:4723/wd/hub", "Android","/Users/huyhua/Downloads/ImmoScout24.apk", "192.168.57.101:5555", "5.1");
		element.clickElement("android=text(\"English\")");
		element.clickElement("android=text(\"Dismiss\")");
		element.clickElement("content_desc=ContentText");
		Thread.sleep(2000);
		key.pressKeyCode(66);
		element.clickElement("content_desc=Search_BtnSearch");
		Thread.sleep(5000);
		List<String> results = mobile.scrollAndGetItemNames("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout");
		System.out.println(results.toString());
	}
}
