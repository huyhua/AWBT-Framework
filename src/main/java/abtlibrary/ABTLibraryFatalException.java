package abtlibrary;

/**
 * A raised exception of this type ends all test executions.
 */
@SuppressWarnings("serial")
public class ABTLibraryFatalException extends RuntimeException {

	/**
	 * Mark this exception as fatal
	 */
	public static final boolean ROBOT_EXIT_ON_FAILURE = true;

	public ABTLibraryFatalException() {
		super();
	}

	public ABTLibraryFatalException(String string) {
		super(string);
	}

	public ABTLibraryFatalException(Throwable t) {
		super(t);
	}

	public ABTLibraryFatalException(String string, Throwable t) {
		super(string, t);
	}
}
