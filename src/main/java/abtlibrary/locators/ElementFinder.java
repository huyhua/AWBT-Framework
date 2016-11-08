package abtlibrary.locators;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.python.util.PythonInterpreter;

import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.keywords.selenium2library.BrowserManagement;
import abtlibrary.keywords.selenium2library.Element;
import abtlibrary.utils.Python;
import io.appium.java_client.android.AndroidDriver;

public class ElementFinder {

	protected final static Hashtable<String, CustomStrategy> registeredLocationStrategies = new Hashtable<String, CustomStrategy>();

	protected enum KeyAttrs {
		DEFAULT("@id,@name"), A("@id,@name,@href,normalize-space(descendant-or-self::text())"), IMG(
				"@id,@name,@src,@alt"), INPUT("@id,@name,@value,@src"), BUTTON(
						"@id,@name,@value,normalize-space(descendant-or-self::text())");

		protected String[] keyAttrs;

		KeyAttrs(String keyAttrs) {
			this.keyAttrs = keyAttrs.split(",");
		}

		public String[] getKeyAttrs() {
			return keyAttrs;
		}
	}

	protected interface Strategy {
		List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates);

	};

	protected enum StrategyEnum implements Strategy {
		DEFAULT {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {
				if (findByCoordinates.criteria.startsWith("//")) {
					return XPATH.findBy(browserManagement, findByCoordinates);
				}
				return findByKeyAttrs(browserManagement.getCurrentWebDriver(), findByCoordinates);
			}
		},
		IDENTIFIER {

			@SuppressWarnings("unchecked")
			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {
				List<WebElement> elements = browserManagement.getCurrentWebDriver()
						.findElements(By.id(findByCoordinates.criteria));
				elements.addAll(
						browserManagement.getCurrentWebDriver().findElements(By.name(findByCoordinates.criteria)));
				if (browserManagement.getCurrentPlatform().equalsIgnoreCase("Android")) {
					elements.addAll(((AndroidDriver<WebElement>) browserManagement.getCurrentWebDriver())
							.findElementsByAndroidUIAutomator(
									"new UiScrollable(new UiSelector().scrollable(True)).scrollIntoView(new UiSelector().resourceId(\""
											+ findByCoordinates.criteria + "\"))"));
				}

				return filterElements(elements, findByCoordinates);
			}
		},
		ID {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {
				return filterElements(
						browserManagement.getCurrentWebDriver().findElements(By.id(findByCoordinates.criteria)),
						findByCoordinates);
			}
		},
		NAME {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {
				return filterElements(
						browserManagement.getCurrentWebDriver().findElements(By.name(findByCoordinates.criteria)),
						findByCoordinates);
			}
		},
		XPATH {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {
				List<WebElement> elements = new ArrayList<WebElement>();
				if (browserManagement.getCurrentPlatform().equalsIgnoreCase("Android")) {
					if (findByUiSelector(browserManagement.getCurrentWebDriver(), findByCoordinates) != null) {
						elements = findByUiSelector(browserManagement.getCurrentWebDriver(), findByCoordinates);
					}
				} else {
					elements = browserManagement.getCurrentWebDriver()
							.findElements(By.xpath(findByCoordinates.criteria));
				}
				elements.addAll(browserManagement.getCurrentWebDriver()
						.findElements(By.xpath(findByCoordinates.criteria)));
				return filterElements(elements, findByCoordinates);
			}
		},
		DOM {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {
				Object result = ((JavascriptExecutor) browserManagement.getCurrentWebDriver())
						.executeScript(String.format("return %s;", findByCoordinates.criteria));
				return filterElements(toList(result), findByCoordinates);
			}
		},
		LINK {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {
				return filterElements(
						browserManagement.getCurrentWebDriver().findElements(By.linkText(findByCoordinates.criteria)),
						findByCoordinates);
			}
		},
		CSS {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {
				return filterElements(browserManagement.getCurrentWebDriver()
						.findElements(By.cssSelector(findByCoordinates.criteria)), findByCoordinates);
			}
		},
		TAG {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {
				return filterElements(
						browserManagement.getCurrentWebDriver().findElements(By.tagName(findByCoordinates.criteria)),
						findByCoordinates);
			}
		},
		JQUERY {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {

				return findByJQuerySizzle(browserManagement.getCurrentWebDriver(), findByCoordinates);
			}

		},
		SIZZLE {

			@Override
			public List<WebElement> findBy(BrowserManagement browserManagement, FindByCoordinates findByCoordinates) {

				return findByJQuerySizzle(browserManagement.getCurrentWebDriver(), findByCoordinates);
			}

		};

	}

	protected static List<WebElement> findByJQuerySizzle(WebDriver webDriver, FindByCoordinates findByCoordinates) {
		String js = String.format("return jQuery('%s').get();", findByCoordinates.criteria.replace("'", "\\'"));

		Object o = ((JavascriptExecutor) webDriver).executeScript(js);
		List<WebElement> list = toList(o);
		return filterElements(list, findByCoordinates);
	}

	protected static List<WebElement> filterElements(List<WebElement> elements, FindByCoordinates findByCoordinates) {
		if (findByCoordinates.tag == null) {
			return elements;
		}

		List<WebElement> result = new ArrayList<WebElement>();
		for (WebElement element : elements) {
			if (elementMatches(element, findByCoordinates)) {
				result.add(element);
			}
		}
		return result;
	}

	protected static boolean elementMatches(WebElement element, FindByCoordinates findByCoordinates) {
		if (!element.getTagName().toLowerCase().equals(findByCoordinates.tag)) {
			return false;
		}

		if (findByCoordinates.constraints != null) {
			for (String name : findByCoordinates.constraints.keySet()) {
				if (!element.getAttribute(name).equals(findByCoordinates.constraints.get(name))) {
					return false;
				}
			}
		}

		return true;
	}

	protected static List<WebElement> findByKeyAttrs(WebDriver webDriver, FindByCoordinates findByCoordinates) {
		KeyAttrs keyAttrs = KeyAttrs.DEFAULT;
		if (findByCoordinates.tag != null) {
			try {
				keyAttrs = KeyAttrs.valueOf(findByCoordinates.tag.trim().toUpperCase());
			} catch (IllegalArgumentException e) {
				// No special keyAttrs available for this tag
			}
		}
		String xpathCriteria = Element.escapeXpathValue(findByCoordinates.criteria);
		String xpathTag = findByCoordinates.tag;
		if (findByCoordinates.tag == null) {
			xpathTag = "*";
		}
		List<String> xpathConstraints = new ArrayList<String>();
		if (findByCoordinates.constraints != null) {
			for (Entry<String, String> entry : findByCoordinates.constraints.entrySet()) {
				xpathConstraints.add(String.format("@%s='%s'", entry.getKey(), entry.getValue()));
			}
		}
		List<String> xpathSearchers = new ArrayList<String>();
		for (String attr : keyAttrs.getKeyAttrs()) {
			xpathSearchers.add(String.format("%s=%s", attr, xpathCriteria));
		}
		xpathSearchers.addAll(getAttrsWithUrl(webDriver, keyAttrs, findByCoordinates.criteria));
		String xpath = String.format("//%s[%s(%s)]", xpathTag,
				Python.join(" and ", xpathConstraints) + (xpathConstraints.size() > 0 ? " and " : ""),
				Python.join(" or ", xpathSearchers));

		return webDriver.findElements(By.xpath(xpath));
	}

	protected static List<String> getAttrsWithUrl(WebDriver webDriver, KeyAttrs keyAttrs, String criteria) {
		List<String> attrs = new ArrayList<String>();
		String url = null;
		String xpathUrl = null;
		String[] srcHref = { "@src", "@href" };
		for (String attr : srcHref) {
			for (String keyAttr : keyAttrs.getKeyAttrs()) {
				if (attr.equals(keyAttr)) {
					if (url == null || xpathUrl == null) {
						url = getBaseUrl(webDriver) + "/" + criteria;
						xpathUrl = Element.escapeXpathValue(url);
					}
					attrs.add(String.format("%s=%s", attr, xpathUrl));
				}
			}
		}
		return attrs;
	}

	@SuppressWarnings("unchecked")
	protected static List<WebElement> findByUiSelector(WebDriver webDriver, FindByCoordinates findByCoordinates) {
		String[] androidAttr = { "@resource-id", "@content-desc", "@text" };
		String xpathCriteria = Element.escapeXpathValue(findByCoordinates.criteria);
		List<String> selectors = new ArrayList<String>();
		for (String attr : androidAttr) {
			String[] locatorParts = xpathCriteria.split("=");
			int indexValue = -1;
			for (int i = 0; i < locatorParts.length; i++) {
				if (locatorParts[i].contains(attr)) {
					indexValue = i + 1;
					break;
				}
			}
			if (indexValue > -1) {
				String value = locatorParts[indexValue].split("'")[1];
				if (value != null) {
					if (attr.equals("@resource-id")) {
						selectors.add("resourceId(\"" + value + "\")");
					} else if (attr.equals("@content-desc")) {
						selectors.add("descriptionContains(\"" + value + "\")");
					} else {
						selectors.add("text(\"" + value + "\")");
					}
				}

			}
		}
		
		List<WebElement> scroll = ((AndroidDriver<WebElement>) webDriver).findElementsByAndroidUIAutomator(".scrollable(true)");

		String uiSelector = String.format(
				"new UiScrollable(new UiSelector().scrollable(true).instance("+(scroll.size()-1)+").scrollIntoView(new UiSelector().%s)",
				Python.join(".", selectors));

		try {
			return ((AndroidDriver<WebElement>) webDriver).findElementsByAndroidUIAutomator(uiSelector);
		} catch (Exception e) {
			return null;
		}
	}

	protected static String getBaseUrl(WebDriver webDriver) {
		String url = webDriver.getCurrentUrl();
		int lastIndex = url.lastIndexOf('/');
		if (lastIndex != -1) {
			url = url.substring(0, lastIndex);
		}
		return url;
	}

	public static void addLocationStrategy(String strategyName, String functionDefinition, String delimiter) {
		registeredLocationStrategies.put(strategyName.toUpperCase(), new CustomStrategy(functionDefinition, delimiter));
	}

	public static List<WebElement> find(BrowserManagement browserManagement, String locator) {
		return find(browserManagement, locator, null);
	}

	public static List<WebElement> find(BrowserManagement browserManagement, String locator, String tag) {
		if (browserManagement.getCurrentWebDriver() == null) {
			throw new ABTLibraryNonFatalException("ElementFinder.find: webDriver is null.");
		}
		if (locator == null) {
			throw new ABTLibraryNonFatalException("ElementFinder.find: locator is null.");
		}

		FindByCoordinates findByCoordinates = new FindByCoordinates();
		Strategy strategy = parseLocator(findByCoordinates, locator);
		parseTag(findByCoordinates, strategy, tag);
		return strategy.findBy(browserManagement, findByCoordinates);
	}

	protected static ThreadLocal<PythonInterpreter> loggingPythonInterpreter = new ThreadLocal<PythonInterpreter>() {

		@Override
		protected PythonInterpreter initialValue() {
			PythonInterpreter pythonInterpreter = new PythonInterpreter();
			pythonInterpreter.exec("from robot.libraries.BuiltIn import BuiltIn; from robot.api import logger;");
			return pythonInterpreter;
		}
	};

	protected static void warn(String msg) {
		loggingPythonInterpreter.get()
				.exec(String.format("logger.warn('%s');", msg.replace("'", "\\'").replace("\n", "\\n")));
	}

	protected static Strategy parseLocator(FindByCoordinates findByCoordinates, String locator) {
		String prefix = null;
		String criteria = locator;
		if (!locator.startsWith("//")) {
			String[] locatorParts = locator.split("=", 2);
			if (locatorParts.length == 2) {
				prefix = locatorParts[0].trim().toUpperCase();
				criteria = locatorParts[1].trim();
			}
		}

		Strategy strategy = StrategyEnum.DEFAULT;
		if (prefix != null) {
			try {
				strategy = StrategyEnum.valueOf(prefix);
			} catch (IllegalArgumentException e) {
				// No standard locator type. Look for custom strategy
				CustomStrategy customStrategy = registeredLocationStrategies.get(prefix);
				if (customStrategy != null) {
					strategy = customStrategy;
				}
			}
		}
		findByCoordinates.criteria = criteria;
		return strategy;
	}

	protected static void parseTag(FindByCoordinates findByCoordinates, Strategy strategy, String tag) {
		if (tag == null) {
			return;
		}
		tag = tag.toLowerCase();
		Map<String, String> constraints = new TreeMap<String, String>();
		if (tag.equals("link")) {
			tag = "a";
		} else if (tag.equals("image")) {
			tag = "img";
		} else if (tag.equals("list")) {
			tag = "select";
		} else if (tag.equals("text area")) {
			tag = "textarea";
		} else if (tag.equals("radio button")) {
			tag = "input";
			constraints.put("type", "radio");
		} else if (tag.equals("checkbox")) {
			tag = "input";
			constraints.put("type", "checkbox");
		} else if (tag.equals("text field")) {
			tag = "input";
			constraints.put("type", "text");
		} else if (tag.equals("file upload")) {
			tag = "input";
			constraints.put("type", "file");
		}
		findByCoordinates.tag = tag;
		findByCoordinates.constraints = constraints;
	}

	@SuppressWarnings("unchecked")
	protected static List<WebElement> toList(Object o) {
		if (o instanceof List<?>) {
			return (List<WebElement>) o;
		}
		List<WebElement> list = new ArrayList<WebElement>();
		if (o instanceof WebElement) {
			list.add((WebElement) o);
			return list;
		}
		return list;
	}

	protected static class FindByCoordinates {

		String criteria;
		String tag;
		Map<String, String> constraints;
	}

	protected static class CustomStrategy implements Strategy {

		protected String functionDefinition;

		protected String delimiter;

		public CustomStrategy(String functionDefinition, String delimiter) {
			this.functionDefinition = functionDefinition;
			this.delimiter = delimiter;
		}

		@Override
		public List<WebElement> findBy(final BrowserManagement browserManagement,
				final FindByCoordinates findByCoordinates) {
			return filterElements(browserManagement.getCurrentWebDriver().findElements(new By() {

				@Override
				public List<WebElement> findElements(SearchContext context) {
					Object[] arguments = null;
					if (delimiter == null) {
						arguments = new Object[1];
						arguments[0] = findByCoordinates.criteria;
					} else {
						String[] splittedCriteria = findByCoordinates.criteria.split(delimiter);
						arguments = new Object[splittedCriteria.length];
						for (int i = 0; i < splittedCriteria.length; i++) {
							arguments[i] = splittedCriteria[i];
						}
					}
					Object o = ((JavascriptExecutor) browserManagement.getCurrentWebDriver())
							.executeScript(functionDefinition, arguments);
					return toList(o);
				}

			}), findByCoordinates);
		}
	}
}
