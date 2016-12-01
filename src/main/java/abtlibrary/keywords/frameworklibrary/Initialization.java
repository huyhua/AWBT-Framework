package abtlibrary.keywords.frameworklibrary;

import java.io.File;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.Constant;
import abtlibrary.RunOnFailureKeywordsAdapter;

@RobotKeywords
public class Initialization extends RunOnFailureKeywordsAdapter {
	public static void main(String[] args) {
		Initialization initialization = new Initialization();
		initialization.setProjectDirectory("/Users/mac/git/anisapp");
		System.out.println(Constant.projectDir);
	}

	private String projectDir = "";
	private String actionDir = "Action";
	private String interfaceDir = "Interface";
	private String datasetDir = "Dataset";
	private String configurationDir = "Configuration";

	// ##############################
	// Keywords
	// ##############################
	/**
	 * Declare project directory for built-in library.<br>
	 * `Set Project Directory` action should be called at first.
	 * 
	 * @param projectDir
	 *            Full path of project.
	 */
	@RobotKeyword
	@ArgumentNames({ "projectDir" })
	public void setProjectDirectory(String projectDir) {
		File dir = new File(projectDir);
		if (!dir.exists()) {
			throw new ABTLibraryNonFatalException(String.format("Project directory '%s' does not exist.", projectDir));
		}
		this.projectDir = projectDir;
	}

	public String getProjectDirectory() {
		return projectDir;
	}

	public String getActionDirectory() {
		return projectDir + "/" + actionDir;
	}

	public String getInterfaceDirectory() {
		return projectDir + "/" + interfaceDir;
	}

	public String getDatasetDirectory() {
		return projectDir + "/" + datasetDir;
	}

	public String getConfgiurationDirectory() {
		return projectDir + "/" + configurationDir;
	}
}
