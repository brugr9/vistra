package vistra.core.traversal;

import vistra.util.ICommandHandler;

/**
 * A step interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IStep extends ICommandHandler {

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
	 * @return a description
	 * @throws Exception
	 */
	abstract String undo() throws Exception;

}
