package vistra.framework.algorithm;

import vistra.framework.graph.ITraversableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IAlgorithm {

	/**
	 * Returns the algorithm name.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Returns a description of this algorithm, e.g. what this algorithm is made
	 * for, its limits etc.
	 * 
	 * @return the description
	 */
	String getDescription();

	/**
	 * Returns the edge type(s) the algorithm is able to handle.
	 * 
	 * @return the edge type(s)
	 */
	EdgeType[] getEdgeTypes();

	/**
	 * Traverses a graph as given.
	 * 
	 * @param graph
	 *            the graph to traverse
	 * @throws AlgorithmException
	 */
	void traverse(ITraversableGraph graph) throws AlgorithmException;

}
