package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;;

/**
 * An algorithm able to operate on a <code>Graph</code>.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IAlgorithm {

	/**
	 * Graph types.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public static enum GraphType {
		UNDIRECTED, DIRECTED,
	}

	/**
	 * Returns the algorithm name.
	 * 
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * Returns a description of this graph algorithm, e.g. what this algorithm
	 * is made for, its limits etc.
	 * 
	 * @return the description
	 */
	public abstract String getDescription();

	/**
	 * @param graph
	 * @throws Exception
	 */
	public abstract void execute(IRestrictedGraph graph) throws Exception;

	/**
	 * @return annotations
	 */
	public abstract GraphType[] getGraphTypes();

}
