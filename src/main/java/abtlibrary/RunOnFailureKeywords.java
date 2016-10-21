package abtlibrary;

public interface RunOnFailureKeywords {

	/**
	 * This method is called by the
	 * abtlibrary.aspects.RunOnFailureAspect in
	 * case a exception is thrown in one of the public methods of a keyword
	 * class.
	 */
	void runOnFailureByAspectJ();

}
