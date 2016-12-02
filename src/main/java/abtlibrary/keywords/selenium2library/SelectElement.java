package abtlibrary.keywords.selenium2library;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.utils.Python;

@RobotKeywords
public class SelectElement extends RunOnFailureKeywordsAdapter {

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

	/**
	 * Returns the values in the select list identified by <b>locator</b>.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the select list.
	 * @return The select list values
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator" })
	public List<String> getListItems(String window, String control) {
		List<WebElement> options = getSelectListOptions(window, control);

		return getLabelsForOptions(options);
	}

	/**
	 * Returns the visible label of the first selected element from the select
	 * list identified by <b>locator</b>.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the select list.
	 * @return The first visible select list label
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator" })
	public String getSelectedListLabel(String window, String control) {
		Select select = getSelectList(window, control);

		return select.getFirstSelectedOption().getText();
	}

	/**
	 * Returns the visible labels of the first selected elements1 as a list from
	 * the select list identified by <b>locator</b>.<br>
	 * <br>
	 * Fails if there is no selection.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the select list.
	 * @return The list of visible select list labels
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator" })
	public List<String> getSelectedListLabels(String window, String control) {
		List<WebElement> options = getSelectListOptionsSelected(window, control);

		if (options.size() == 0) {
			throw new ABTLibraryNonFatalException(
					String.format("Select list with locator '%s' does not have any selected values.", control));
		}

		return getLabelsForOptions(options);
	}

	/**
	 * Returns the value of the first selected element from the select list
	 * identified by <b>locator</b>.<br>
	 * <br>
	 * The return value is read from the value attribute of the selected
	 * element.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the select list.
	 * @return The first select list value
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator" })
	public String getSelectedListValue(String window, String control) {
		Select select = getSelectList(window, control);

		return select.getFirstSelectedOption().getAttribute("value");
	}

	/**
	 * Returns the values of the first selected elements1 as a list from the
	 * select list identified by <b>locator</b>.<br>
	 * <br>
	 * Fails if there is no selection. The return values are read from the value
	 * attribute of the selected element.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the select list.
	 * @return The list of select list values
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator" })
	public List<String> getSelectedListValues(String window, String control) {
		List<WebElement> options = getSelectListOptionsSelected(window, control);

		if (options.size() == 0) {
			throw new ABTLibraryNonFatalException(
					String.format("Select list with locator '%s' does not have any selected values.", control));
		}

		return getValuesForOptions(options);
	}

	/**
	 * Verify the selection of the select list identified by <b>locator</b>is
	 * exactly <b>*items</b>.<br>
	 * <br>
	 * If you want to verify no option is selected, simply give no items.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the select list.
	 * @param items
	 *            The list of items to verify
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "*items" })
	public void listSelectionShouldBe(String window, String control, String... items) {
		String itemList = items.length != 0 ? String.format("option(s) [ %s ]", Python.join(" | ", items))
				: "no options";
		logging.info(String.format("Verifying list '%s' has %s selected.", control, itemList));

		checkPageContainsList(window, control);

		List<WebElement> options = getSelectListOptionsSelected(window, control);
		List<String> selectedLabels = getLabelsForOptions(options);
		String message = String.format("List '%s' should have had selection [ %s ] but it was [ %s ].", control,
				Python.join(" | ", items), Python.join(" | ", selectedLabels));
		if (items.length != options.size()) {
			throw new ABTLibraryNonFatalException(message);
		} else {
			List<String> selectedValues = getValuesForOptions(options);

			for (String item : items) {
				if (!selectedValues.contains(item) && !selectedLabels.contains(item)) {
					throw new ABTLibraryNonFatalException(message);
				}
			}
		}
	}

	/**
	 * Verify the select list identified by <b>locator</b>has no selections.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the select list.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator" })
	public void listShouldHaveNoSelections(String window, String control) {
		logging.info(String.format("Verifying list '%s' has no selection.", control));

		List<WebElement> options = getSelectListOptionsSelected(window, control);
		if (!options.equals(null)) {
			List<String> selectedLabels = getLabelsForOptions(options);
			String items = Python.join(" | ", selectedLabels);
			throw new ABTLibraryNonFatalException(String.format(
					"List '%s' should have had no selection (selection was [ %s ]).", control, items.toString()));
		}
	}

	@RobotKeywordOverload
	public void checkPageContainsList(String window, String control) {
		checkPageContainsList(control, "");
	}

	@RobotKeywordOverload
	public void checkPageContainsList(String window, String control, String message) {
		checkPageContainsList(control, message, "INFO");
	}

	/**
	 * Verify the select list identified by <b>locator</b> is found on the
	 * current page.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators and log levels.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the select list.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "message=NONE", "logLevel=INFO" })
	public void checkPageContainsList(String window, String control, String message, String logLevel) {
		element.checkPageContainsControl(control, "list", message, logLevel);
	}

	@RobotKeywordOverload
	public void checkPageNotContainList(String window, String control) {
		checkPageNotContainList(control, "");
	}

	@RobotKeywordOverload
	public void checkPageNotContainList(String window, String control, String message) {
		checkPageNotContainList(control, message, "INFO");
	}

	/**
	 * Verify the select list identified by <b>locator</b> is not found on the
	 * current page.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators and log levels.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the select list.
	 * @param message
	 *            Default=NONE. Optional custom error message.
	 * @param logLevel
	 *            Default=INFO. Optional log level.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "message=NONE", "logLevel=INFO" })
	public void checkPageNotContainList(String window, String control, String message, String logLevel) {
		element.checkPageNotContainControl(control, "list", message, logLevel);
	}

	/**
	 * Select all values of the multi-select list identified by <b>locator</b>.
	 * <br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the multi-select list.
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator" })
	public void selectAllFromList(String window, String control) {
		logging.info(String.format("Selecting all options from list '%s'.", control));

		Select select = getSelectList(window, control);
		if (!isMultiselectList(select)) {
			throw new ABTLibraryNonFatalException("Keyword 'Select all from list' works only for multiselect lists.");
		}

		for (int i = 0; i < select.getOptions().size(); i++) {
			select.selectByIndex(i);
		}
	}

	/**
	 * Select the given <b>*items</b> of the multi-select list identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * An exception is raised for a single-selection list if the last value does
	 * not exist in the list and a warning for all other non-existing items. For
	 * a multi-selection list, an exception is raised for any and all
	 * non-existing values.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the multi-select list.
	 * @param items
	 *            The list of items to select
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "*items" })
	public void selectFromList(String window, String control, String... items) {
		String itemList = items.length != 0 ? String.format("option(s) [ %s ]", Python.join(" | ", items))
				: "all options";
		logging.info(String.format("Selecting %s from list '%s'.", itemList, control));

		Select select = getSelectList(window, control);

		// If no items given, select all values (of in case of single select
		// list, go through all values)
		if (items.length == 0) {
			for (int i = 0; i < select.getOptions().size(); i++) {
				select.selectByIndex(i);
			}
			return;
		}

		boolean lastItemFound = false;
		List<String> nonExistingItems = new ArrayList<String>();
		for (String item : items) {
			lastItemFound = true;
			try {
				select.selectByValue(item);
			} catch (NoSuchElementException e1) {
				try {
					select.selectByVisibleText(item);
				} catch (NoSuchElementException e2) {
					nonExistingItems.add(item);
					lastItemFound = false;
					continue;
				}
			}
		}

		if (nonExistingItems.size() != 0) {
			// multi-selection list => throw immediately
			if (select.isMultiple()) {
				throw new ABTLibraryNonFatalException(
						String.format("Options '%s' not in list '%s'.", Python.join(", ", nonExistingItems), control));
			}

			// single-selection list => log warning with not found items
			logging.warn(String.format("Option%s '%s' not found within list '%s'.",
					nonExistingItems.size() == 0 ? "" : "s", Python.join(", ", nonExistingItems), control));

			// single-selection list => throw if last item was not found
			if (!lastItemFound) {
				throw new ABTLibraryNonFatalException(String.format("Option '%s' not in list '%s'.",
						nonExistingItems.get(nonExistingItems.size() - 1), control));
			}
		}
	}

	/**
	 * Select the given <b>*indexes</b> of the multi-select list identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * Tries to select by value AND by label. It's generally faster to use 'by
	 * index/value/label' keywords.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the multi-select list.
	 * @param indexes
	 *            The list of indexes to select
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "*indexes" })
	public void selectFromListByIndex(String window, String control, String... indexes) {
		if (indexes.length == 0) {
			throw new ABTLibraryNonFatalException("No index given.");
		}

		List<String> tmp = new ArrayList<String>();
		for (String index : indexes) {
			tmp.add(index);
		}
		String items = String.format("index(es) '%s'", Python.join(", ", tmp));
		logging.info(String.format("Selecting %s from list '%s'.", items, control));

		Select select = getSelectList(window, control);
		for (String index : indexes) {
			select.selectByIndex(Integer.parseInt(index));
		}
	}

	/**
	 * Select the given <b>*values</b> of the multi-select list identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the multi-select list.
	 * @param values
	 *            The list of values to select
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "*values" })
	public void selectFromListByValue(String window, String control, String... values) {
		if (values.length == 0) {
			throw new ABTLibraryNonFatalException("No value given.");
		}

		String items = String.format("value(s) '%s'", Python.join(", ", values));
		logging.info(String.format("Selecting %s from list '%s'.", items, control));

		Select select = getSelectList(window, control);
		for (String value : values) {
			select.selectByValue(value);
		}
	}

	/**
	 * Select the given <b>*labels</b> of the multi-select list identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the multi-select list.
	 * @param labels
	 *            The list of labels to select
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "*labels" })
	public void selectFromListByLabel(String window, String control, String... labels) {
		if (labels.length == 0) {
			throw new ABTLibraryNonFatalException("No value given.");
		}

		String items = String.format("label(s) '%s'", Python.join(", ", labels));
		logging.info(String.format("Selecting %s from list '%s'.", items, control));

		Select select = getSelectList(window, control);
		for (String label : labels) {
			select.selectByVisibleText(label);
		}
	}

	/**
	 * Unselect the given <b>*items</b> of the multi-select list identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * As a special case, giving an empty *items list will remove all
	 * selections.<br>
	 * <br>
	 * Tries to unselect by value AND by label. It's generally faster to use 'by
	 * index/value/label' keywords.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the multi-select list.
	 * @param items
	 *            The list of items to select
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "*items" })
	public void unselectFromList(String window, String control, String... items) {
		String itemList = items.length != 0 ? String.format("option(s) [ %s ]", Python.join(" | ", items))
				: "all options";
		logging.info(String.format("Unselecting %s from list '%s'.", itemList, control));

		Select select = getSelectList(window, control);

		if (!isMultiselectList(select)) {
			throw new ABTLibraryNonFatalException("Keyword 'Unselect from list' works only for multiselect lists.");
		}

		if (items.length == 0) {
			select.deselectAll();

			return;
		}

		for (String item : items) {
			select.deselectByValue(item);
			select.deselectByVisibleText(item);
		}
	}

	/**
	 * Unselect the given <b>*indexes</b> of the multi-select list identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the multi-select list.
	 * @param indexes
	 *            The list of indexes to select
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "*indexes" })
	public void unselectFromListByIndex(String window, String control, Integer... indexes) {
		if (indexes.equals(null)) {
			throw new ABTLibraryNonFatalException("No index given.");
		}

		List<String> tmp = new ArrayList<String>();
		for (Integer index : indexes) {
			tmp.add(index.toString());
		}
		String items = String.format("index(es) '%s'", Python.join(", ", tmp));
		logging.info(String.format("Unselecting %s from list '%s'.", items, control));

		Select select = getSelectList(window, control);

		if (!isMultiselectList(select)) {
			throw new ABTLibraryNonFatalException("Keyword 'Unselect from list' works only for multiselect lists.");
		}

		for (int index : indexes) {
			select.deselectByIndex(index);
		}
	}

	/**
	 * Unselect the given <b>*values</b> of the multi-select list identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the multi-select list.
	 * @param values
	 *            The list of values to select
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "*values" })
	public void unselectFromListByValue(String window, String control, String... values) {
		if (values.equals(null)) {
			throw new ABTLibraryNonFatalException("No value given.");
		}

		String items = String.format("value(s) '%s'", Python.join(", ", values));
		logging.info(String.format("Unselecting %s from list '%s'.", items, control));

		Select select = getSelectList(window, control);

		if (!isMultiselectList(select)) {
			throw new ABTLibraryNonFatalException("Keyword 'Unselect from list' works only for multiselect lists.");
		}

		for (String value : values) {
			select.deselectByValue(value);
		}
	}

	/**
	 * Unselect the given <b>*labels</b> of the multi-select list identified by
	 * <b>locator</b>.<br>
	 * <br>
	 * Select list keywords work on both lists and combo boxes. Key attributes
	 * for select lists are id and name. See `Introduction` for details about
	 * locators.<br>
	 * 
	 * @param window
	 *            The interface name that contains control. If control has not
	 *            been defined, using <b>*</b> for window.
	 * @param control
	 *            The locator to locate the multi-select list.
	 * @param labels
	 *            The list of labels to select
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "locator", "*labels" })
	public void unselectFromListByLabel(String window, String control, String... labels) {
		if (labels.equals(null)) {
			throw new ABTLibraryNonFatalException("No value given.");
		}

		String items = String.format("label(s) '%s'", Python.join(", ", labels));
		logging.info(String.format("Unselecting %s from list '%s'.", items, control));

		Select select = getSelectList(window, control);

		if (!isMultiselectList(select)) {
			throw new ABTLibraryNonFatalException("Keyword 'Unselect from list' works only for multiselect lists.");
		}

		for (String label : labels) {
			select.deselectByVisibleText(label);
		}
	}

	// ##############################
	// Internal Methods
	// ##############################

	public List<String> getLabelsForOptions(List<WebElement> options) {
		List<String> labels = new ArrayList<String>();

		for (WebElement option : options) {
			labels.add(option.getText());
		}

		return labels;
	}

	protected Select getSelectList(String window, String control) {
		List<WebElement> webElements = element.elementFind(window, control, true, true, "select");

		return new Select(webElements.get(0));
	}

	protected List<WebElement> getSelectListOptions(Select select) {
		return new ArrayList<WebElement>(select.getOptions());
	}

	protected List<WebElement> getSelectListOptions(String window, String control) {
		Select select = getSelectList(window, control);

		return getSelectListOptions(select);
	}

	protected List<WebElement> getSelectListOptionsSelected(String window, String control) {
		Select select = getSelectList(window, control);

		return new ArrayList<WebElement>(select.getAllSelectedOptions());
	}

	protected List<String> getValuesForOptions(List<WebElement> options) {
		ArrayList<String> labels = new ArrayList<String>();

		for (WebElement option : options) {
			labels.add(option.getAttribute("value"));
		}

		return labels;
	}

	protected boolean isMultiselectList(Select select) {
		return select.isMultiple();
	}

}
