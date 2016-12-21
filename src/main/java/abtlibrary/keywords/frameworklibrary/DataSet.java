package abtlibrary.keywords.frameworklibrary;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.operatinglibrary.OperatingSystem;
import abtlibrary.keywords.selenium2library.Logging;
import abtlibrary.utils.Excel;
import abtlibrary.utils.Python;

/**
 * Keywords related to Dataset of Robot Framework
 * 
 * @author khoivo
 *
 */
@RobotKeywords
public class DataSet extends RunOnFailureKeywordsAdapter {

	@Autowired
	Initialization init;

	/**
	 * Instantiated OpenrationSysteam
	 */
	protected OperatingSystem os = new OperatingSystem();

	/**
	 * Instantiated Excel
	 */
	protected Excel excel = new Excel();

	/**
	 * Instantiated Logging keyword bean
	 */
	@Autowired
	protected Logging logging;

	@Autowired
	protected Action action;

	private String[] headers;

	// ##############################
	// Keywords
	// ##############################

	public static void main(String[] args) throws ScriptException {
		DataSet ds = new DataSet();
		ds.getCurrentDirectory();
		ds.useDataset("account", "valid");
	}

	@RobotKeyword
	public void getCurrentDirectory() {
	}

	/**
	 * Repeat sequence action lines with data rows from data set file.
	 * 
	 * @param name
	 *            Name of data set file
	 * @param filter
	 *            Name of filter. Adding Filter column to data set file to
	 *            filter data rows.
	 * @throws ScriptException
	 */
	@RobotKeyword
	@ArgumentNames({ "name", "filter=NONE" })
	public void useDataset(String name, String filter) throws ScriptException {
		ScriptEngine engine1 = new ScriptEngineManager().getEngineByName("python");
		engine1.eval("from robot.libraries.BuiltIn import BuiltIn");
		String suitePath = action.getVariable("SUITE SOURCE");
		String testcaseName = action.getVariable("TEST NAME");
		List<String[]> dataset = getDataSet(name, filter);

		List<String> actionBlock = getDatasetBlock(suitePath, testcaseName);
		List<List<String>> keywords = new ArrayList<List<String>>();
		for (String line : actionBlock) {
			String temp = line.replace("\t", "").trim();
			if (!temp.startsWith("#") && !temp.equals("")) {
				List<String> keyword = new ArrayList<String>();
				String[] keywordTemp = line.split("\t");
				for (String att : keywordTemp) {
					att = att.replace("\t", "").trim();
					if (!att.equals("")) {
						keyword.add(att);
					}
				}
				if (keyword != null) {
					keywords.add(keyword);
				}
			}
		}

		
		for (int i = 0; i < dataset.size(); i++) {
			if (i == 0) {
				headers = dataset.get(0);
			} else {
				for (int n = 0; n < headers.length; n++) {
					action.setVariable(headers[n], dataset.get(i)[n]);
				}
				if (i < dataset.size() - 1) {
					for (List<String> keyword : keywords) {
						String keywordName = keyword.get(0);
						if(keyword.size()>1){
						String arg = "'" + Python.join("','", keyword.subList(1, keyword.size())) + "'";
						engine1.eval("BuiltIn().run_keyword('" + keywordName + "'," + arg + ")");
						} else {
							engine1.eval("BuiltIn().run_keyword('" + keywordName + "')");
						}
					}
				}
			}
		}

	}

	@RobotKeyword
	public void repeatForDataset() {

	}

	@RobotKeywordOverload
	public List<String[]> getDataSet(String dataSet) {
		return excel.getExcelSheet(init.getDatasetDirectory() + "/" + dataSet + ".xlsx", "", 0, 0);
	}

	@RobotKeyword
	@ArgumentNames({ "dataSet", "filter=NONE" })
	public List<String[]> getDataSet(String dataSet, String filter) {
		List<String[]> filterDataset = new ArrayList<String[]>();
		List<String[]> dataset = excel.getExcelSheet(init.getDatasetDirectory() + "/" + dataSet + ".xlsx", "", 0, 0);
		String[] headers = dataset.get(0);

		// Get filter column index
		int filterColIndex = -1;
		for (int i = headers.length - 1; i >= 0; i--) {
			if (headers[i].equalsIgnoreCase("Filter")) {
				filterColIndex = i;
				break;
			}
		}

		if (filterColIndex == -1) {
			throw new ABTLibraryNonFatalException(String.format(
					"Could not find 'Filter' column in '%s' dataset. Please add column with name 'Filter' and run again!",
					dataSet));
		}

		if (filter.equals("NONE")) {
			filterDataset.addAll(dataset);
		} else {
			filterDataset.add(headers);
			for (int i = 1; i < dataset.size(); i++) {
				String[] dataRow = dataset.get(i);
				if (dataRow[filterColIndex].equalsIgnoreCase(filter)) {
					filterDataset.add(dataRow);
				}
			}
		}

		return filterDataset;
	}

	@RobotKeyword
	@ArgumentNames({ "suite", "testcase" })
	public String parseBlockToKeyword(String suitePath, String testcaseName) {
		List<String> blockKeywords = getDatasetBlock(suitePath, testcaseName);
		String timeStamp = os.getTimeStamp();
		String tempDirectory = init.getTempActionDir() + "/" + timeStamp;
		String content = "*** Keywords ***\n";
		content = content + testcaseName + "\n";
		for (String line : blockKeywords) {
			content = content + line + "\n";
		}

		os.createTextFile(tempDirectory + "/" + testcaseName + ".txt", content);

		return tempDirectory + "/" + testcaseName + ".txt";
	}

	@RobotKeyword
	@ArgumentNames({ "suite" })
	public List<String> getTestCases(String suitePath) {
		List<String> testCases = new ArrayList<String>();
		List<String> lines = os.readFile(suitePath);
		int indexTestCasesTable = lines.indexOf("*** Test Cases ***");
		for (int i = indexTestCasesTable + 1; i < lines.size(); i++) {
			String curLine = lines.get(i);

			if (curLine.startsWith("***")) {
				break;
			}
			if (!curLine.startsWith("#") && !curLine.startsWith("\t") && !curLine.startsWith("  ")) {
				testCases.add(curLine);
			}
		}
		return testCases;
	}

	@RobotKeyword
	@ArgumentNames({ "suite", "testcase" })
	public List<String> getContentOfTestCase(String suitePath, String testcaseName) {
		List<String> contentBlock = new ArrayList<String>();
		List<String> lines = os.readFile(suitePath);
		List<String> testCases = getTestCases(suitePath);
		int indexOfTestCase = testCases.indexOf(testcaseName);
		int startBlock = -1;
		int endBlock = -1;

		if (indexOfTestCase > -1) {
			startBlock = lines.indexOf(testcaseName) + 1;

			if ((indexOfTestCase + 1) < testCases.size()) {
				endBlock = lines.indexOf(testCases.get(indexOfTestCase + 1));
			} else {
				endBlock = lines.size();
			}

			for (int i = startBlock; i < endBlock; i++) {
				String curLine = lines.get(i);
				if (curLine.startsWith("***")) {
					break;
				}
				contentBlock.add(curLine);
			}
		}
		return contentBlock;
	}

	@RobotKeyword
	@ArgumentNames({ "suite", "testcase" })
	public List<String> getDatasetBlock(String suitePath, String testcaseName) {
		List<String> contentBlock = getContentOfTestCase(suitePath, testcaseName);
		int indexOfUseDataSet = -1;
		int indexOfEndDataSet = -1;
		List<String> dataSetBlock = new ArrayList<String>();
		for (int i = 0; i < contentBlock.size(); i++) {
			if (contentBlock.get(i).trim().startsWith("use data set")) {
				indexOfUseDataSet = i;
			}
			if (contentBlock.get(i).trim().startsWith("repeat for data set")) {
				indexOfEndDataSet = i;
				break;
			}
		}
		if (indexOfUseDataSet == -1) {
			logging.warn("Could not find action 'use data set' in testcase.");
		} else {
			if (indexOfEndDataSet == -1) {
				indexOfEndDataSet = contentBlock.size();
				logging.warn(
						"Could not find action 'repeat for data set' in testcase. All keywords under 'use data set' keyword will be looped.");
			}
			dataSetBlock = contentBlock.subList(indexOfUseDataSet + 1, indexOfEndDataSet);

		}
		return dataSetBlock;

	}
}
