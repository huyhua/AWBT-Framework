package abtlibrary.keywords.frameworklibrary;

import java.util.ArrayList;
import java.util.List;

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

	// ##############################
	// Keywords
	// ##############################

	public static void main (String[] args){
		DataSet ds = new DataSet();
		ds.getCurrentDirectory();
		
		System.out.println(ds.getContentOfTestCase("/Users/mac/git/anisapp/Tests/BVT/LO01 - Verify Login.robot", "Verify functionality of Login with valid values"));
		System.out.println(ds.getDataSet("account").get(2)[0]);
		System.out.println(ds.getDatasetBlock("/Users/mac/git/anisapp/Tests/BVT/LO01 - Verify Login.robot", "Verify functionality of Login with valid values"));
	}
	@RobotKeyword
	public void getCurrentDirectory(){
		System.out.println(System.getProperty("user.dir"));
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
	@ArgumentNames({"suite","testcase"})
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
	@ArgumentNames({"suite"})
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
	@ArgumentNames({"suite","testcase"})
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
		System.out.println(contentBlock);
		return contentBlock;
	}

	@RobotKeyword
	@ArgumentNames({"suite","testcase"})
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
			logging.warn("Could not find keyword 'use data set' in testcase.");
		} else {
			if (indexOfEndDataSet == -1) {
				indexOfEndDataSet = contentBlock.size();
				logging.warn(
						"Could not find keyword 'repeat for data set' in testcase. All keywords under 'use data set' keyword will be looped.");
			}
			dataSetBlock = contentBlock.subList(indexOfUseDataSet + 1, indexOfEndDataSet);

		}
		System.out.println(dataSetBlock);
		return dataSetBlock;

	}
}
