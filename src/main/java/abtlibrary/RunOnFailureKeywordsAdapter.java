package abtlibrary;

import org.robotframework.javalib.annotation.Autowired;

import abtlibrary.keywords.selenium2library.RunOnFailure;

public abstract class RunOnFailureKeywordsAdapter implements RunOnFailureKeywords {

	@Autowired
	private RunOnFailure runOnFailure;

	/**
	 * This method is called by the
	 * abtlibrary.aspects.RunOnFailureAspect in
	 * case a exception is thrown in one of the public methods of a keyword
	 * class.
	 */
	@Override
	public void runOnFailureByAspectJ() {
		runOnFailure.runOnFailure();
	}

}
