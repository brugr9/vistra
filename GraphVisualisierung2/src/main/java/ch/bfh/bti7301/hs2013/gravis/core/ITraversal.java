package ch.bfh.bti7301.hs2013.gravis.core;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.step.IStep;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ITraversal {

	/**
	 * Returns an immutable list of commands generated during the traversal.
	 * 
	 * @param graphItemStateChangeListener
	 * @return the list of commands
	 * @throws Exception
	 */
	public abstract IGravisListIterator<IStep> execute(
			TraversalChangeListener graphItemStateChangeListener) throws Exception;

	/**
	 * Sets the parameter algorithm.
	 * 
	 * @param gravisGraph
	 *            the traversal parameter to set
	 * @throws Exception
	 */
	public abstract void setParameter(IGravisGraph gravisGraph)
			throws Exception;

	/**
	 * Sets the parameter graph.
	 * 
	 * @param algorithm
	 *            the traversal parameter to set
	 * @throws Exception
	 */
	public abstract void setParameter(IAlgorithm algorithm) throws Exception;

	/**
	 * Returns the parameter graph.
	 * 
	 * @return the parameter graph
	 */
	public abstract IGravisGraph getGraph();

	/**
	 * Returns the parameter algorithm.
	 * 
	 * @return the parameter algorithm
	 */
	public abstract IAlgorithm getAlgorithm();

}
