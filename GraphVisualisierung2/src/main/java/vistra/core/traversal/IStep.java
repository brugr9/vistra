package vistra.core.traversal;

/**
 * A step interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IStep {

	/**
	 * Executes the step and returns a step description.
	 * 
	 * @return a description
	 * @throws Exception
	 */
	abstract String execute() throws Exception;

	/**
	 * Undoes the step.
	 * 
	 * @throws Exception
	 */
	abstract void undo() throws Exception;

}
