package abtlibrary.keywords.frameworklibrary;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.Constant;
import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.operatinglibrary.OperatingSystem;
import abtlibrary.utils.Python;

@RobotKeywords
public class Action extends RunOnFailureKeywordsAdapter {

	public static void main(String[] args) {
		Action action = new Action();
		action.parseAction();
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
		if (fActions == null) {
			throw new ABTLibraryNonFatalException(
					String.format("Could not find action directory '%s'.", init.getActionDirectory() + "/" + folder));
		}
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
		List<String> codeLines = new ArrayList<String>();

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
					codeLines.add(lines.get(i));
				}
			}

		}

		/**
		 * Join each items to completed keyword of robot framework
		 */
		String rfKeyword = "";
		if (!codeLines.contains("*** Keywords ***")) {
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
			for (String line : codeLines) {
				rfKeyword += "\t" + line + "\n";
			}
		} else {
			for (String line : codeLines) {
				if (!line.contains("*** Keywords ***")) {
					rfKeyword += line + "\n";
				}
			}
		}
		return rfKeyword;

	}
}
