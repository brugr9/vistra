package vistra.framework.traversal;

import vistra.framework.traversal.step.IStep;
import vistra.framework.util.IBidirectIterator;

/**
 * An interface for a traversal as an immutable, bidirectional iterator over
 * steps.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ITraversal extends IBidirectIterator<IStep> {

	/**
	 * Sets the a description.
	 * 
	 * @param description
	 *            the description
	 */
	void setDescription(StringBuilder description);

	/**
	 * Returns the description.
	 * 
	 * @return the description
	 */
	StringBuilder getDescription();

}