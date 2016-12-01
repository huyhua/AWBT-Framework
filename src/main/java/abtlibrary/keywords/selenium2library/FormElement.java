package abtlibrary.keywords.selenium2library;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.RunOnFailureKeywordsAdapter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import abtlibrary.ABTLibraryNonFatalException;

@RobotKeywords
public class FormElement extends RunOnFailureKeywordsAdapter {

	@Autowired
	protected BrowserManagement browsermanagement;

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

	// ##############################
	// Keywords
	// ##############################

	@RobotKeywordOverload
	public void submitForm() {
		submitForm("", null);
	}

	/**
	 * Submit the form identified by <b>control</b>.<br>
	 * <br>
	 * If the control is empty, the first form in the page will be submitted.
	 * <br>
	 * <br>
	 * Key attributes for forms are id and name. See `Introduction` for details
	 * about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            Default=NONE. The control to locate the form.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control=NONE" })
	public void submitForm(String window, String control) {
		logging.info(String.format("Submitting form '%s'.", control));
		if (control == null) {
			control = "xpath=//form";
		}
		List<WebElement> webElements = element.elementFind(window, control, true, true, "form");
		webElements.get(0).submit();
	}

	/**
	 * Verify the checkbox identified by <b>control</b> is selected/checked.<br>
	 * <br>
	 * Key attributes for checkboxes are id and name. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the checkbox.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void checkCheckboxSelected(String window, String control) {
		logging.info(String.format("Verifying checkbox '%s' is selected.", control));
		WebElement element = getCheckbox(window, control);
		if (!element.isSelected()) {
			throw new ABTLibraryNonFatalException(String.format("Checkbox '%s' should have been selected.", control));
		}
	}

	/**
	 * Verify the checkbox identified by <b>control</b> is not selected/checked.
	 * <br>
	 * <br>
	 * Key attributes for checkboxes are id and name. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the checkbox.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void checkCheckboxNotSelected(String window, String control) {
		logging.info(String.format("Verifying checkbox '%s' is selected.", control));
		WebElement element = getCheckbox(window, control);
		if (element.isSelected()) {
			throw new ABTLibraryNonFatalException(
					String.format("Checkbox '%s' should not have been selected.", control));
		}
	}

	@RobotKeywordOverload
	public void checkPageContainsCheckbox(String window, String control) {
		checkPageContainsCheckbox(window, control, "");
	}

	@RobotKeywordOverload
	public void checkPageContainsCheckbox(String window, String control, String message) {
		checkPageContainsCheckbox(window, control, message, "INFO");
	}

	/**
	 * Verify the checkbox identified by <b>control</b> is found on the current
	 * page.<br>
	 * <br>
	 * Key attributes for checkboxes are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the checkbox.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageContainsCheckbox(String window, String control, String message, String logLevel) {
		element.checkPageContainsControl(window, control, "checkbox", message, logLevel);
	}

	@RobotKeywordOverload
	public void checkPageNotContainCheckbox(String window, String control) {
		checkPageNotContainCheckbox(window, control, "");
	}

	@RobotKeywordOverload
	public void checkPageNotContainCheckbox(String window, String control, String message) {
		checkPageNotContainCheckbox(window, control, message, "INFO");
	}

	/**
	 * Verify the checkbox identified by <b>control</b> is not found on the
	 * current page.<br>
	 * <br>
	 * Key attributes for checkboxes are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the checkbox.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageNotContainCheckbox(String window, String control, String message, String logLevel) {
		element.checkPageNotContainControl(window, control, "checkbox", message, logLevel);
	}

	/**
	 * Select the checkbox identified by <b>control</b>.<br>
	 * <br>
	 * Does nothing, if the checkbox is already selected.<br>
	 * <br>
	 * Key attributes for checkboxes are id and name. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the checkbox.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void selectCheckbox(String window, String control) {
		logging.info(String.format("Selecting checkbox '%s'.", control));
		WebElement element = getCheckbox(window, control);
		if (!element.isSelected()) {
			element.click();
		}
	}

	/**
	 * Unselect the checkbox identified by <b>control</b>.<br>
	 * <br>
	 * Does nothing, if the checkbox is not selected.<br>
	 * <br>
	 * Key attributes for checkboxes are id and name. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the checkbox.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void unselectCheckbox(String window, String control) {
		logging.info(String.format("Selecting checkbox '%s'.", control));
		WebElement element = getCheckbox(window, control);
		if (element.isSelected()) {
			element.click();
		}
	}

	@RobotKeywordOverload
	public void checkPageContainsRadioButton(String window, String control) {
		checkPageContainsRadioButton(window, control, "");
	}

	@RobotKeywordOverload
	public void checkPageContainsRadioButton(String window, String control, String message) {
		checkPageContainsRadioButton(window, control, message, "INFO");
	}

	/**
	 * Verify the radio button identified by <b>control</b> is found on the
	 * current page.<br>
	 * <br>
	 * Key attributes for radio buttons are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the radio button.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageContainsRadioButton(String window, String control, String message, String logLevel) {
		element.checkPageContainsControl(window, control, "radio button", message, logLevel);
	}

	@RobotKeywordOverload
	public void checkPageNotContainRadioButton(String window, String control) {
		checkPageNotContainRadioButton(window, control, "");
	}

	@RobotKeywordOverload
	public void checkPageNotContainRadioButton(String window, String control, String message) {
		checkPageNotContainRadioButton(window, control, message, "INFO");
	}

	/**
	 * Verify the radio button identified by <b>control</b> is not found on the
	 * current page.<br>
	 * <br>
	 * Key attributes for radio buttons are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the radio button.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageNotContainRadioButton(String window, String control, String message, String logLevel) {
		element.checkPageNotContainControl(window, control, "radio button", message, logLevel);
	}

	/**
	 * Verify the radio button group identified by <b>groupName</b> has its
	 * selection set to <b>value</b>.<br>
	 * <br>
	 * See `Select Radio Button` for details about locating radio buttons.<br>
	 * 
	 * @param groupName
	 *            The radio button group name.
	 * @param value
	 *            The expected value.
	 */
	@RobotKeyword
	@ArgumentNames({ "groupName", "value" })
	public void radioButtonShouldBeSetTo(String groupName, String value) {
		logging.info(String.format("Verifying radio button '%s' has selection '%s'.", groupName, value));
		List<WebElement> elements = getRadioButtons(groupName);
		String actualValue = getValueFromRadioButtons(elements);
		if (actualValue == null || !actualValue.equals(value)) {
			throw new ABTLibraryNonFatalException(
					String.format("Selection of radio button '%s' should have been '%s' but was '%s'", groupName, value,
							actualValue));
		}
	}

	/**
	 * Verify the radio button group identified by <b>groupName</b> has no
	 * selection.<br>
	 * <br>
	 * See `Select Radio Button` for details about locating radio buttons.<br>
	 * 
	 * @param groupName
	 *            The radio button group name.
	 */
	@RobotKeyword
	@ArgumentNames({ "groupName" })
	public void radioButtonShouldNotBeSelected(String groupName) {
		logging.info(String.format("Verifying radio button '%s' has no selection.", groupName));
		List<WebElement> elements = getRadioButtons(groupName);
		String actualValue = getValueFromRadioButtons(elements);
		if (actualValue != null) {
			throw new ABTLibraryNonFatalException(
					String.format("Radio button group '%s' should not have had selection, but '%s' was selected",
							groupName, actualValue));
		}
	}

	/**
	 * Sets the selection of the radio button group identified by
	 * <b>groupName</b> to <b>value</b>.<br>
	 * <br>
	 * Example:
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td>Select Radio Button</td>
	 * <td>size</td>
	 * <td>XL</td>
	 * <td># Matches HTML like &lt;input type="radio" name="size"
	 * value="XL"&gt;XL&lt;/input&gt;</td>
	 * </tr>
	 * <tr>
	 * <td>Select Radio Button</td>
	 * <td>size</td>
	 * <td>sizeXL</td>
	 * <td># Matches HTML like &lt;input type="radio" name="size" value="XL"
	 * id="sizeXL"&gt;XL&lt;/input&gt;</td>
	 * </tr>
	 * </table>
	 * 
	 * @param groupName
	 *            The radio button group name.
	 * @param value
	 *            The value or id attribute of the radio button to set.
	 */
	@RobotKeyword
	@ArgumentNames({ "groupName", "value" })
	public void selectRadioButton(String groupName, String value) {
		logging.info(String.format("Selecting '%s' from radio button '%s'.", value, groupName));
		WebElement element = getRadioButtonWithValue(groupName, value);
		if (!element.isSelected()) {
			element.click();
		}
	}

	/**
	 * Types the given <b>filePath</b> into the input field identified by
	 * <b>control</b>.<br>
	 * <br>
	 * This keyword is most often used to input files into upload forms. The
	 * file specified with filePath must be available on the same host where the
	 * Selenium Server is running.<br>
	 * <br>
	 * Example:
	 * <table border="1" cellspacing="0" summary="">
	 * <tr>
	 * <td>Choose File</td>
	 * <td>my_upload_field</td>
	 * <td>/home/user/files/trades.csv</td>
	 * </tr>
	 * </table>
	 * Key attributes for input fields are id and name. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the input field.
	 * @param filePath
	 *            The file path to input
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "filePath" })
	public void chooseFile(String window, String control, String filePath) {
		if (!new File(filePath).isFile()) {
			logging.info(String.format("File '%s' does not exist on the local file system", filePath));
		}
		element.elementFind(window, control, true, true).get(0).sendKeys(filePath);
	}

	/**
	 * Types the given <b>text</b> into the password field identified by
	 * <b>control</b>.<br>
	 * <br>
	 * Key attributes for input fields are id and name. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the password field.
	 * @param text
	 *            The password to input
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text" })
	public void enterPassword(String window, String control, String text) {
		logging.info(String.format("Typing password into text field '%s'", control));
		inputTextIntoTextField(window, control, text);
	}

	/**
	 * Types the given <b>text</b> into the text field identified by
	 * <b>control</b>.<br>
	 * <br>
	 * Key attributes for input fields are id and name. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text field.
	 * @param text
	 *            The password to input
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text" })
	public void enter(String window, String control, String text) {
		logging.info(String.format("Typing text '%s' into text field '%s'", text, control));
		inputTextIntoTextField(window, control, text);
	}

	@RobotKeywordOverload
	public void checkPageContainsTextfield(String window, String control) {
		checkPageContainsTextfield(window, control, "");
	}

	@RobotKeywordOverload
	public void checkPageContainsTextfield(String window, String control, String message) {
		checkPageContainsTextfield(window, control, message, "INFO");
	}

	/**
	 * Verify the text field identified by <b>control</b> is found on the
	 * current page.<br>
	 * <br>
	 * Key attributes for text field are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text field.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageContainsTextfield(String window, String control, String message, String logLevel) {
		element.checkPageContainsControl(window, control, "text field", message, logLevel);
	}

	@RobotKeywordOverload
	public void checkPageNotContainTextfield(String window, String control) {
		checkPageNotContainTextfield(window, control, "");
	}

	@RobotKeywordOverload
	public void checkPageNotContainTextfield(String window, String control, String message) {
		checkPageNotContainTextfield(window, control, message, "INFO");
	}

	/**
	 * Verify the text field identified by <b>control</b> is not found on the
	 * current page.<br>
	 * <br>
	 * Key attributes for text field are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text field.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageNotContainTextfield(String window, String control, String message, String logLevel) {
		element.checkPageNotContainControl(window, control, "text field", message, logLevel);
	}

	@RobotKeywordOverload
	public void checkTextfieldValue(String window, String control, String text) {
		checkTextfieldValue(window, control, text, "");
	}

	/**
	 * Verify the text field identified by <b>control</b> is exactly <b>text</b>
	 * .<br>
	 * <br>
	 * Key attributes for text field are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text field.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * 
	 * @see FormElement#checkTextfieldContains
	 * @see FormElement#checkTextfieldNotContain
	 * @see FormElement#textfieldValueShouldNotBe
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkTextfieldValue(String window, String control, String text, String message) {
		String actual = element.getValue(window, control, "text field");
		if (!actual.contains(text)) {
			if (message == null) {
				message = String.format("Value of text field '%s' should have been '%s' but was '%s'", control, text,
						actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
		logging.info(String.format("Content of text field '%s' is '%s'.", control, text));
	}

	@RobotKeywordOverload
	public void textfieldValueShouldNotBe(String window, String control, String text) {
		textfieldValueShouldNotBe(window, control, text, "");
	}

	/**
	 * Verify the text field identified by <b>control</b> is not exactly
	 * <b>text</b>.<br>
	 * <br>
	 * Key attributes for text field are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text field.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * 
	 * @see FormElement#checkTextfieldContains
	 * @see FormElement#checkTextfieldNotContain
	 * @see FormElement#checkTextfieldValue
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void textfieldValueShouldNotBe(String window, String control, String text, String message) {
		String actual = element.getValue(window, control, "text field");
		if (actual.contains(text)) {
			if (message == null) {
				message = String.format("Value of text field '%s' should not have been '%s' but was '%s'", control,
						text, actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
		logging.info(String.format("Content of text field '%s' is '%s'.", control, text));
	}

	@RobotKeywordOverload
	public void checkTextfieldContains(String window, String control, String text) {
		checkTextfieldContains(window, control, text, "");
	}

	/**
	 * Verify the text field identified by <b>control</b> contains <b>text</b>.
	 * <br>
	 * <br>
	 * Key attributes for text field are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text field.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * 
	 * @see FormElement#checkTextfieldNotContain
	 * @see FormElement#checkTextfieldValue
	 * @see FormElement#textfieldValueShouldNotBe
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkTextfieldContains(String window, String control, String text, String message) {
		String actual = element.getValue(window, control, "text field");
		if (!actual.contains(text)) {
			if (message == null) {
				message = String.format("Text field '%s' should have contained text '%s', but was '%s'", control, text,
						actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
		logging.info(String.format("Text field '%s' contains text '%s'.", control, text));
	}

	@RobotKeywordOverload
	public void checkTextfieldNotContain(String window, String control, String text) {
		checkTextfieldNotContain(window, control, text, "");
	}

	/**
	 * Verify the text field identified by <b>control</b> does not contain
	 * <b>text</b>.<br>
	 * <br>
	 * Key attributes for text field are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text field.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * 
	 * @see FormElement#checkTextfieldContains
	 * @see FormElement#checkTextfieldValue
	 * @see FormElement#textfieldValueShouldNotBe
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkTextfieldNotContain(String window, String control, String text, String message) {
		String actual = element.getValue(window, control, "text field");
		if (actual.contains(text)) {
			if (message == null) {
				message = String.format("Text field '%s' should not have contained text '%s', but was '%s'", control,
						text, actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
		logging.info(String.format("Text field '%s' contains text '%s'.", control, text));
	}

	@RobotKeywordOverload
	public void checkTextareaContains(String window, String control, String text) {
		checkTextareaContains(window, control, text, "");
	}

	/**
	 * Verify the text area identified by <b>control</b> contains <b>text</b>.
	 * <br>
	 * <br>
	 * Key attributes for text areas are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text area.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * 
	 * @see FormElement#checkTextareaNotContain
	 * @see FormElement#checkTextareaValue
	 * @see FormElement#textareaValueShouldNotBe
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkTextareaContains(String window, String control, String text, String message) {
		String actual = element.getValue(window, control, "text area");
		if (!actual.contains(text)) {
			if (message == null) {
				message = String.format("Text area '%s' should have contained text '%s', but was '%s'", control, text,
						actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
		logging.info(String.format("Text field '%s' contains text '%s'.", control, text));
	}

	@RobotKeywordOverload
	public void checkTextareaNotContain(String window, String control, String text) {
		checkTextareaNotContain(window, control, text, "");
	}

	/**
	 * Verify the text area identified by <b>control</b> does not contain
	 * <b>text</b>.<br>
	 * <br>
	 * Key attributes for text areas are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text area.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * 
	 * @see FormElement#checkTextareaContains
	 * @see FormElement#checkTextareaValue
	 * @see FormElement#textareaValueShouldNotBe
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkTextareaNotContain(String window, String control, String text, String message) {
		String actual = element.getValue(window, control, "text area");
		if (!actual.contains(text)) {
			if (message == null) {
				message = String.format("Text area '%s' should not have contained text '%s', but was '%s'", control,
						text, actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
		logging.info(String.format("Text field '%s' contains text '%s'.", control, text));
	}

	@RobotKeywordOverload
	public void checkTextareaValue(String window, String control, String text) {
		checkTextareaValue(window, control, text, "");
	}

	/**
	 * Verify the text area identified by <b>control</b> is exactly <b>text</b>.
	 * <br>
	 * <br>
	 * Key attributes for text area are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text area.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * 
	 * @see FormElement#checkTextareaContains
	 * @see FormElement#checkTextareaNotContain
	 * @see FormElement#textareaValueShouldNotBe
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void checkTextareaValue(String window, String control, String text, String message) {
		String actual = element.getValue(window, control, "text area");
		if (!actual.contains(text)) {
			if (message == null) {
				message = String.format("Value of text area '%s' should have been '%s' but was '%s'", control, text,
						actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
		logging.info(String.format("Content of text area '%s' is '%s'.", control, text));
	}

	@RobotKeywordOverload
	public void textareaValueShouldNotBe(String window, String control, String text) {
		textareaValueShouldNotBe(window, control, text, "");
	}

	/**
	 * Verify the text area identified by <b>control</b> is not exactly
	 * <b>text</b>.<br>
	 * <br>
	 * Key attributes for text area are id and name. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the text area.
	 * @param text
	 *            The text to verify.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * 
	 * @see FormElement#checkTextareaContains
	 * @see FormElement#checkTextareaNotContain
	 * @see FormElement#checkTextareaValue
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "text", "message=NONE" })
	public void textareaValueShouldNotBe(String window, String control, String text, String message) {
		String actual = element.getValue(window, control, "text area");
		if (actual.contains(text)) {
			if (message == null) {
				message = String.format("Value of text area '%s' should not have been '%s' but was '%s'", control, text,
						actual);
			}
			throw new ABTLibraryNonFatalException(message);
		}
		logging.info(String.format("Content of text area '%s' is '%s'.", control, text));
	}

	/**
	 * Click on the button identified by <b>control</b>.<br>
	 * <br>
	 * Key attributes for buttons are id, name and value. See `Introduction` for
	 * details about controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the link.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control" })
	public void clickButton(String window, String control) {
		logging.info(String.format("Clicking button '%s'.", control));
		List<WebElement> elements = element.elementFind(window, control, true, false, "input");
		if (elements.size() == 0) {
			elements = element.elementFind(window, control, true, true, "button");
		}
		elements.get(0).click();
	}

	@RobotKeywordOverload
	public void checkPageContainsButton(String window, String control) {
		checkPageContainsButton(window, control, "");
	}

	@RobotKeywordOverload
	public void checkPageContainsButton(String window, String control, String message) {
		checkPageContainsButton(window, control, message, "INFO");
	}

	/**
	 * Verify the button identified by <b>control</b> is found on the current
	 * page.<br>
	 * <br>
	 * Key attributes for buttons are id, name and value. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the button.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageContainsButton(String window, String control, String message, String logLevel) {
		try {
			element.checkPageContainsControl(window, control, "input", message, logLevel);
		} catch (ABTLibraryNonFatalException e) {
			element.checkPageContainsControl(window, control, "button", message, logLevel);
		}
	}

	@RobotKeywordOverload
	public void checkPageNotContainButton(String window, String control) {
		checkPageNotContainButton(window, control, "");
	}

	@RobotKeywordOverload
	public void checkPageNotContainButton(String window, String control, String message) {
		checkPageNotContainButton(window, control, message, "INFO");
	}

	/**
	 * Verify the button identified by <b>control</b> is not found on the
	 * current page.<br>
	 * <br>
	 * Key attributes for buttons are id, name and value. See `Introduction` for
	 * details about log levels and controls.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The control to locate the button.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "control", "message=NONE", "logLevel=INFO" })
	public void checkPageNotContainButton(String window, String control, String message, String logLevel) {
		element.checkPageNotContainControl(window, control, "input", message, logLevel);
		element.checkPageNotContainControl(window, control, "button", message, logLevel);
	}

	// ##############################
	// Internal Methods
	// ##############################

	protected WebElement getCheckbox(String window, String control) {
		return element.elementFind(window, control, true, true, "input").get(0);
	}

	protected List<WebElement> getRadioButtons(String groupName) {
		String xpath = String.format("xpath=//input[@type='radio' and @name='%s']", groupName);
		logging.debug("Radio group control: " + xpath);
		return element.elementFind("", xpath, false, true);
	}

	protected WebElement getRadioButtonWithValue(String groupName, String value) {
		String xpath = String.format("xpath=//input[@type='radio' and @name='%s' and (@value='%s' or @id='%s')]",
				groupName, value, value);
		logging.debug("Radio group control: " + xpath);
		return element.elementFind("", xpath, true, true).get(0);
	}

	protected String getValueFromRadioButtons(List<WebElement> elements) {
		for (WebElement element : elements) {
			if (element.isSelected()) {
				return element.getAttribute("value");
			}
		}
		return null;
	}

	protected void inputTextIntoTextField(String window, String control, String text) {
		WebElement webElement = element.elementFind(window, control, true, true).get(0);
		webElement.clear();
		if (browsermanagement.getCurrentPlatform().equalsIgnoreCase("ios")) {
			((IOSElement) webElement).setValue(text);
		} else {
			webElement.sendKeys(text);
		}
		try {
			((AppiumDriver<?>) element.browserManagement.getCurrentWebDriver()).hideKeyboard();

		} catch (Exception e) {

		}
	}

	protected boolean isFormElement(WebElement element) {
		if (element == null) {
			return false;
		}
		String tag = element.getTagName().toLowerCase();
		return "input".equals(tag) || "select".equals(tag) || "textarea".equals(tag) || "button".equals(tag)
				|| "option".equals(tag);
	}

}
