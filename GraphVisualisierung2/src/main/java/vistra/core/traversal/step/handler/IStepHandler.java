package vistra.core.traversal.step.handler;

import vistra.core.traversal.step.IStep;
import vistra.util.ICommandHandler;

/**
 * A step handler interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IStepHandler extends IStep, ICommandHandler {

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the description to set
	 */
	abstract void setDescription(String description);

}
