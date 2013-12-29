package vistra.core.traversal;

import vistra.core.traversal.step.IStep;
import vistra.util.IBidirectIterator;

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
	abstract void setDescription(StringBuilder description);

	/**
	 * Returns the description.
	 * 
	 * @return the description
	 */
	abstract StringBuilder getStatistics();

}