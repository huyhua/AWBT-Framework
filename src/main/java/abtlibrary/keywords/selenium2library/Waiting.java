package abtlibrary.keywords.selenium2library;

import org.openqa.selenium.JavascriptExecutor;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.utils.Robotframework;

@RobotKeywords
public class Waiting extends RunOnFailureKeywordsAdapter {

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

	// ##############################
	// Keywords
	// ##############################

	@RobotKeywordOverload
	public void waitForCondition(String condition) {
		waitForCondition(condition, null);
	}

	@RobotKeywordOverload
	public void waitForCondition(String condition, String timeout) {
		waitForCondition(condition, timeout, null);
	}

	/**
	 * Waits until the given JavaScript <b>condition</b> is true.<br>
	 * <br>
	 * Fails, if the timeout expires, before the condition gets true. <br>
	 * <br>
	 * The condition may contain multiple JavaScript statements, but the last
	 * statement must return a boolean. Otherwise this keyword will always hit
	 * the timeout.<br>
	 * <br>
	 * Note that by default the code will be executed in the context of the
	 * Selenium object itself, so <b>this</b> will refer to the Selenium object.
	 * Use <b>window</b> to refer to the window of your application, e.g.
	 * <i>window.document.getElementById('foo')</i>.<br>
	 * <br>
	 * See `Introduction` for details about timeouts.<br>
	 * 
	 * @param condition
	 *            The JavaScript condition returning a boolean.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "condition", "timeout=NONE", "message=NONE" })
	public void waitForCondition(final String condition, String timeout, String message) {
		if (message == null) {
			message = String.format("Condition '%s' did not become true in <TIMEOUT>", condition);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return Boolean.TRUE.equals(
						((JavascriptExecutor) browserManagement.getCurrentWebDriver()).executeScript(condition));
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilPageContains(String condition) {
		waitUntilPageContains(condition, null);
	}

	@RobotKeywordOverload
	public void waitUntilPageContains(String condition, String timeout) {
		waitUntilPageContains(condition, timeout, null);
	}

	/**
	 * Waits until the current page contains <b>text</b>.<br>
	 * <br>
	 * Fails, if the timeout expires, before the text appears. <br>
	 * <br>
	 * See `Introduction` for details about timeouts.<br>
	 * 
	 * @param text
	 *            The text to verify.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "condition", "timeout=NONE", "message=NONE" })
	public void waitUntilPageContains(final String text, String timeout, String message) {
		if (message == null) {
			message = String.format("Text '%s' did not appear in <TIMEOUT>", text);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return element.isTextPresent(text);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilPageNotContains(String condition, String timeout) {
		waitUntilPageNotContains(condition, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilPageNotContains(String condition) {
		waitUntilPageNotContains(condition, null);
	}

	/**
	 * Waits until the current page does not contain <b>text</b>.<br>
	 * <br>
	 * Fails, if the timeout expires, before the text disappears. <br>
	 * <br>
	 * See `Introduction` for details about timeouts.<br>
	 * 
	 * @param text
	 *            The text to verify.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "text", "timeout=NONE", "message=NONE" })
	public void waitUntilPageNotContains(final String text, String timeout, String message) {
		if (message == null) {
			message = String.format("Text '%s' did not disappear in <TIMEOUT>", text);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return !element.isTextPresent(text);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilPageDoesNotContain(String condition, String timeout) {
		waitUntilPageDoesNotContain(condition, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilPageDoesNotContain(String condition) {
		waitUntilPageDoesNotContain(condition, null);
	}

	/**
	 * Waits until the current page does not contain <b>text</b>.<br>
	 * <br>
	 * Fails, if the timeout expires, before the text disappears. <br>
	 * <br>
	 * See `Introduction` for details about timeouts.<br>
	 * 
	 * @param text
	 *            The text to verify.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "text", "timeout=NONE", "message=NONE" })
	public void waitUntilPageDoesNotContain(final String text, String timeout, String message) {
		waitUntilPageNotContains(text, timeout, message);
	}

	@RobotKeywordOverload
	public void waitUntilPageContainsElement(String window, String condition) {
		waitUntilPageContainsElement(window, condition, null);
	}

	@RobotKeywordOverload
	public void waitUntilPageContainsElement(String window, String condition, String timeout) {
		waitUntilPageContainsElement(window, condition, timeout, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is found on the
	 * current page.<br>
	 * <br>
	 * Fails, if the timeout expires, before the element appears. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilPageContainsElement(String window, final String control, String timeout, String message) {
		if (message == null) {
			message = String.format("Element '%s' did not appear in <TIMEOUT>", control);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return element.isElementPresent(window, control);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilPageNotContainsElement(String window, String control) {
		waitUntilPageNotContainsElement(window, control, null);
	}

	@RobotKeywordOverload
	public void waitUntilPageNotContainsElement(String window, String control, String timeout) {
		waitUntilPageNotContainsElement(window, control, timeout, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is not found on the
	 * current page.<br>
	 * <br>
	 * Fails, if the timeout expires, before the element disappears. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilPageNotContainsElement(String window, final String control, String timeout, String message) {
		if (message == null) {
			message = String.format("Element '%s' did not disappear in <TIMEOUT>", control);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return !element.isElementPresent(window, control);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilPageDoesNotContainElement(String window, String control) {
		waitUntilPageDoesNotContainElement(window, control, null);
	}

	@RobotKeywordOverload
	public void waitUntilPageDoesNotContainElement(String window, String control, String timeout) {
		waitUntilPageDoesNotContainElement(window, control, timeout, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is not found on the
	 * current page.<br>
	 * <br>
	 * Fails, if the timeout expires, before the element disappears. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilPageDoesNotContainElement(String window, final String control, String timeout,
			String message) {
		waitUntilPageNotContainsElement(window, control, timeout, message);
	}

	@RobotKeywordOverload
	public void waitUntilElementIsVisible(String window, String control, String timeout) {
		waitUntilElementIsVisible(window, control, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilElementIsVisible(String window, String control) {
		waitUntilElementIsVisible(window, control, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is visible.<br>
	 * <br>
	 * Fails, if the timeout expires, before the element gets visible. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilElementIsVisible(String window, final String control, String timeout, String message) {
		if (message == null) {
			message = String.format("Element '%s' not visible in <TIMEOUT>", control);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return element.isVisible(window, control);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilElementIsNotVisible(String window, String control, String timeout) {
		waitUntilElementIsNotVisible(window, control, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilElementIsNotVisible(String window, String control) {
		waitUntilElementIsNotVisible(window, control, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is not visible.<br>
	 * <br>
	 * Fails, if the timeout expires, before the element gets invisible. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilElementIsNotVisible(String window, final String control, String timeout, String message) {
		if (message == null) {
			message = String.format("Element '%s' still visible in <TIMEOUT>", control);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return !element.isVisible(window, control);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilElementIsClickable(String window, String control) {
		waitUntilElementIsClickable(window, control, null, null);
	}

	@RobotKeywordOverload
	public void waitUntilElementIsClickable(String window, String control, String timeout) {
		waitUntilElementIsClickable(window, control, timeout, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is clickable.<br>
	 * <br>
	 * Fails, if the timeout expires, before the element gets clickable. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilElementIsClickable(String window, final String control, String timeout, String message) {
		if (message == null) {
			message = String.format("Element '%s' not clickable in <TIMEOUT>", control);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return element.isClickable(window, control);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilElementIsNotClickable(String window, String control, String timeout) {
		waitUntilElementIsNotClickable(window, control, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilElementIsNotClickable(String window, String control) {
		waitUntilElementIsNotClickable(window, control, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is not clickable.
	 * <br>
	 * <br>
	 * Fails, if the timeout expires, before the element gets unclickable. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilElementIsNotClickable(String window, final String control, String timeout, String message) {
		if (message == null) {
			message = String.format("Element '%s' still clickable in <TIMEOUT>", control);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return !element.isClickable(window, control);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilElementIsSuccessfullyClicked(String window, String control, String timeout) {
		waitUntilElementIsSuccessfullyClicked(window, control, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilElementIsSuccessfullyClicked(String window, String control) {
		waitUntilElementIsSuccessfullyClicked(window, control, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is sucessfully
	 * clicked on.<br>
	 * <br>
	 * Fails, if the timeout expires, before the element gets clicked on. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilElementIsSuccessfullyClicked(String window, final String control, String timeout,
			String message) {
		if (message == null) {
			message = String.format("Element '%s' not successfully clicked in <TIMEOUT>", control);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				element.click(window, control);
				return true;
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilElementIsSelected(String window, String control, String timeout) {
		waitUntilElementIsSelected(window, control, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilElementIsSelected(String window, String control) {
		waitUntilElementIsSelected(window, control, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is selected.<br>
	 * <br>
	 * Fails, if the timeout expires, before the element gets selected. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilElementIsSelected(String window, final String control, String timeout, String message) {
		if (message == null) {
			message = String.format("Element '%s' not selected in <TIMEOUT>", control);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return element.isSelected(window, control);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilElementIsNotSelected(String window, String control, String timeout) {
		waitUntilElementIsNotSelected(window, control, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilElementIsNotSelected(String window, String control) {
		waitUntilElementIsNotSelected(window, control, null);
	}

	/**
	 * Waits until the element identified by <b>control</b> is not selected.<br>
	 * <br>
	 * Fails, if the timeout expires, before the element gets unselected. <br>
	 * <br>
	 * See `Introduction` for details about controls and timeouts.<br>
	 * 
	 * @param control
	 *            The control to locate the element.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "control", "timeout=NONE", "message=NONE" })
	public void waitUntilElementIsNotSelected(String window, final String control, String timeout, String message) {
		if (message == null) {
			message = String.format("Element '%s' still selected in <TIMEOUT>", control);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				return !element.isSelected(window, control);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilTitleContains(String title, String timeout) {
		waitUntilTitleContains(title, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilTitleContains(String title) {
		waitUntilTitleContains(title, null, null);
	}

	/**
	 * Waits until the current page title contains <b>title</b>.<br>
	 * <br>
	 * Fails, if the timeout expires, before the page title contains the given
	 * title.<br>
	 * 
	 * @param title
	 *            The title to verify.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "title", "timeout=NONE", "message=NONE" })
	public void waitUntilTitleContains(final String title, String timeout, String message) {
		if (message == null) {
			message = String.format("Title '%s' did not appear in <TIMEOUT>", title);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				String currentTitle = browserManagement.getTitle();
				return currentTitle != null && currentTitle.contains(title);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilTitleNotContains(String title, String timeout) {
		waitUntilTitleNotContains(title, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilTitleNotContains(String title) {
		waitUntilTitleNotContains(title, null, null);
	}

	/**
	 * Waits until the current page title does not contain <b>title</b>.<br>
	 * <br>
	 * Fails, if the timeout expires, before the page title does not contain the
	 * given title.<br>
	 * 
	 * @param title
	 *            The title to verify.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "title", "timeout=NONE", "message=NONE" })
	public void waitUntilTitleNotContains(final String title, String timeout, String message) {
		if (message == null) {
			message = String.format("Title '%s' did not appear in <TIMEOUT>", title);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				String currentTitle = browserManagement.getTitle();
				return currentTitle == null || !currentTitle.contains(title);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilTitleIs(String title, String timeout) {
		waitUntilTitleIs(title, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilTitleIs(String title) {
		waitUntilTitleIs(title, null);
	}

	/**
	 * Waits until the current page title is exactly <b>title</b>.<br>
	 * <br>
	 * Fails, if the timeout expires, before the page title matches the given
	 * title.<br>
	 * 
	 * @param title
	 *            The title to verify.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "title", "timeout=NONE", "message=NONE" })
	public void waitUntilTitleIs(final String title, String timeout, String message) {
		if (message == null) {
			message = String.format("Title '%s' did not appear in <TIMEOUT>", title);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				String currentTitle = browserManagement.getTitle();
				return currentTitle != null && currentTitle.equals(title);
			}
		});
	}

	@RobotKeywordOverload
	public void waitUntilTitleIsNot(String title, String timeout) {
		waitUntilTitleIsNot(title, timeout, null);
	}

	@RobotKeywordOverload
	public void waitUntilTitleIsNot(String title) {
		waitUntilTitleIsNot(title, null, null);
	}

	/**
	 * Waits until the current page title is not exactly <b>title</b>.<br>
	 * <br>
	 * Fails, if the timeout expires, before the page title does not match the
	 * given title.<br>
	 * 
	 * @param title
	 *            The title to verify.
	 * @param timeout
	 *            Default=NONE. Optional timeout interval.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 */
	@RobotKeyword
	@ArgumentNames({ "title", "timeout=NONE", "message=NONE" })
	public void waitUntilTitleIsNot(final String title, String timeout, String message) {
		if (message == null) {
			message = String.format("Title '%s' did not appear in <TIMEOUT>", title);
		}
		waitUntil(timeout, message, new WaitUntilFunction() {

			@Override
			public boolean isFinished() {
				String currentTitle = browserManagement.getTitle();
				return currentTitle == null || !currentTitle.equals(title);
			}
		});
	}

	// ##############################
	// Internal Methods
	// ##############################

	protected void waitUntil(String timestr, String message, WaitUntilFunction function) {
		double timeout = timestr != null ? Robotframework.timestrToSecs(timestr) : browserManagement.getTimeout();
		message = message.replace("<TIMEOUT>", Robotframework.secsToTimestr(timeout));
		long maxtime = System.currentTimeMillis() + (long) (timeout * 1000);
		for (;;) {
			try {
				if (function.isFinished()) {
					break;
				}
			} catch (Throwable t) {
			}
			if (System.currentTimeMillis() > maxtime) {
				throw new ABTLibraryNonFatalException(message);
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}

	protected static interface WaitUntilFunction {

		boolean isFinished();
	}

}
