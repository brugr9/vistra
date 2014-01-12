package vistra.framework.step;

import vistra.framework.util.ICommand;

/**
 * A step interface. A step is an extended {@code ICommand} and part of a
 * traversal.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IStep extends ICommand {

	/**
	 * Returns the description.
	 * 
	 * @return the description
	 */
	String getDescription();

}
