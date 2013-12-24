package vistra.core.traversal.step;

import vistra.util.ICommand;

/**
 * A step interface.
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
	abstract String getDescription();

}