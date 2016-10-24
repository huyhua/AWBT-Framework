package abtlibrary;

/**
 * A raised exception of this type marks the step as failed, but does not end
 * all test executions.
 */
@SuppressWarnings("serial")
public class ABTLibraryNonFatalException extends RuntimeException {

	/**
	 * Mark this exception as non fatal
	 */
	public static final boolean ROBOT_EXIT_ON_FAILURE = false;

	public ABTLibraryNonFatalException() {
		super();
	}

	public ABTLibraryNonFatalException(String string) {
		super(string);
	}

	public ABTLibraryNonFatalException(Throwable t) {
		super(t);
	}

	public ABTLibraryNonFatalException(String string, Throwable t) {
		super(string, t);
	}
}
