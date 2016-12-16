package abtlibrary.keywords.appiumlibrary;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.RunOnFailureKeywordsAdapter;

@RobotKeywords
public class Test extends RunOnFailureKeywordsAdapter {

	@RobotKeyword
	public String myaction () throws ScriptException{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
			engine.eval("from robot.libraries.BuiltIn import BuiltIn");
			engine.eval("BuiltIn().log_to_console('Test Message')");
			//engine.eval("var = BuiltIn().get_library_instance('ABTLibrary')");
			engine.eval("BuiltIn().set_variable('${var}','My name')");
			//engine.eval("BuiltIn().log_to_console(var)");
			return engine.get("var").toString();
	}
}
