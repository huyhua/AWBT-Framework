package abtlibrary.utils;

import java.util.ArrayList;
import java.util.List;

import abtlibrary.keywords.operatinglibrary.OperatingSystem;

public class Action {

	public static void main(String[] args) {
		Action action = new Action();
		action.parseToRF("/Users/khoivo/git/ABTLibrary/src/test/robotframework/temp/action.robot");
	}

	public void parseToRF(String filePath) {
		OperatingSystem os = new OperatingSystem();
		List<String> lines = os.readFile(filePath);
		System.out.println(lines);

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
			if(lines.get(i).contains(nameTag)){
				actionName = os.getMidText(lines.get(i), nameTag, "").get(0).trim();
			}
			// Get descriptions
			else if(lines.get(i).contains(descriptionTag)){			
				description =  description +  os.getMidText(lines.get(i), descriptionTag, "").get(0).trim();
			} else if (lines.get(i).startsWith("...")){
				description = description + "\n\t...\t" + os.getMidText(lines.get(i).trim(), "\\.\\.\\.", "").get(0).trim();
			}
			
			// Get arguments
			else if (lines.get(i).startsWith(argTag)) {
				String[] argObject = lines.get(i).split("\t");
				List<String> arg = new ArrayList<String>();
				for(String attr : argObject){
					if(!attr.equalsIgnoreCase(argTag) && !attr.equals("") && attr != null){
						arg.add(attr);
					}
				}
				arguments.add(arg);
			}
			
			// Get action body
			else {
				if(os.getSubString(lines.get(i), "#(.*?)name(.*?)default value(.*?)description").equals("")){
					codeLines.add(lines.get(i));
				}
			}
			
		}
		
		/**
		 * Join each items to completed keyword of robot framework
		 */
		String rfKeyword = "***	Keywords	***";
		rfKeyword += rfKeyword + "\n";
		rfKeyword += actionName + "\n";
		rfKeyword += "\t[Documentation]\n\t...\t" + description + "\n";
		rfKeyword += "\t[Arguments]\t";
		
		for(List<String> arg: arguments){
			rfKeyword += "${" + arg.get(0) + "}";
			if(!arg.get(1).equals("n/a")){
				rfKeyword += "=" + arg.get(1);
			}
			rfKeyword += "\t";
		}
		
		rfKeyword += "\n";
		for(String line: codeLines){
			rfKeyword += "\t" + line + "\n";
		}
		
		System.out.println(rfKeyword);
		
	}
}
