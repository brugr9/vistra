package vistra.core.algorithm;

import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm manager.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IAlgorithmManager {

	/**
	 * Returns a list of names with algorithms capable to operate on graphs with
	 * the edge type as given.
	 * 
	 * @param edgeType
	 *            the graph type
	 * @return the algorithm names
	 * @throws Exception
	 */
	public abstract String[] getNames(EdgeType edgeType) throws Exception;

	/**
	 * Selects an algorithm by index, loads and returns the algorithm.
	 * 
	 * @param index
	 *            the algorithm index
	 * @return the algorithm
	 * @throws Exception
	 */
	public abstract IAlgorithm select(int index) throws Exception;

}