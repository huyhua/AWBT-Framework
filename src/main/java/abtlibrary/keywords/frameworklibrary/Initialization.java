package abtlibrary.keywords.frameworklibrary;

import java.io.File;

import javax.script.ScriptException;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.RunOnFailureKeywordsAdapter;

@RobotKeywords
public class Initialization extends RunOnFailureKeywordsAdapter {
	@Autowired
	protected Action action;
	public static void main(String[] args) {
		Initialization initialization = new Initialization();
		initialization.setProjectDirectory("/Users/huyhua/HuyHua/IS24App");
		System.out.println(initialization.getProjectDirectory());
		System.out.println(initialization.getActionDirectory());
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
		if(projectDir.equals("")){
			try {
				projectDir = action.getVariable("EXECDIR");
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projectDir;
	}

	public String getActionDirectory() {
		if(projectDir.equals("")){
			try {
				projectDir = action.getVariable("EXECDIR");
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projectDir + "/" + actionDir;
	}

	public String getInterfaceDirectory() {
		if(projectDir.equals("")){
			try {
				projectDir = action.getVariable("EXECDIR");
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projectDir + "/" + interfaceDir;
	}

	public String getDatasetDirectory() {
		if(projectDir.equals("")){
			try {
				projectDir = action.getVariable("EXECDIR");
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projectDir + "/" + datasetDir;
	}

	public String getConfigurationDirectory() {
		if(projectDir.equals("")){
			try {
				projectDir = action.getVariable("EXECDIR");
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projectDir + "/" + configurationDir;
	}
	
	public String getTempDir(){
		if(projectDir.equals("")){
			try {
				projectDir = action.getVariable("EXECDIR");
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projectDir + "/Temp/";
	}
	
	public String getTempActionDir(){
		if(projectDir.equals("")){
			try {
				projectDir = action.getVariable("EXECDIR");
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projectDir + "/Temp/" + actionDir;
	}
	
	public String getTempInterfaceDir(){
		if(projectDir.equals("")){
			try {
				projectDir = action.getVariable("EXECDIR");
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projectDir + "/Temp/" + interfaceDir;
	}
}
