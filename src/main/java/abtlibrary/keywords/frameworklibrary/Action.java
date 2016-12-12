package abtlibrary.keywords.frameworklibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.ABTLibraryFatalException;
import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.Constant;
import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.operatinglibrary.OperatingSystem;
import abtlibrary.utils.Python;

@RobotKeywords
public class Action extends RunOnFailureKeywordsAdapter {

	public static void main(String[] args) {
		Action action = new Action();
		System.out.println(action.parseToRFKeyword("/Users/khoivo/git/ABTLibrary/src/test/robotframework/temp/test_action.robot"));
	}

	@Autowired
	Initialization init;

	// ##############################
	// Keywords
	// ##############################
	@RobotKeywordOverload
	public String parseAction() {
		return parseAction("NONE");
	}

	/**
	 * Parses all actions in specified folder for using.
	 * 
	 * @param folder
	 *            Specified action folder
	 * @return Action file path.
	 */
	@RobotKeyword
	@ArgumentNames({ "folder=NONE" })
	public String parseAction(String folder) {
		if (folder.equals("NONE")) {
			folder = "";
		}

		OperatingSystem os = new OperatingSystem();
		List<File> fActions = os.getFiles(init.getActionDirectory() + "/" + folder);
		List<File> valueToRemove = new ArrayList<>();

		if (fActions == null) {
			throw new ABTLibraryNonFatalException(
					String.format("Could not find action directory '%s'.", init.getActionDirectory() + "/" + folder));
		}

		fActions.forEach(file -> {
			String ext = FilenameUtils.getExtension(file.getName());
			if (!ext.equalsIgnoreCase("robot") && !ext.equalsIgnoreCase("txt")) {
				valueToRemove.add(file);
			}
		});
		fActions.removeAll(valueToRemove);

		List<String> actions = new ArrayList<>();
		for (File fAction : fActions) {

			actions.add(parseToRFKeyword(fAction.getAbsolutePath()));
		}
		String content = "*** Keywords ***\n" + Python.join("\n", actions);
		os.createTextFile(Constant.tempActionDir + "/Action.robot", content);
		return Constant.tempActionDir + "/Action.robot";
	}

	// ##############################
	// Internal Methods
	// ##############################
	public String parseToRFKeyword(String filePath) {
		OperatingSystem os = new OperatingSystem();
		List<String> lines = os.readFile(filePath);

		String nameTag = "ACTION DEFINITION";
		String descriptionTag = "DESCRIPTION";
		String argTag = "argument";

		String actionName = "";
		String description = "";
		List<List<String>> arguments = new ArrayList<List<String>>();
		List<String> actionLines = new ArrayList<String>();

		/**
		 * Read each lines and parse to items of robot framework
		 */
		for (int i = 0; i < lines.size(); i++) {
			// Get action name
			if (lines.get(i).contains(nameTag)) {
				actionName = os.getMidText(lines.get(i), nameTag, "").get(0).trim();
			}
			// Get descriptions
			else if (lines.get(i).contains(descriptionTag)) {
				description = description + os.getMidText(lines.get(i), descriptionTag, "").get(0).trim();
			} else if (lines.get(i).startsWith("...")) {
				description = description + "\n\t...\t"
						+ os.getMidText(lines.get(i).trim(), "\\.\\.\\.", "").get(0).trim();
			}

			// Get arguments
			else if (lines.get(i).startsWith(argTag)) {
				String[] argObject = lines.get(i).split("\t");
				List<String> arg = new ArrayList<String>();
				for (String attr : argObject) {
					if (!attr.equalsIgnoreCase(argTag) && !attr.equals("") && attr != null) {
						arg.add(attr);
					}
				}
				arguments.add(arg);
			}

			// Get action body
			else {
				if (os.getSubString(lines.get(i), "#(.*?)name(.*?)default value(.*?)description").equals("")) {
					actionLines.add(lines.get(i));
				}
			}

		}

		/**
		 * Join each items to completed keyword of robot framework
		 */
		String rfKeyword = "";
		// Parse If block
		if (parseIfBlock(actionLines) != null) {
			actionLines = parseIfBlock(actionLines);
		} else {
			throw new ABTLibraryFatalException(String.format("Could not find 'end if' in '%s'.", filePath));
		}

		if (!actionLines.contains("*** Keywords ***") | !actionLines.contains("* Keywords *")
				| !actionLines.contains("* Keywords")) {
			rfKeyword += actionName + "\n";
			rfKeyword += "\t[Documentation]\n\t...\t" + description + "\n";
			rfKeyword += "\t[Arguments]\t";

			for (List<String> arg : arguments) {
				rfKeyword += "${" + arg.get(0) + "}";
				if (!arg.get(1).equals("n/a")) {
					rfKeyword += "=" + arg.get(1);
				}
				rfKeyword += "\t";
			}

			rfKeyword += "\n";

			for (String line : actionLines) {
				rfKeyword += "\t" + line + "\n";
			}
		} else {
			for (String line : actionLines) {
				if (!line.contains("*** Keywords") | !line.contains("* Keywords")) {
					rfKeyword += line + "\n";
				}
			}
		}
		return rfKeyword;

	}

	public List<String> parseIfBlock(List<String> originalBlock) {
		int startIf = -1;
		int endIf = -1;
		for (int i = 0; i < originalBlock.size(); i++) {
			if (originalBlock.get(i).toLowerCase().startsWith("if")) {
				startIf = i;
			}
			if (originalBlock.get(i).toLowerCase().startsWith("end if")) {
				endIf = i;
			}
		}
		if (startIf < endIf) {
			originalBlock.set(startIf, originalBlock.get(startIf).toLowerCase().replace("if", "run keyword if"));
			originalBlock.add(startIf + 1, "...\trun keywords");
			originalBlock.set(startIf + 2, "...\t" + originalBlock.get(startIf + 2));
			for (int i = startIf + 3; i < endIf + 1; i++) {
				originalBlock.set(i, "...\tand\t" + originalBlock.get(i));
			}
			originalBlock.remove(endIf + 1);
		}

		if (startIf > endIf) {
			return null;
		}
		return originalBlock;
	}
}
