package abtlibrary.keywords.appiumlibrary;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.selenium2library.BrowserManagement;
import abtlibrary.keywords.selenium2library.Element;
import abtlibrary.keywords.selenium2library.Logging;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

@RobotKeywords
public class KeyEvent extends RunOnFailureKeywordsAdapter {

	/**
	 * Instantiated BrowserManagement keyword bean
	 */
	@Autowired
	protected BrowserManagement browserManagement;

	/**
	 * Instantiated Element keyword bean
	 */
	@Autowired
	protected Element element;

	/**
	 * Instantiated Logging keyword bean
	 */
	@Autowired
	protected Logging logging;

	public static void main(String[] args) {
		KeyEvent event = new KeyEvent();
		// System.out.println(keyCode.ENTER.get());
		event.pressKey("SEARCH");
	}

	@RobotKeyword
	@ArgumentNames({ "key" })
	public void pressKeyCode(int key) {
		((AndroidDriver<?>) browserManagement.getCurrentWebDriver()).pressKeyCode(key);
	}

	@RobotKeyword
	@ArgumentNames({ "key" })
	public void longPressKeyCode(int key) {
		((AndroidDriver<?>) browserManagement.getCurrentWebDriver()).longPressKeyCode(key);
	}

	/**
	 * Press key on android. <br>
	 * Valid keys: <b>ENTER</b>, <b>DOWN</b>, <b>UP</b>, <b>BACK</b>,
	 * <b>BACKSPACE</b>
	 * 
	 * @param key
	 *            Input user key
	 */
	public void pressKey(String key) {
		try {
			int code = keyCode.valueOf(key.toUpperCase()).get();
			pressKeyCode(code);
		} catch (Exception e) {
			logging.warn(String.format("Key '%s' is invalid. Please use valid keys: ENTER, DOWN, UP, BACK, BACKSPACE.",
					key));
		}
	}

	/**
	 * Simulates pressing <b>key</b> on the control or on window.<br>
	 * <br>
	 * Example:<br>
	 * <b> Press ENTER on text_field</b><br>
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td></td>
	 * <td>window</td>
	 * <td>control</td>
	 * <td>key</td>
	 * </tr><tr>
	 * <td>Press Key</td>
	 * <td>my_window</td>
	 * <td>text_field</td>
	 * <td>ENTER</td>
	 * </tr>
	 * </table>
	* <b> Press ENTER on window</b><br>
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td></td>
	 * <td>window</td>
	 * <td>control</td>
	 * <td>key</td>
	 * </tr><tr>
	 * <td>Press Key</td>
	 * <td>*</td>
	 * <td>*</td>
	 * <td>ENTER</td>
	 * </tr>
	 * </table>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param key
	 *            The key to press.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "key" })
	public void pressKey(String window, String control, String key) {
		if (window.equals("*") && control.equals("*")) {
			pressKey(key);
		}
		else {
			try {
				key = asciiKeyCode.valueOf(key).get().toString();
			} catch (Exception e) {

			}
			List<WebElement> ele = element.elementFind(window, control, true, true);
			ele.get(0).sendKeys(key);
		}
	}

	// ##############################
	// Internal Method
	// ##############################
	public enum keyCode {
		ENTER(AndroidKeyCode.ENTER), DOWN(AndroidKeyCode.ACTION_DOWN), UP(AndroidKeyCode.ACTION_UP), BACK(
				AndroidKeyCode.BACK), BACKSPACE(AndroidKeyCode.BACKSPACE), SEARCH(AndroidKeyCode.KEYCODE_SEARCH);
		int code;

		keyCode(int code) {
			this.code = code;
		}

		int get() {
			return code;
		}
	}

	protected enum asciiKeyCode {
		NULL(Keys.NULL), BACKSPACE(Keys.BACK_SPACE), TAB(Keys.TAB), RETURN(Keys.RETURN), ENTER(Keys.ENTER), CANCEL(
				Keys.CANCEL), ESCAPE(Keys.ESCAPE), SPACE(Keys.SPACE), MULTIPLY(Keys.MULTIPLY), ADD(Keys.ADD), SEPARATOR(
						Keys.SEPARATOR), SUBTRACT(Keys.SUBTRACT), DECIMAL(Keys.DECIMAL), DIVIDE(
								Keys.DIVIDE), SEMICOLON(Keys.SEMICOLON), EQUALS(Keys.EQUALS), DELETE(Keys.DELETE);

		Keys key;

		asciiKeyCode(Keys key) {
			this.key = key;
		}

		Keys get() {
			return key;
		}
	}
}
