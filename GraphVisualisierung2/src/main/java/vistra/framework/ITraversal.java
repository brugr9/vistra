package vistra.framework;

import java.util.ListIterator;

import vistra.framework.step.IStep;
import vistra.framework.util.IBidirectIterator;

/**
 * An interface for a traversal as an immutable, bidirectional iterator over
 * steps. A step contains one or more commands each of them modifying the graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ListIterator
 */
public interface ITraversal extends IBidirectIterator<IStep> {

	/**
	 * Sets the a description.
	 * 
	 * @param description
	 *            the description
	 */
	void setDescription(String description);

	/**
	 * Returns the description.
	 * 
	 * @return the description
	 */
	String getDescription();

}