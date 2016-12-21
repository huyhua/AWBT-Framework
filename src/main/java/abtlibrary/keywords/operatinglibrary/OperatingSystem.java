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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import abtlibrary.ABTLibraryFatalException;
import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.frameworklibrary.Action;

@RobotKeywords
public class OperatingSystem extends RunOnFailureKeywordsAdapter {

	@Autowired
	protected Action action;

	/**
	 * For Testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		OperatingSystem os = new OperatingSystem();
		String temp = os.getSubString("//[@resource-id= 'test']",
				"(@resource-id.?=.?['|\"](.*?)['|\"]|contains\\(.?@resource-id.*?\\))");
		System.out.println(temp);
		System.out.println(os.getSubString(temp, "(\"|')(.*?)(\"|')"));
	}

	/**
	 * Returns value of specified key in .properties file.
	 * 
	 * @param filename
	 *            file path.
	 * @param key
	 *            Key of property.
	 * @param returns
	 *            The return variable.
	 * @return : returned value.
	 * @throws ScriptException
	 */
	@RobotKeyword
	@ArgumentNames({ "filename", "key", "returns=NONE" })
	public String getPropertyFromFile(String filename, String key, String returns) throws ScriptException {
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
		if (!returns.equalsIgnoreCase("NONE")) {
			action.setVariable(returns, value);
		}
		return value;
	}

	@RobotKeywordOverload
	public String getConfiguration(String key) {
		String property = "";
		try {
			property = getConfiguration(key, "NONE");
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property;
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
	 *            Key of property.
	 * @param returns
	 *            Variable to store returned property.
	 * @return return value of keyword.
	 * @throws ScriptException
	 */
	@RobotKeyword
	@ArgumentNames({ "key", "returns=NONE" })
	public String getConfiguration(String key, String returns) throws ScriptException {
		String filename = "";
		if (System.getProperty("os.name").contains("Mac")) {
			filename = "/Users/" + System.getProperty("user.name") + "/Desktop/TestData/";
		} else {
			filename = "C:\\TestData\\";
		}

		filename = filename + "configuration.properties";

		return getPropertyFromFile(filename, key, returns);
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
		if (folder.exists()) {
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
		} else {
			return null;
		}

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
	 * Splits text to array by specified delimiter.
	 * 
	 * @param orginalText
	 *            Specified text need to separate.
	 * @param delimiter
	 *            The character to separate text.
	 * @return List of sub strings separated from specified text by delimiter.
	 */
	@RobotKeyword
	@ArgumentNames({ "orginalText", "delimiter"})
	public String[] splitText(String orginalText, String delimiter) {
		String[] temp = orginalText.split(delimiter);
		String[] items = new String[temp.length];
		for (int i = 0; i < items.length; i++) {
			items[i] = temp[i].trim();
		}
		return items;
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
	 * Retrieves list of text between start and end text from specified text.
	 * <br>
	 * Split specified text by end text, if start text does not exist.<br>
	 * Split specified text by start text and retrieve a text list without first
	 * item if end text does not exist.<br>
	 * If both end and start text do not exist, retrieves null. <br>
	 * <b>Example: </b><br>
	 * original text: "a b c d a ef c". <br>
	 * start text: "a". end text: "c". <br>
	 * return: ['b','ef'].<br>
	 * 
	 * @param originalText
	 *            Original Text.
	 * @param startText
	 *            Start Text.
	 * @param endText
	 *            End Text.
	 * @return List of text between start and end text.
	 */
	public List<String> getMidText(String originalText, String startText, String endText) {
		List<String> midTextList = new ArrayList<String>();
		String[] tempList = originalText.split(startText);
		if (endText.equals("")) {
			endText = "<glna>";
		}
		for (int i = 1; i < tempList.length; i++) {
			if (tempList[i].indexOf(endText) > -1) {
				midTextList.add(tempList[i].substring(0, tempList[i].indexOf(endText)));
			} else if (tempList[i].indexOf(endText) == -1 && i == (tempList.length - 1)) {
				midTextList.add(tempList[i]);
			}
		}
		if (!originalText.contains(startText)) {
			if (tempList[0].indexOf(endText) > -1) {
				midTextList.add(tempList[0].substring(0, tempList[0].indexOf(endText)));
			}
		}
		return midTextList;
	}

	/**
	 * Retrieves sub-string matching with specified regex. <br>
	 * <b>Example:</b> <br>
	 * Using regex <b>'(.*?)'</b> to get sub-string <b>I have a sub-string</b>
	 * from String: <br>
	 * Hello world! I said: 'I have a sub-string'.
	 * 
	 * @param fullString
	 *            The original string.
	 * @param regex
	 *            The regular expression is used to find sub-string.
	 * @return The sub-strings match with regular expression.
	 */
	@RobotKeywordOverload
	@ArgumentNames({ "fullString", "regex" })
	public String getSubString(String fullString, String regex) {
		return getSubString(fullString, regex, "0");
	}

	/**
	 * Retrieves sub-string matching with specified regex. <br>
	 * <b>Example:</b> <br>
	 * Using regex <b>'(.*?)'</b> to get sub-string <b>I have a sub-string</b>
	 * from String: <br>
	 * Hello world! I said: 'I have a sub-string'.
	 * 
	 * @param fullString
	 *            The original string.
	 * @param regex
	 *            The regular expression is used to find sub-string.
	 * @param group
	 *            The index of matched sub-strings
	 * @return The sub-strings match with regular expression.
	 */

	@RobotKeyword
	@ArgumentNames({ "fullString", "regex", "group=NONE" })
	public String getSubString(String fullString, String regex, String group) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fullString);
		if (matcher.find()) {
			return matcher.group(Integer.parseInt(group));
		} else
			return "";
	}

	/**
	 * Generates unique string from original text by adding date time at the end
	 * of original text.
	 * 
	 * @param originalText
	 *            The original text.
	 * @return the unique text
	 */
	@RobotKeyword
	@ArgumentNames({ "originalText" })
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
