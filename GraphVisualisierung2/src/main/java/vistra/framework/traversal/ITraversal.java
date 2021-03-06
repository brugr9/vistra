package vistra.framework.traversal;

import java.util.ListIterator;

import vistra.framework.traversal.step.IStep;
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
	 * Sets the solution.
	 * 
	 * @param solution
	 */
	void setSolution(String solution);

	/**
	 * Returns the solution.
	 * 
	 * @return the solution
	 */
	String getSolution();

}