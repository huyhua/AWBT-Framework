package abtlibrary.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	List<String[]> elements;
	OperatingSystem os = new OperatingSystem();

	public Interfaces() {

	}

	public Interfaces(String fileName, List<String[]> elements) {
		this.fileName = fileName;
		this.elements = elements;
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
			if(!directory.exists()){
				directory.mkdirs();
			}
			xmlFile.createNewFile();

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
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

				for (String[] element : interfaceInstant.elements) {
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
	 * Returns all interfaces included elements defined in
	 * <b>../Interface/*.txt.</b>
	 * 
	 * @return List of elements
	 */
	public List<Interfaces> getInterfaces(List<File> interfaceFiles) {
		List<Interfaces> interfaces = new ArrayList<Interfaces>();

		// Remove files that are not text file
		for (int i = 0; i < interfaceFiles.size(); i++) {
			String ext = FilenameUtils.getExtension(interfaceFiles.get(i).getAbsolutePath());
			if (!ext.equals("txt")) {
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
