package abtlibrary.keywords.frameworklibrary;

import java.util.ArrayList;
import java.util.List;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.w3c.dom.Element;

import abtlibrary.Constant;
import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.operatinglibrary.OperatingSystem;
import abtlibrary.utils.Interfaces;

@RobotKeywords
public class InterfaceManagement extends RunOnFailureKeywordsAdapter {

	/**
	 * Interface file path <br>
	 * Default path: <b>{TEMPDIR}/Interface/Interface.xml</b>
	 */
	protected String xmlInterfaceFile = Constant.tempInterfaceDir + "/Interface.xml";

	/**
	 * Instantiated OpenrationSysteam
	 */
	protected OperatingSystem os = new OperatingSystem();

	protected Interfaces interfaces = new Interfaces();

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
		interfaces.installXMLInterface(Constant.interfaceDir, name);
	}

	/**
	 * Returns all locators that match with element name defined in repository.
	 * <br>
	 * Get locators keyword will access the list of defined elements stored in
	 * <b>../Interface/Interface.xml</b> and retrieves locator of all matched
	 * elements.
	 * 
	 * @param elementName
	 *            element name
	 * @return the list of locators
	 */
	@RobotKeyword
	@ArgumentNames({ "elementName" })
	public List<String> getLocators(String elementName) {
		List<String> locators = new ArrayList<String>();

		List<Element> elements = interfaces.getDefinedElements(xmlInterfaceFile);
		for (Element element : elements) {
			String name = element.getElementsByTagName("name").item(0).getTextContent();
			if (name.equalsIgnoreCase(elementName)) {
				locators.add(element.getElementsByTagName("locator").item(0).getTextContent());
			}
		}
		return locators;
	}
}