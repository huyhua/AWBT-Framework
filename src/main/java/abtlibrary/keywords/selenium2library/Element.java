package abtlibrary.keywords.selenium2library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.frameworklibrary.UserInterface;
import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.locators.ElementFinder;
import abtlibrary.utils.Python;

@RobotKeywords
public class Element extends RunOnFailureKeywordsAdapter {

	/**
	 * Instantiated BrowserManagement keyword bean
	 */
	@Autowired
	protected BrowserManagement browserManagement;

	/**
	 * Instantiated InterfaceManagement keyword bean
	 */
	@Autowired
	protected UserInterface userInterface;

	/**
	 * Instantiated FormElement keyword bean
	 */
	@Autowired
	protected FormElement formElement;

	/**
	 * Instantiated Logging keyword bean
	 */
	@Autowired
	protected Logging logging;

	// ##############################
	// Keywords - Element Lookups
	// ##############################

	/**
	 * Check if control identified by <b>locator</b> exists.<br>
	 * <br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name of select control.
	 * @return True if control exist and False if control not exist.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public Boolean doesControlExist(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, false);
		if (elements.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns the first Web Element.<br>
	 * <br>
	 * Fails if there is no control matched with <b>control</b>.<br>
	 * <br>
	 * Key attributes for arbitrary controls are id and name. See `Introduction`
	 * for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the select list.
	 * @return the Web Element
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public WebElement getWebElement(String window, String control) {

		return elementFind(window, control, true, true).get(0);
	}

	/**
	 * Returns list of Web Elements.<br>
	 * <br>
	 * Fails if there is no control matched with <b>control</b>.<br>
	 * <br>
	 * Key attributes for arbitrary controls are id and name. See `Introduction`
	 * for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the select list.
	 * @return the of Web Elements
	 */
	public List<WebElement> getWebElements(String window, String control) {

		return elementFind(window, control, false, true);
	}

	@RobotKeywordOverload
	@ArgumentNames({ "text" })
	public void checkCurrentFrameContains(String text) {
		checkCurrentFrameContains(text, "INFO");
	}

	/**
	 * Verify the current frame contains <b>text</b>.<br>
	 * <br>
	 * See `Introduction` for details about log levels.<br>
	 * 
	 * @param text
	 *            The text to verify.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "text", "logLevel=INFO" })
	public void checkCurrentFrameContains(String text, String logLevel) {
		if (!isTextPresent(text)) {
			logging.log(String.format("Current Frame Contains: %s => FAILED", text), logLevel);
			throw new ABTLibraryNonFatalException(
					String.format("Page should have contained text '%s', but did not.", text));
		} else {
			logging.log(String.format("Current Frame Contains: %s => OK", text), logLevel);
		}
	}

	@RobotKeywordOverload
	public void checkCurrentFrameNotContain(String text) {
		checkCurrentFrameNotContain(text, "INFO");
	}

	/**
	 * Verify the current frame does not contain <b>text</b>.<br>
	 * <br>
	 * See `Introduction` for details about log levels.<br>
	 * 
	 * @param text
	 *            The text to verify.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "text", "logLevel=INFO" })
	public void checkCurrentFrameNotContain(String text, String logLevel) {
		if (isTextPresent(text)) {
			logging.log(String.format("Current Frame Should Not Contain: %s => FAILED", text), logLevel);
			throw new ABTLibraryNonFatalException(
					String.format("Page should have not contained text '%s', but did.", text));
		} else {
			logging.log(String.format("Current Frame Should Not Contain: %s => OK", text), logLevel);
		}
	}

	@RobotKeywordOverload
	public void checkControlContains(String window, String control, String text) {
		checkControlContains(window, control, text, "");
	}

	/**
	 * Verify the control contains <b>text</b>.<br>
	 * <br>
	 * See `Introduction` for details about controls.
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the control.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkControlContains(String window, String control, String text, String message) {
		String actual = getText(window, control);

		if (!actual.toLowerCase().contains(text.toLowerCase())) {
			logging.info(String.format("control should contain: %s => FAILED", text));
			throw new ABTLibraryNonFatalException(
					String.format("control should have contained text '%s', but its text was '%s'.", text, actual));
		} else {
			logging.info(String.format("control should contain: %s => OK", text));
		}
	}

	@RobotKeywordOverload
	public void checkControlDoesNotContain(String window, String control, String text) {
		checkControlDoesNotContain(window, control, text, "");
	}

	/**
	 * Verify the control does not contain <b>text</b>.<br>
	 * <br>
	 * See `Introduction` for details about controls.
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the control.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkControlDoesNotContain(String window, String control, String text, String message) {
		String actual = getText(window, control);

		if (actual.toLowerCase().contains(text.toLowerCase())) {
			logging.info(String.format("control should not contain: %s => FAILED", text));
			throw new ABTLibraryNonFatalException(
					String.format("control should not have contained text '%s', but its text was %s.", text, actual));
		} else {
			logging.info(String.format("control Should Not Contain: %s => OK", text));
		}
	}

	@RobotKeywordOverload
	public void checkFrameContains(String window, String control, String text) {
		checkFrameContains(window, control, text, "INFO");
	}

	/**
	 * Verify the frame contains <b>text</b>.<br>
	 * <br>
	 * See `Introduction` for details about controls.
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the frame.
	 * @param text
	 *            The text to verify.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "logLevel=INFO" })
	public void checkFrameContains(String window, String control, String text, String logLevel) {
		if (!frameContains(window, control, text)) {
			logging.log(String.format("Frame Should Contain: %s => FAILED", text), logLevel);
			throw new ABTLibraryNonFatalException(
					String.format("Frame should have contained text '%s', but did not.", text));
		} else {
			logging.log(String.format("Frame Should Contain: %s => OK", text), logLevel);
		}
	}

	/**
	 * Verify the frame does not contain <b>text</b>.<br>
	 * <br>
	 * See `Introduction` for details about controls.
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the frame.
	 * @param text
	 *            The text to verify.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "logLevel=INFO" })
	public void checkFrameNotContain(String window, String control, String text, String logLevel) {
		if (frameContains(window, control, text)) {
			logging.log(String.format("Frame Should Not Contain: %s => FAILED", text), logLevel);
			throw new ABTLibraryNonFatalException(
					String.format("Frame should not have contained text '%s', but did.", text));
		} else {
			logging.log(String.format("Frame Should Not Contain: %s => OK", text), logLevel);
		}
	}

	@RobotKeywordOverload
	public void checkTextInPage(String text) {
		checkTextInPage(text, "INFO");
	}

	/**
	 * Verify the current page contains <b>text</b>.<br>
	 * <br>
	 * See `Introduction` for details about log levels.<br>
	 * 
	 * @param text
	 *            The text to verify.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "text", "logLevel=INFO" })
	public void checkTextInPage(String text, String logLevel) {
		if (!pageContains(text)) {
			logging.log(String.format("Page Should Contain: %s => FAILED", text), logLevel);
			throw new ABTLibraryNonFatalException(
					String.format("Page should have contained text '%s' but did not.", text));
		} else {
			logging.log(String.format("Page Should Contain: %s => OK", text), logLevel);
		}
	}

	@RobotKeywordOverload
	public void checkTextNotInPage(String text) {
		checkTextNotInPage(text, "INFO");
	}

	/**
	 * Verify the current page does not contain <b>text</b>.<br>
	 * <br>
	 * See `Introduction` for details about log levels.<br>
	 * 
	 * @param text
	 *            The text to verify.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "text", "logLevel=INFO" })
	public void checkTextNotInPage(String text, String logLevel) {
		if (pageContains(text)) {
			logging.log(String.format("Page Should Not Contain: %s => FAILED", text), logLevel);
			throw new ABTLibraryNonFatalException(
					String.format("Page should not have contained text '%s' but did.", text));
		} else {
			logging.log(String.format("Page Should Not Contain: %s => OK", text), logLevel);
		}
	}

	@RobotKeywordOverload
	public void checkPageContainsControl(String window, String control) {
		checkPageContainsControl(window, control, "", "INFO");
	}

	@RobotKeywordOverload
	public void checkPageContainsControl(String window, String control, String message) {
		checkPageContainsControl(window, control, message, "INFO");
	}

	/**
	 * Verify the control is found on the current page.<br>
	 * <br>
	 * See `Introduction` for details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageContainsControl(String window, String control, String message, String logLevel) {
		checkPageContainsControl(window, control, null, message, "INFO");
	}

	protected void checkPageContainsControl(String window, String control, String tag, String message,
			String logLevel) {
		String name = tag != null ? tag : "element";
		if (!isElementPresent(window, control, tag)) {
			if (message == null || message.equals("")) {
				message = String.format("Page should have contained %s '%s' but did not", name, control);
			}
			logging.log(message, logLevel);
			throw new ABTLibraryNonFatalException(message);
		} else {
			logging.log(String.format("Current page contains %s '%s'.", name, control), logLevel);
		}
	}

	@RobotKeywordOverload
	public void checkPageNotContainControl(String window, String control) {
		checkPageNotContainControl(window, control, "", "INFO");
	}

	@RobotKeywordOverload
	public void checkPageNotContainControl(String window, String control, String message) {
		checkPageNotContainControl(window, control, message, "INFO");
	}

	/**
	 * Verify the control is not found on the current page.<br>
	 * <br>
	 * See `Introduction` for details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageNotContainControl(String window, String control, String message, String logLevel) {
		checkPageNotContainControl(window, control, null, message, "INFO");
	}

	protected void checkPageNotContainControl(String window, String control, String tag, String message,
			String logLevel) {
		String name = tag != null ? tag : "element";
		if (isElementPresent(window, control, tag)) {
			if (message == null || message.equals("")) {
				message = String.format("Page should not have contained %s '%s' but did", name, control);
			}
			logging.log(message, logLevel);
			throw new ABTLibraryNonFatalException(message);
		} else {
			logging.log(String.format("Current page does not contain %s '%s'.", name, control), logLevel);
		}
	}

	// ##############################
	// Keywords - Attributes
	// ##############################

	/**
	 * Assigns a temporary identifier to the control identified by
	 * <b>control</b><br>
	 * <br>
	 * This is mainly useful, when the control is a complicated and slow XPath
	 * expression. The identifier expires when the page is reloaded.<br>
	 * <br>
	 * Example:
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td>Assign ID to Element</td>
	 * <td>xpath=//div[@id=\"first_div\"]</td>
	 * <td>my id</td>
	 * </tr>
	 * <tr>
	 * <td>Page Should Contain Element</td>
	 * <td>my id</td>
	 * <td></td>
	 * </tr>
	 * </table>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param id
	 *            The id to assign.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "id" })
	public void assignIdToControl(String window, String control, String id) {
		logging.info(String.format("Assigning temporary id '%s' to control '%s'", id, control));
		List<WebElement> elements = elementFind(window, control, true, true);

		((JavascriptExecutor) browserManagement.getCurrentWebDriver())
				.executeScript(String.format("arguments[0].id = '%s';", id), elements.get(0));
	}

	/**
	 * Verify the control is enabled.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void checkControlEnabled(String window, String control) {
		if (!isEnabled(window, control)) {
			throw new ABTLibraryNonFatalException(String.format("Element %s is disabled.", control));
		}
	}

	/**
	 * Verify the control is disabled.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void checkControlDisabled(String window, String control) {
		if (isEnabled(window, control)) {
			throw new ABTLibraryNonFatalException(String.format("Element %s is enabled.", control));
		}
	}

	@RobotKeywordOverload
	public void checkControlSelected(String window, String control) {
		checkControlSelected(window, control, "");
	}

	/**
	 * Verify the control is selected.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE" })
	public void checkControlSelected(String window, String control, String message) {
		logging.info(String.format("Verifying control '%s' is selected.", control));
		boolean selected = isSelected(window, control);

		if (!selected) {
			if (message == null || message.equals("")) {
				message = String.format("Element '%s' should be selected, but it is not.", control);
			}
			throw new ABTLibraryNonFatalException(message);
		}
	}

	@RobotKeywordOverload
	public void checkControlNotSelected(String window, String control) {
		checkControlNotSelected(window, control, "");
	}

	/**
	 * Verify the control is not selected.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE" })
	public void checkControlNotSelected(String window, String control, String message) {
		logging.info(String.format("Verifying control '%s' is not selected.", control));
		boolean selected = isSelected(window, control);

		if (selected) {
			if (message == null || message.equals("")) {
				message = String.format("Element '%s' should not be selected, but it is.", control);
			}
			throw new ABTLibraryNonFatalException(message);
		}
	}

	@RobotKeywordOverload
	public void checkControlVisible(String window, String control) {
		checkControlVisible(window, control, "");
	}

	/**
	 * Verify the control is visible.<br>
	 * <br>
	 * Herein, visible means that the control is logically visible, not
	 * optically visible in the current browser viewport. For example, an
	 * control that carries display:none is not logically visible, so using this
	 * keyword on that control would fail.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE" })
	public void checkControlVisible(String window, String control, String message) {
		logging.info(String.format("Verifying control '%s' is visible.", control));
		boolean visible = isVisible(window, control);

		if (!visible) {
			if (message == null || message.equals("")) {
				message = String.format("Element '%s' should be visible, but it is not.", control);
			}
			throw new ABTLibraryNonFatalException(message);
		}
	}

	@RobotKeywordOverload
	public void checkControlNotVisible(String window, String control) {
		checkControlNotVisible(window, control, "");
	}

	/**
	 * Verify the control is not visible.<br>
	 * <br>
	 * Herein, visible means that the control is logically visible, not
	 * optically visible in the current browser viewport. For example, an
	 * control that carries display:none is not logically visible, so using this
	 * keyword on that control would fail.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE" })
	public void checkControlNotVisible(String window, String control, String message) {
		logging.info(String.format("Verifying control '%s' is not visible.", control));
		boolean visible = isVisible(window, control);

		if (visible) {
			if (message == null || message.equals("")) {
				message = String.format("Element '%s' should not be visible, but it is.", control);
			}
			throw new ABTLibraryNonFatalException(message);
		}
	}

	@RobotKeywordOverload
	public void checkControlClickable(String window, String control) {
		checkControlClickable(window, control, "");
	}

	/**
	 * Verify the control is clickable.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE" })
	public void checkControlClickable(String window, String control, String message) {
		logging.info(String.format("Verifying control '%s' is clickable.", control));
		boolean clickable = isClickable(window, control);

		if (!clickable) {
			if (message == null || message.equals("")) {
				message = String.format("Element '%s' should be clickable, but it is not.", control);
			}
			throw new ABTLibraryNonFatalException(message);
		}
	}

	@RobotKeywordOverload
	public void checkControlNotClickable(String window, String control) {
		checkControlNotClickable(window, control, "");
	}

	/**
	 * Verify the control is not clickable.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE" })
	public void checkControlNotClickable(String window, String control, String message) {
		logging.info(String.format("Verifying control '%s' is not clickable.", control));
		boolean clickable = isClickable(window, control);

		if (clickable) {
			if (message == null || message.equals("")) {
				message = String.format("Element '%s' should not be clickable, but it is.", control);
			}
			throw new ABTLibraryNonFatalException(message);
		}
	}

	@RobotKeywordOverload
	public void checkTextInControl(String window, String control, String expected) {
		checkTextInControl(window, control, expected, "");
	}

	/**
	 * Verify the text of the control is exactly <b>text</b>.<br>
	 * <br>
	 * In contrast to `Element Should Contain`, this keyword does not try a
	 * substring match but an exact match on the control. <br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkTextInControl(String window, String control, String text, String message) {
		List<WebElement> elements = elementFind(window, control, true, true);
		String actual = elements.get(0).getText();

		if (!text.equals(actual)) {
			if (message == null || message.equals("")) {
				message = String.format("The text of control '%s' should have been '%s', but it was '%s'.", control,
						text, actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
	}

	@RobotKeywordOverload
	public void checkTextNotInControl(String window, String control, String expected) {
		checkTextNotInControl(window, control, expected, "");
	}

	/**
	 * Verify the text of the control is not exactly <b>text</b>.<br>
	 * <br>
	 * In contrast to `Check Control Not Contain`, this keyword does not try a
	 * substring match but an exact match on the control. <br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkTextNotInControl(String window, String control, String text, String message) {
		List<WebElement> elements = elementFind(window, control, true, true);
		String actual = elements.get(0).getText();

		if (text.equals(actual)) {
			if (message == null || message.equals("")) {
				message = String.format("The text of control '%s' should have been '%s', but it was '%s'.", control,
						text, actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
	}

	/**
	 * Returns the value of an control attribute.<br>
	 * <br>
	 * The <b>attribute_control</b> consists of control followed by an @ sign
	 * and attribute name. Example: element_id@class<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param attributecontrol
	 *            The attribute control.
	 * @return The attribute value.
	 */
	@RobotKeyword
	@ArgumentNames({ "attributecontrol" })
	public String getElementAttribute(String attributecontrol) {
		String[] parts = parseAttributecontrol(attributecontrol);

		List<WebElement> elements = elementFind("", parts[0], true, false);

		if (elements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("Element '%s' not found.", parts[0]));
		}

		return elements.get(0).getAttribute(parts[1]);
	}

	/**
	 * Clears the text from control.<br>
	 * <br>
	 * This keyword does not execute any checks on whether or not the clear
	 * method has succeeded, so if any subsequent checks are needed, they should
	 * be executed using method `Element Text Should Be`.<br>
	 * <br>
	 * Also, this method will use WebDriver's internal _element.clear()_ method,
	 * i.e. it will not send any keypresses, and it will not have any effect
	 * whatsoever on elements other than input textfields or input textareas.
	 * Clients relying on keypresses should implement their own methods.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void clearText(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, true);

		elements.get(0).clear();
	}

	/**
	 * Returns inner control id by index<b></b> of control identified by
	 * <b>control</b> which is matched by <b>matchid</b>.<br>
	 * <br>
	 * The position is returned in pixels off the left side of the page, as an
	 * integer. Fails if the matching control is not found.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param matchid
	 *            partial inner control id to match
	 * @param index
	 *            position of the inner control to match
	 * @return The control id
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "matchid", "index" })
	public String getInnerElementId(String window, String control, String matchid, int index) {
		List<WebElement> elements = elementFind(window, control, true, true);

		if (elements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("get Inner control '%s' not found.", control));
		}

		String xpathId = ".//*[contains(@id," + matchid + ")]";

		List<WebElement> tmpe = elements.get(0).findElements((By.xpath(xpathId)));
		if (tmpe.size() == 0) {
			throw new ABTLibraryNonFatalException(
					String.format("No Inner control '%s' not found by '%s'", control, matchid));
		}
		String eId = tmpe.get(index).getAttribute("id");

		logging.info(String.format("Found control ID: '%s'.", eId));

		return eId;

	}

	/**
	 * Returns horizontal position of control.<br>
	 * <br>
	 * The position is returned in pixels off the left side of the page, as an
	 * integer. Fails if the matching control is not found.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @return The horizontal position
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public int getHorizontalPosition(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, false);

		if (elements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("Could not determine position for '%s'.", control));
		}

		return elements.get(0).getLocation().getX();
	}

	/**
	 * Returns the value attribute of the control. <br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @return The value attribute of the element.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public String getValue(String window, String control) {
		return getValue(window, control, null);
	}

	protected String getValue(String window, String control, String tag) {
		List<WebElement> elements = elementFind(window, control, true, false, tag);

		if (elements.size() == 0) {
			return null;
		}

		return elements.get(0).getAttribute("value");
	}

	/**
	 * Returns the text of the control.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @return The text of the element.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public String getText(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, true);

		if (elements.size() == 0) {
			return null;
		}
		return elements.get(0).getText();
	}

	/**
	 * Returns vertical position of control.<br>
	 * <br>
	 * The position is returned in pixels off the top of the page, as an
	 * integer. Fails if the matching control is not found.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @return The vertical position
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public int getVerticalPosition(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, false);

		if (elements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("Could not determine position for '%s'.", control));
		}

		return elements.get(0).getLocation().getY();
	}

	// ##############################
	// Keywords - Mouse Input/Events
	// ##############################

	/**
	 * Click on the control.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void click(String window, String control) {
		logging.info(String.format("Clicking control '%s'.", control));
		List<WebElement> elements = elementFind(window, control, true, true);

		elements.get(0).click();
	}

	/**
	 * Click on the control at the coordinates <b>xOffset</b> and <b>yOffset</b>
	 * .<br>
	 * <br>
	 * The cursor is moved at the center of the control and the to the given x/y
	 * offset from that point. Both offsets are specified as negative (left/up)
	 * or positive (right/down) number.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * <br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param xOffset
	 *            The horizontal offset in pixel. Negative means left, positive
	 *            right.
	 * @param yOffset
	 *            The vertical offset in pixel. Negative means up, positive
	 *            down.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "xOffset", "yOffset" })
	public void clickAtCoordinates(String window, String control, String xOffset, String yOffset) {
		logging.info(String.format("Clicking control '%s'in coordinates '%s', '%s'.", control, xOffset, yOffset));
		List<WebElement> elements = elementFind(window, control, true, true);

		WebElement element = elements.get(0);
		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.moveToElement(element).moveByOffset(Integer.parseInt(xOffset), Integer.parseInt(yOffset)).perform();
	}

	/**
	 * Double-Click on the control.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void doubleClick(String window, String control) {
		logging.info(String.format("Double clicking control '%s'.", control));

		List<WebElement> elements = elementFind(window, control, true, true);
		Actions action = new Actions(browserManagement.getCurrentWebDriver());

		action.doubleClick(elements.get(0)).perform();
	}

	/**
	 * Set the focus to the control.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void focus(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, true);
		((JavascriptExecutor) browserManagement.getCurrentWebDriver()).executeScript("arguments[0].focus();",
				elements.get(0));
	}

	/**
	 * Drag the control identified by the control <b>source</b> and move it on
	 * top of the control identified by the control <b>target</b>.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * <br>
	 * Example:
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td>Drag And Drop</td>
	 * <td>elem1</td>
	 * <td>elem2</td>
	 * <td># Move elem1 over elem2</td>
	 * </tr>
	 * </table>
	 * 
	 * @param source
	 *            The control to locate the control to drag.
	 * @param target
	 *            The control to locate the control where to drop the dragged
	 *            element.
	 */
	@RobotKeyword
	@ArgumentNames({ "source", "target" })
	public void dragAndDrop(String source, String target) {
		List<WebElement> sourceElements = elementFind("", source, true, true);
		List<WebElement> targetElements = elementFind("", target, true, true);

		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.dragAndDrop(sourceElements.get(0), targetElements.get(0)).perform();
	}

	/**
	 * Drag the control identified by the control <b>source</b> and move it by
	 * <b>xOffset</b> and <b>yOffset</b>.<br>
	 * <br>
	 * Both offsets are specified as negative (left/up) or positive (right/down)
	 * number.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * <br>
	 * Example:
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td>Drag And Drop By Offset</td>
	 * <td>elem1</td>
	 * <td>50</td>
	 * <td>35</td>
	 * <td># Move elem1 50px right and 35px down.</td>
	 * </tr>
	 * </table>
	 * 
	 * @param source
	 *            The control to locate the control to drag.
	 * @param xOffset
	 *            The horizontal offset in pixel. Negative means left, positive
	 *            right.
	 * @param yOffset
	 *            The vertical offset in pixel. Negative means up, positive
	 *            down.
	 */
	@RobotKeyword
	@ArgumentNames({ "source", "xOffset", "yOffset" })
	public void dragAndDropByOffset(String source, int xOffset, int yOffset) {
		List<WebElement> elements = elementFind("", source, true, true);

		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.dragAndDropBy(elements.get(0), xOffset, yOffset).perform();
	}

	/**
	 * Simulates pressing the left mouse button on the control identified by
	 * <b>control</b>.<br>
	 * <br>
	 * The control is pressed without releasing the mouse button.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @see Element#mouseDownOnImage
	 * @see Element#mouseDownOnLink
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void mouseDown(String window, String control) {
		logging.info(String.format("Simulating Mouse Down on control '%s'.", control));
		List<WebElement> elements = elementFind(window, control, true, false);

		if (elements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("ERROR: control %s not found.", control));
		}

		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.clickAndHold(elements.get(0)).perform();
	}

	/**
	 * Simulates moving the mouse away from the control identified by
	 * <b>control</b>.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void mouseOut(String window, String control) {
		logging.info(String.format("Simulating Mouse Out on control '%s'.", control));
		List<WebElement> elements = elementFind(window, control, true, false);

		if (elements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("ERROR: control %s not found.", control));
		}

		WebElement element = elements.get(0);
		Dimension size = element.getSize();
		int offsetX = size.getWidth() / 2 + 1;
		int offsetY = size.getHeight() / 2 + 1;

		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.moveToElement(element).moveByOffset(offsetX, offsetY).perform();
	}

	/**
	 * Simulates moving the mouse over the control. <br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void mouseOver(String window, String control) {
		logging.info(String.format("Simulating Mouse Over on control '%s'.", control));
		List<WebElement> elements = elementFind(window, control, true, false);

		if (elements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("ERROR: control %s not found.", control));
		}

		WebElement element = elements.get(0);
		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.moveToElement(element).perform();
	}

	/**
	 * Simulates releasing the left mouse button on the control identified by
	 * <b>control</b>.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void mouseUp(String window, String control) {
		logging.info(String.format("Simulating Mouse Up on control '%s'.", control));
		List<WebElement> elements = elementFind(window, control, true, false);

		if (elements.size() == 0) {
			throw new ABTLibraryNonFatalException(String.format("ERROR: control %s not found.", control));
		}

		WebElement element = elements.get(0);
		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.release(element).perform();
	}

	/**
	 * Opens the context menu on the control.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void openContextMenu(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, true);

		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.contextClick(elements.get(0)).perform();
	}

	/**
	 * Simulates the given <b>event</b> on the control identified by
	 * <b>control</b>.<br>
	 * <br>
	 * This keyword is especially useful, when the control has an OnEvent
	 * handler that needs to be explicitly invoked.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @param event
	 *            The event to invoke.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "event" })
	public void simulate(String window, String control, String event) {
		List<WebElement> elements = elementFind(window, control, true, true);
		String script = "element = arguments[0];" + "eventName = arguments[1];" + "if (document.createEventObject) {"
				+ "return element.fireEvent('on' + eventName, document.createEventObject());" + "}"
				+ "var evt = document.createEvent(\"HTMLEvents\");" + "evt.initEvent(eventName, true, true);"
				+ "return !element.dispatchEvent(evt);";

		((JavascriptExecutor) browserManagement.getCurrentWebDriver()).executeScript(script, elements.get(0), event);
	}

	/**
	 * Simulates pressing <b>key</b> on the control .<br>
	 * <br>
	 * Key is either a single character, or a numerical ASCII code of the key
	 * lead by '\\'.<br>
	 * <br>
	 * See `Introduction` for details about controls.<br>
	 * <br>
	 * Example:
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td>Press Key</td>
	 * <td>text_field</td>
	 * <td>q</td>
	 * <td># Press 'q'</td>
	 * </tr>
	 * <tr>
	 * <td>Press Key</td>
	 * <td>login_button</td>
	 * <td>\\13</td>
	 * <td># ASCII code for enter key</td>
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
		if (key.startsWith("\\") && key.length() > 1) {
			key = mapAsciiKeyCodeToKey(Integer.parseInt(key.substring(1))).toString();
		}
		List<WebElement> element = elementFind(window, control, true, true);
		element.get(0).sendKeys(key);
	}

	// ##############################
	// Keywords - Links
	// ##############################

	/**
	 * Click on the link.<br>
	 * <br>
	 * Key attributes for links are id, name, href and link text. See
	 * `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void clickLink(String window, String control) {
		logging.info(String.format("Clicking link '%s'.", control));
		List<WebElement> elements = elementFind(window, control, true, true, "a");

		elements.get(0).click();
	}

	/**
	 * Returns a list containing ids of all links found in current page.<br>
	 * <br>
	 * If a link has no id, an empty string will be in the list instead.<br>
	 * 
	 * @return The list of link ids.
	 */
	@RobotKeyword
	public ArrayList<String> getAllLinks() {
		ArrayList<String> ret = new ArrayList<String>();

		List<WebElement> elements = elementFind("", "tag=a", false, false, "a");
		for (WebElement element : elements) {
			ret.add(element.getAttribute("id"));
		}

		return ret;
	}

	/**
	 * Simulates pressing the left mouse button on the link identified by
	 * <b>control</b>.<br>
	 * <br>
	 * The control is pressed without releasing the mouse button.<br>
	 * <br>
	 * Key attributes for links are id, name, href and link text. See
	 * `Introduction` for details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @see Element#mouseDown
	 * @see Element#mouseDownOnImage
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void mouseDownOnLink(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, true, "link");

		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.clickAndHold(elements.get(0)).perform();
	}

	@RobotKeywordOverload
	@ArgumentNames({ "window", "control" })
	public void checkPageContainsLink(String window, String control) {
		checkPageContainsLink(window, control, "", "INFO");
	}

	@RobotKeywordOverload
	@ArgumentNames({ "window", "control", "message=NONE" })
	public void checkPageContainsLink(String window, String control, String message) {
		checkPageContainsLink(window, control, message, "INFO");
	}

	/**
	 * Verify the link is found on the current page.<br>
	 * <br>
	 * Key attributes for links are id, name, href and link text. See
	 * `Introduction` for details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the link.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageContainsLink(String window, String control, String message, String logLevel) {
		checkPageContainsControl(window, control, "link", message, logLevel);
	}

	@RobotKeywordOverload
	public void checkPageNotContainLink(String window, String control) {
		checkPageNotContainLink(window, control, "", "INFO");
	}

	@RobotKeywordOverload
	public void checkPageNotContainLink(String window, String control, String message) {
		checkPageNotContainLink(window, control, message, "INFO");
	}

	/**
	 * Verify the link is not found on the current page.<br>
	 * <br>
	 * Key attributes for links are id, name, href and link text. See
	 * `Introduction` for details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the link.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageNotContainLink(String window, String control, String message, String logLevel) {
		checkPageNotContainControl(window, control, "link", message, logLevel);
	}

	// ##############################
	// Keywords - Images
	// ##############################

	/**
	 * Click on the image.<br>
	 * <br>
	 * Key attributes for images are id, src and alt. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void clickImage(String window, String control) {
		logging.info(String.format("Clicking image '%s'.", control));

		List<WebElement> elements = elementFind(window, control, true, false, "image");

		if (elements.size() == 0) {
			elements = elementFind(window, control, true, true, "input");
		}
		WebElement element = elements.get(0);
		element.click();
	}

	/**
	 * Simulates pressing the left mouse button on the image identified by
	 * <b>control</b>.<br>
	 * <br>
	 * The control is pressed without releasing the mouse button.<br>
	 * <br>
	 * Key attributes for images are id, src and alt. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The name or locator of select control.
	 * @see Element#mouseDown
	 * @see Element#mouseDownOnLink
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void mouseDownOnImage(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, true, "image");

		Actions action = new Actions(browserManagement.getCurrentWebDriver());
		action.clickAndHold(elements.get(0)).perform();
	}

	@RobotKeywordOverload
	@ArgumentNames({ "window", "control" })
	public void checkPageContainsImage(String window, String control) {
		checkPageContainsImage(window, control, "", "INFO");
	}

	@RobotKeywordOverload
	@ArgumentNames({ "window", "control", "message=NONE" })
	public void checkPageContainsImage(String window, String control, String message) {
		checkPageContainsImage(window, control, message, "INFO");
	}

	/**
	 * Verify the image is found on the current page.<br>
	 * <br>
	 * Key attributes for images are id, src and alt. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the link.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageContainsImage(String window, String control, String message, String logLevel) {
		checkPageContainsControl(window, control, "image", message, logLevel);
	}

	@RobotKeywordOverload
	@ArgumentNames({ "window", "control" })
	public void checkPageNotContainImage(String window, String control) {
		checkPageNotContainImage(window, control, "", "INFO");
	}

	@RobotKeywordOverload
	@ArgumentNames({ "window", "control", "message=NONE" })
	public void checkPageNotContainImage(String window, String control, String message) {
		checkPageNotContainImage(window, control, message, "INFO");
	}

	/**
	 * Verify the image is not found on the current page.<br>
	 * <br>
	 * Key attributes for images are id, src and alt. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface contains the link. If the link has not defined
	 *            in any interfaces, input "*" for window.
	 * @param control
	 *            The test name of the link captured in <b>window</b>. If the
	 *            link has not defined in any interfaces, input locator/xpath
	 *            for control.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageNotContainImage(String window, String control, String message, String logLevel) {
		checkPageNotContainControl(window, control, "image", message, logLevel);
	}

	// ##############################
	// Keywords - Xpath
	// ##############################

	/**
	 * Returns the number of controls located the given <b>xpath</b>.<br>
	 * <br>
	 * If you wish to assert the number of located controls, use `Xpath Should
	 * Match X Times`.<br>
	 * 
	 * @param xpath
	 *            The XPath to match page controls
	 * @return The number of located controls
	 */
	@RobotKeyword
	@ArgumentNames({ "xpath" })
	public int getMatchingXpathCount(String xpath) {
		if (!xpath.startsWith("xpath=")) {
			xpath = "xpath=" + xpath;
		}
		List<WebElement> elements = elementFind("", xpath, false, false);

		return elements.size();
	}

	@RobotKeywordOverload
	@ArgumentNames({ "xpath", "expectedXpathCount" })
	public void checkXpattMatchsXTimes(String xpath, int expectedXpathCount) {
		checkXpattMatchsXTimes(xpath, expectedXpathCount, "");
	}

	@RobotKeywordOverload
	@ArgumentNames({ "xpath", "expectedXpathCount", "message=NONE" })
	public void checkXpattMatchsXTimes(String xpath, int expectedXpathCount, String message) {
		checkXpattMatchsXTimes(xpath, expectedXpathCount, message, "INFO");
	}

	/**
	 * Verify that the page contains the <b>expectedXpathCount</b> of controls
	 * located by the given <b>xpath</b>.<br>
	 * 
	 * @param xpath
	 *            The XPath to match page controls
	 * @param expectedXpathCount
	 *            The expected number of located controls
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "xpath", "expectedXpathCount", "message=NONE", "logLevel=INFO" })
	public void checkXpattMatchsXTimes(String xpath, int expectedXpathCount, String message, String logLevel) {
		if (!xpath.startsWith("xpath=")) {
			xpath = "xpath=" + xpath;
		}
		List<WebElement> elements = elementFind("", xpath, false, false);
		int actualXpathCount = elements.size();

		if (actualXpathCount != expectedXpathCount) {
			if (message == null || message.equals("")) {
				message = String.format("Xpath %s should have matched %s times but matched %s times.", xpath,
						expectedXpathCount, actualXpathCount);
			}
			throw new ABTLibraryNonFatalException(message);
		}

		logging.log(String.format("Current page contains %s controls matching '%s'.", actualXpathCount, xpath),
				logLevel);
	}

	// ##############################
	// Internal Methods
	// ##############################

	public List<WebElement> elementFind(String window, String control, boolean firstOnly, boolean required) {
		return elementFind(window, control, firstOnly, required, null);
	}

	protected List<WebElement> elementFind(String window, String control, boolean firstOnly, boolean required,
			String tag) {
		List<WebElement> elements = new ArrayList<WebElement>();
		/**
		 * Updated by Khoi Date: Nov 20, 2016 Add argument window. Change name
		 * control to element
		 */
		String orgImplicitWait = "";
		// Check if input user data for control is name of defined control.
		if (!window.equals("")) {
			List<String> tempcontrols = userInterface.getLocators(window, control);
			System.out.println(tempcontrols);
			for (String tempcontrol : tempcontrols) {
				elements.addAll(ElementFinder.find(browserManagement, tempcontrol, tag));
				if (elements.size() > 0) {
					break;
				} else {
					/**
					 * Decrease wait time to find elements faster.
					 */
					orgImplicitWait = browserManagement.setSeleniumImplicitWait("0.0");
				}
			}
		}
		// If there is no control defined with name matched input control.
		if (elements.size() == 0) {
			elements.addAll(ElementFinder.find(browserManagement, control, tag));
		}
		if (required && elements.size() == 0) {
			throw new ABTLibraryNonFatalException(
					String.format("Element control '%s' did not match any elements.", control));
		}

		if (firstOnly) {
			if (elements.size() > 1) {
				List<WebElement> tmp = new ArrayList<WebElement>();
				tmp.add(elements.get(0));
				elements = tmp;
			}
		}

		if (!orgImplicitWait.equals("")) {
			browserManagement.setSeleniumImplicitWait(orgImplicitWait);
		}
		return elements;
	}

	protected boolean frameContains(String window, String control, String text) {
		WebDriver current = browserManagement.getCurrentWebDriver();
		List<WebElement> elements = elementFind(window, control, true, true);

		current.switchTo().frame(elements.get(0));
		logging.info(String.format("Searching for text from frame '%s'.", control));
		boolean found = isTextPresent(text);
		current.switchTo().defaultContent();

		return found;
	}

	protected boolean isTextPresent(String text) {
		String control = String.format("xpath=//*[contains(., %s)]", escapeXpathValue(text));

		return isElementPresent("", control);
	}

	protected boolean isEnabled(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, true);
		WebElement element = elements.get(0);

		if (!formElement.isFormElement(element)) {
			throw new ABTLibraryNonFatalException(String.format("ERROR: control %s is not an input.", control));
		}
		if (!element.isEnabled()) {
			return false;
		}
		String readonly = element.getAttribute("readonly");
		if (readonly != null && (readonly.equals("readonly") || readonly.equals("true"))) {
			return false;
		}

		return true;
	}

	protected boolean isVisible(String window, String control) {
		List<WebElement> elements = elementFind(window, control, true, false);
		if (elements.size() == 0) {
			return false;
		}
		WebElement element = elements.get(0);
		return element.isDisplayed();
	}

	protected boolean isClickable(String window, String control) {
		List<WebElement> webElements = elementFind(window, control, true, false);
		if (webElements.size() == 0) {
			return false;
		}
		WebElement element = webElements.get(0);
		return element.isDisplayed() && element.isEnabled();
	}

	protected boolean isSelected(String window, String control) {
		List<WebElement> webElements = elementFind(window, control, true, false);
		if (webElements.size() == 0) {
			return false;
		}
		WebElement element = webElements.get(0);
		return element.isSelected();
	}

	protected String[] parseAttributecontrol(String attributecontrol) {
		int index = attributecontrol.lastIndexOf('@');
		if (index <= 0) {
			throw new ABTLibraryNonFatalException(
					String.format("Attribute control '%s' does not contain an control.", attributecontrol));
		}
		if (index + 1 == attributecontrol.length()) {
			throw new ABTLibraryNonFatalException(
					String.format("Attribute control '%s' does not contain an attribute name.", attributecontrol));
		}
		String[] parts = new String[2];
		parts[0] = attributecontrol.substring(0, index);
		parts[1] = attributecontrol.substring(index + 1);

		return parts;
	}

	protected boolean isElementPresent(String window, String control) {
		return isElementPresent(window, control, null);
	}

	protected boolean isElementPresent(String window, String control, String tag) {
		return elementFind(window, control, true, false, tag).size() != 0;
	}

	protected boolean pageContains(String text) {
		WebDriver current = browserManagement.getCurrentWebDriver();
		current.switchTo().defaultContent();

		if (isTextPresent(text)) {
			return true;
		}

		List<WebElement> elements = elementFind("", "xpath=//frame|//iframe", false, false);
		Iterator<WebElement> it = elements.iterator();
		while (it.hasNext()) {
			current.switchTo().frame(it.next());
			boolean found = isTextPresent(text);
			current.switchTo().defaultContent();
			if (found) {
				return true;
			}
		}

		return false;
	}

	protected CharSequence mapAsciiKeyCodeToKey(int keyCode) {
		switch (keyCode) {
		case 0:
			return Keys.NULL;
		case 8:
			return Keys.BACK_SPACE;
		case 9:
			return Keys.TAB;
		case 10:
			return Keys.RETURN;
		case 13:
			return Keys.ENTER;
		case 24:
			return Keys.CANCEL;
		case 27:
			return Keys.ESCAPE;
		case 32:
			return Keys.SPACE;
		case 42:
			return Keys.MULTIPLY;
		case 43:
			return Keys.ADD;
		case 44:
			return Keys.SEPARATOR;
		case 45:
			return Keys.SUBTRACT;
		case 56:
			return Keys.DECIMAL;
		case 57:
			return Keys.DIVIDE;
		case 59:
			return Keys.SEMICOLON;
		case 61:
			return Keys.EQUALS;
		case 127:
			return Keys.DELETE;
		default:
			return new StringBuffer((char) keyCode);
		}
	}

	public static String escapeXpathValue(String value) {
		if (value.contains("\"") && value.contains("'")) {
			String[] partsWoApos = value.split("'");
			return String.format("concat('%s')", Python.join("', \"'\", '", Arrays.asList(partsWoApos)));
		}
		if (value.contains("'")) {
			return String.format("\"%s\"", value);
		}
		return String.format("'%s'", value);
	}

}
