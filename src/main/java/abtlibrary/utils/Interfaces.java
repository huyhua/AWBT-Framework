package abtlibrary.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import abtlibrary.ABTLibraryFatalException;
import abtlibrary.Constant;
import abtlibrary.keywords.operatinglibrary.OperatingSystem;

public class Interfaces {
	String fileName;
	List<String[]> elements1;

	String name;
	String platform;
	List<Map<String, String>> elements;

	OperatingSystem os = new OperatingSystem();

	public static void main(String[] args) {
		Interfaces interfaces = new Interfaces();
		interfaces
				.parseInterface("/Users/khoivo/git/ABTLibrary/src/test/robotframework/temp/interface {android}.robot");
	}

	public Interfaces() {

	}

	public Interfaces(String name, String platform, List<Map<String, String>> elements) {
		this.name = name;
		this.platform = platform;
		this.elements = elements;
	}

	public Interfaces(String fileName, List<String[]> elements) {
		this.fileName = fileName;
		this.elements1 = elements;
	}

	public void initInterface(String interfaceDirectory, String subDirectory) {
		File xmlFile = new File(Constant.tempInterfaceDir + "/Interface.xml");
		List<Interfaces> interfaces;
		List<File> interfaceFiles;
		Boolean updated = false;
		if (!subDirectory.equals("")) {
			interfaceFiles = os.getFiles(interfaceDirectory + "/" + subDirectory);
		} else {
			interfaceFiles = os.getFiles(interfaceDirectory);
		}
		interfaces = getInterfaces(interfaceFiles);

		if (xmlFile.exists()) {
			for (File interfaceFile : interfaceFiles) {
				if (interfaceFile.lastModified() > xmlFile.lastModified()) {
					updated = true;
					break;
				}
			}
			if (updated == true) {
				xmlFile.delete();
			}
		}

		try {
			File directory = new File(xmlFile.getParent());
			if (!directory.exists()) {
				directory.mkdirs();
			}
			xmlFile.createNewFile();

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements1
			Document doc = docBuilder.newDocument();
			Element rootNode = doc.createElement("interface");
			doc.appendChild(rootNode);

			for (Interfaces interfaceInstant : interfaces) {
				// ##################
				// File Node
				// ##################
				Element fileNode = doc.createElement("file");
				rootNode.appendChild(fileNode);

				// set attribute to file element
				Attr attr = doc.createAttribute("name");
				attr.setValue(interfaceInstant.fileName);
				fileNode.setAttributeNode(attr);

				for (String[] element : interfaceInstant.elements1) {
					// ##################
					// Element Node
					// ##################
					Element elementNode = doc.createElement("element");
					fileNode.appendChild(elementNode);

					// ##################
					// Name Node
					// ##################
					Element nameNode = doc.createElement("name");
					nameNode.appendChild(doc.createTextNode(element[0]));
					elementNode.appendChild(nameNode);

					// ##################
					// Name Node
					// ##################
					Element locatorNode = doc.createElement("locator");
					locatorNode.appendChild(doc.createTextNode(element[1]));
					elementNode.appendChild(locatorNode);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(xmlFile);
			transformer.transform(source, result);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public void installXMLInterface(String interfaceDirectory, String subDirectory) {
		File xmlFile = new File(Constant.tempInterfaceDir + "/Interface.xml");
		List<Interfaces> interfaces;
		List<File> interfaceFiles;
		Boolean updated = false;
		if (!subDirectory.equals("")) {
			interfaceFiles = os.getFiles(interfaceDirectory + "/" + subDirectory);
		} else {
			interfaceFiles = os.getFiles(interfaceDirectory);
		}
		interfaces = getInterfaces(interfaceFiles);

		if (xmlFile.exists()) {
			for (File interfaceFile : interfaceFiles) {
				if (interfaceFile.lastModified() > xmlFile.lastModified()) {
					updated = true;
					break;
				}
			}
			if (updated == true) {
				xmlFile.delete();
			}
		}

		try {
			File directory = new File(xmlFile.getParent());
			if (!directory.exists()) {
				directory.mkdirs();
			}
			xmlFile.createNewFile();

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements1
			Document doc = docBuilder.newDocument();
			Element rootNode = doc.createElement("interface");
			doc.appendChild(rootNode);

			for (Interfaces interfaceInstant : interfaces) {
				// ##################
				// File Node
				// ##################
				Element fileNode = doc.createElement("file");
				rootNode.appendChild(fileNode);

				// set attribute to file element
				Attr attr = doc.createAttribute("name");
				attr.setValue(interfaceInstant.fileName);
				fileNode.setAttributeNode(attr);

				for (String[] element : interfaceInstant.elements1) {
					// ##################
					// Element Node
					// ##################
					Element elementNode = doc.createElement("element");
					fileNode.appendChild(elementNode);

					// ##################
					// Name Node
					// ##################
					Element nameNode = doc.createElement("name");
					nameNode.appendChild(doc.createTextNode(element[0]));
					elementNode.appendChild(nameNode);

					// ##################
					// Name Node
					// ##################
					Element locatorNode = doc.createElement("locator");
					locatorNode.appendChild(doc.createTextNode(element[1]));
					elementNode.appendChild(locatorNode);
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(xmlFile);
			transformer.transform(source, result);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns all interfaces included elements1 defined in
	 * <b>../Interface/*</b>
	 * 
	 * @return The interface.
	 */
	public List<Interfaces> getInterfaces(List<File> interfaceFiles) {
		List<Interfaces> interfaces = new ArrayList<Interfaces>();

		// Remove files that are not text file
		for (int i = 0; i < interfaceFiles.size(); i++) {
			String ext = FilenameUtils.getExtension(interfaceFiles.get(i).getAbsolutePath());
			if (!ext.equals("txt") && !ext.equals("robot")) {
				interfaceFiles.remove(i);
			}
		}

		// Get element from interface file (.txt)
		for (File textInterfaceFile : interfaceFiles) {
			List<String[]> elements = new ArrayList<String[]>();

			String nameNode = "";
			String locatorNode = "";
			BufferedReader br = null;
			try {
				String sCurrentLine;
				br = new BufferedReader(new FileReader(textInterfaceFile.getAbsolutePath()));
				int i = 0;
				while ((sCurrentLine = br.readLine()) != null) {
					if (!sCurrentLine.startsWith("\t") && !sCurrentLine.startsWith("*") && !sCurrentLine.startsWith("#")
							&& !sCurrentLine.equals("")) {
						if (i == 0) {
							nameNode = sCurrentLine.trim();
							i++;
						}
					}
					if (sCurrentLine.trim().startsWith("[Return]")) {
						if (i == 1) {
							locatorNode = sCurrentLine.trim().substring(9).trim();
							i++;
						}
					}
					if (i == 2) {
						elements.add(new String[] { nameNode, locatorNode });
						i = 0;
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

			if (elements.size() > 0) {
				interfaces.add(new Interfaces(FilenameUtils.removeExtension(textInterfaceFile.getName()), elements));
			}
		}

		return interfaces;
	}

	public Interfaces parseInterface(String filePath) {
		OperatingSystem os = new OperatingSystem();
		List<String> lines = os.readFile(filePath);
		System.out.println(lines);

		String nameTag = "INTERFACE ENTITY";
		String elementTag = "interface element";

		String interfaceName = "";
		List<Map<String, String>> elements = new ArrayList<Map<String, String>>();

		/**
		 * Read each lines and parse to items of robot framework
		 */
		for (int i = 0; i < lines.size(); i++) {
			// Get interface name
			if (lines.get(i).contains(nameTag)) {
				interfaceName = os.getMidText(lines.get(i), nameTag, "").get(0).trim();
			}
			// Get interface elements1
			else if (lines.get(i).startsWith(elementTag)) {
				String[] argObject = lines.get(i).split("\t");
				List<String> ele = new ArrayList<String>();
				for (String attr : argObject) {
					if (!attr.equalsIgnoreCase(elementTag) && !attr.equals("") && attr != null) {
						ele.add(attr);
					}
				}

				List<String> headers = new ArrayList<String>();
				for (int n = i - 1; n > 0; n--) {
					if (lines.get(n).startsWith("#")) {
						String[] tempObject = lines.get(n).split("\t");
						for (String temp : tempObject) {
							if (!temp.equalsIgnoreCase("#") && !temp.equals("") && temp != null) {
								headers.add(temp);
							}
						}
						break;
					}

				}

				Map<String, String> element = new HashMap<String, String>();
				for (int x = 0; x < headers.size(); x++) {
					if (ele.get(x) != null) {
						element.put(headers.get(x), ele.get(x));
					}
				}
				elements.add(element);
			}

		}

		File file = new File(filePath);
		String tempName = FilenameUtils.removeExtension(file.getName());
		String platform = "default";
		if (tempName.contains("{")) {
			platform = tempName.substring(tempName.indexOf("{") + 1, tempName.length() - 1);
		}

		Interfaces interfaces = new Interfaces(interfaceName, platform, elements);

		return interfaces;
	}

	/**
	 * Get all elements are defined in repo.
	 * 
	 * @param xmlInterfaceFile
	 * @return list of elements.
	 */
	public List<Element> getDefinedElements(String xmlInterfaceFile) {
		List<Element> capturedElements = new ArrayList<Element>();
		try {
			NodeList nodes = os.getXMLNodes(xmlInterfaceFile);
			// Get all file nodes
			NodeList fileNodes = nodes.item(0).getChildNodes();
			for (int i = 0; i < fileNodes.getLength(); i++) {
				// Get all element nodes
				NodeList elements = fileNodes.item(i).getChildNodes();

				for (int n = 0; n < elements.getLength(); n++) {
					if (elements.item(n).getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) elements.item(n);
						capturedElements.add(element);
					}
				}

			}
		} catch (Exception e) {
			throw new ABTLibraryFatalException(
					String.format("File '%s' is not well-format. Please re-format and run again!", xmlInterfaceFile));
		}
		return capturedElements;

	}
}
