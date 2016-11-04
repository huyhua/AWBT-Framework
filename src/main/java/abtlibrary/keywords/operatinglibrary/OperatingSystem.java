package abtlibrary.keywords.operatinglibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import abtlibrary.ABTLibraryFatalException;
import abtlibrary.RunOnFailureKeywordsAdapter;

@RobotKeywords
public class OperatingSystem extends RunOnFailureKeywordsAdapter {

	/**
	 * Returns value of specified key in .properties file.
	 * 
	 * @param filename
	 *            file path.
	 * @param key
	 *            keyword.
	 * @return : returned value.
	 */
	@RobotKeyword
	@ArgumentNames({ "filename", "key" })
	public String getPropertyFromFile(String filename, String key) {
		Properties prop = new Properties();
		InputStream input = null;
		String value = "";

		try {
			input = new FileInputStream(filename);
			// load a properties file
			prop.load(input);

			// get the property value
			value = prop.getProperty(key);

		} catch (IOException ex) {
			throw new ABTLibraryFatalException(String.format("No such file or directory '%s'", filename));
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	/**
	 * Returns value of key from configuration file (configuration.properties)
	 * <br>
	 * Get Configuration keyword gets value of specified key in configuration
	 * file in:<br>
	 * * (On Mac OS)<b> /Users/username/Desktop/TestData/</b> <br>
	 * * (On Window)<b> C:\TestData\</b>
	 * 
	 * @param key
	 *            : keyword
	 * @return return value of keyword.
	 */
	@RobotKeyword
	@ArgumentNames({ "key" })
	public String getConfiguration(String key) {
		String filename = "";
		if (System.getProperty("os.name").contains("Mac")) {
			filename = "/Users/" + System.getProperty("user.name") + "/Desktop/TestData/";
		} else {
			filename = "C:\\TestData\\";
		}

		filename = filename + "configuration.properties";

		return getPropertyFromFile(filename, key);
	}

	/**
	 * Returns all files in input directory.<br>
	 * 
	 * @param directorPath
	 *            absolute directory path.
	 * @return File list in specified directory.
	 */
	public List<File> getFiles(String directorPath) {
		File folder = new File(directorPath);
		File[] listOfFiles = folder.listFiles();
		List<File> files = new ArrayList<File>();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				files.add(file);
			} else if (file.isDirectory()) {
				files.addAll(getFiles(file.getAbsolutePath()));
			}
		}
		return files;
	}

	@RobotKeyword
	@ArgumentNames({ "filePath" })
	public List<String> readFile(String filePath) {
		BufferedReader br = null;
		List<String> lines = new ArrayList<String>();
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(filePath));

			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
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
		return lines;
	}

	/**
	 * Split text
	 * 
	 * @param orginalText
	 *            original text.
	 * @return String array.
	 */
	@RobotKeyword
	@ArgumentNames({ "originalText" })
	public String[] splitText(String orginalText) {
		return orginalText.split("\\t");
	}

	/**
	 * Creates a text file with content in specified absolute path.
	 * 
	 * @param filePath
	 *            absolute file path.
	 * @param content
	 *            content of text file.
	 */
	@RobotKeyword
	@ArgumentNames({ "filePath", "content" })
	public void createTextFile(String filePath, String content) {
		try {
			File file = new File(filePath);
			File directory = new File(file.getParent());
			if (!directory.exists()) {
				directory.mkdirs();
			}
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets time stamp in millisecond.
	 * 
	 * @return the timstamp string in milliseconds.
	 */
	@RobotKeyword
	public String getTimeStamp() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTimeInMillis() + "";
	}

	/**
	 * Generates unique string from original text by adding date time at the end
	 * of original text.
	 * 
	 * @param originalText
	 *            The original text.
	 * @return the unique text
	 */
	public String generateUniqueString(String originalText) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		return originalText + " - " + dateFormat.format(calendar.getTime());
	}

	public NodeList getXMLNodes(String xmlFile) {
		NodeList nodes = null;
		try {

			File file = new File(xmlFile);

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document doc = dBuilder.parse(file);

			if (doc.hasChildNodes()) {
				nodes = doc.getChildNodes();
			}

		} catch (Exception e) {
			throw new ABTLibraryFatalException(String.format("File '%s' is invalid or not well-format.", xmlFile));
		}
		return nodes;
	}
}
