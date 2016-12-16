import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import abtlibrary.keywords.appiumlibrary.ApplicationManagement;
import abtlibrary.keywords.appiumlibrary.KeyEvent;
import abtlibrary.keywords.appiumlibrary.MobileElement;
import abtlibrary.keywords.selenium2library.Element;

public class test {
	
	static ApplicationManagement applicationManagement = new ApplicationManagement();
	static MobileElement mobile = new MobileElement();
	static Element element = new Element();
	static KeyEvent key = new KeyEvent();
	
	
	public static void main(String[] args) throws InterruptedException, ScriptException{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
		engine.eval("from robot.libraries.BuiltIn import BuiltIn");
		engine.eval("BuiltIn().set_variable('${platform}','Test')");
		engine.eval("instance = BuiltIn().get_variable_value('${platform}')");
		System.out.println(engine.get("instance"));
	}
}
