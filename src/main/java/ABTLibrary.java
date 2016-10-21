import org.robotframework.remoteserver.RemoteServer;

public class ABTLibrary extends abtlibrary.ABTLibrary {

	public ABTLibrary(String timeout, String implicitWait, String runOnFailure) {
		super(timeout, implicitWait, runOnFailure);
	}

	public ABTLibrary(String timeout, String implicitWait) {
		super(timeout, implicitWait);
	}

	public ABTLibrary(String timeout) {
		super(timeout);
	}

	public ABTLibrary() {
		super();
	}

	public static void main(String[] args) throws Exception {
		RemoteServer.configureLogging();
		RemoteServer server = new RemoteServer();
		server.putLibrary("/RPC2",new ABTLibrary());
		server.setPort(8270);
		server.start();
	}
}
