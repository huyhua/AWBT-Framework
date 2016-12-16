package abtlibrary.keywords.frameworklibrary;

import java.util.ArrayList;
import java.util.List;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.w3c.dom.Element;

import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.operatinglibrary.OperatingSystem;
import abtlibrary.keywords.selenium2library.BrowserManagement;
import abtlibrary.utils.Interfaces;

@RobotKeywords
public class UserInterface extends RunOnFailureKeywordsAdapter {

	@Autowired
	Initialization init;

	/**
	 * Instantiated OpenrationSysteam
	 */
	protected OperatingSystem os = new OperatingSystem();

	/**
	 * Instantiated Interfaces
	 */
	protected Interfaces interfaces = new Interfaces();

	/**
	 * Instantiated BrowserManagement keyword bean
	 */
	@Autowired
	protected BrowserManagement browserManagement;

	// ##############################
	// Keywords
	// ##############################
	@RobotKeywordOverload
	public void useInterface() {
		useInterface("");
	}

	/**
	 * Initialize Interface to use in test scripts or actions.<br>
	 * 
	 * @param name
	 *            the sub-folder of Interface folder.
	 */
	@RobotKeyword
	@ArgumentNames({ "name=NONE" })
	public void useInterface(String name) {
		interfaces.tempInterfaceDir = init.getTempInterfaceDir();
		interfaces.initInterface(init.getInterfaceDirectory(), name);
	}

	/**
	 * Retrieves all locators that match with specified element from repository.
	 * <br>
	 * 
	 * @param elementName
	 *            element name
	 * @return the list of locators
	 */
	/*@RobotKeyword
	@ArgumentNames({ "name" })
	public List<String> getLocators(String name) {
		List<String> locators = new ArrayList<String>();

		List<Element> elements = interfaces.getDefinedElements(init.getTempInterfaceDir() + "/Interface.xml");
		for (Element element : elements) {
			String elementName = element.getElementsByTagName("name").item(0).getTextContent();
			if (elementName.equalsIgnoreCase(name)) {
				locators.add(element.getElementsByTagName("locator").item(0).getTextContent());
			}
		}
		return locators;
	}*/

	/**
	 * Retrieves all locators that match with specified element and window from
	 * repository. <br>
	 * 
	 * @param window
	 *            Name of interface contains control.
	 * @param control
	 *            The test name of control captured in interfaces
	 * @return the list of locators
	 */
	@RobotKeyword
	@ArgumentNames({ "window", "element" })
	public List<String> getLocators(String window, String control) {
		List<String> locators = new ArrayList<String>();
		String platform = browserManagement.getCurrentPlatform().toLowerCase();
		List<Element> eleNodes = interfaces.getDefinedElements(init.getTempInterfaceDir() + "/Interface.xml", window, platform);
		for (Element eleNode : eleNodes) {
			String elementName = eleNode.getElementsByTagName("name").item(0).getTextContent();
			if (elementName.equalsIgnoreCase(control)) {
				locators.add(eleNode.getElementsByTagName("locator").item(0).getTextContent());
			}
		}
		return locators;
	}
}