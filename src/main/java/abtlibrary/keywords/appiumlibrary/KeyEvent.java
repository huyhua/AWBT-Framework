package abtlibrary.keywords.appiumlibrary;

import io.appium.java_client.android.AndroidDriver;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.selenium2library.BrowserManagement;

@RobotKeywords
public class KeyEvent extends RunOnFailureKeywordsAdapter {
	
	/**
	 * Instantiated BrowserManagement keyword bean
	 */
	@Autowired
	protected BrowserManagement browserManagement;
	
	@RobotKeyword
	@ArgumentNames({"key"})
	public void pressKeyCode(int key) {
		((AndroidDriver<?>) browserManagement.getCurrentWebDriver()).pressKeyCode(key);
	}
	
	@RobotKeyword
	@ArgumentNames({"key"})
	public void longPressKeyCode(int key){
		((AndroidDriver<?>) browserManagement.getCurrentWebDriver()).longPressKeyCode(key);
	}
}
