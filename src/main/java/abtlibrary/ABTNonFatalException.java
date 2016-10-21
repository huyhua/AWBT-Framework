package abtlibrary;

/**
 * A raised exception of this type marks the step as failed, but does not end
 * all test executions.
 */
@SuppressWarnings("serial")
public class ABTNonFatalException extends RuntimeException {

	/**
	 * Mark this exception as non fatal
	 */
	public static final boolean ROBOT_EXIT_ON_FAILURE = false;

	public ABTNonFatalException() {
		super();
	}

	public ABTNonFatalException(String string) {
		super(string);
	}

	public ABTNonFatalException(Throwable t) {
		super(t);
	}

	public ABTNonFatalException(String string, Throwable t) {
		super(string, t);
	}
}
