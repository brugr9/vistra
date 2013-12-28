package vistra.core.traversal.step;

import vistra.core.traversal.Traversal;
import vistra.util.ICommand;

/**
 * A step interface. A step is an extended command and part of a traversal.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see Traversal
 */
public interface IStep extends ICommand {

	/**
	 * Returns the description.
	 * 
	 * @return the description
	 */
	abstract String getDescription();

}
