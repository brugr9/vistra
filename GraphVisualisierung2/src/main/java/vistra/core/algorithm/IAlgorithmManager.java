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
	 * Adds an algorithm.
	 * 
	 * @param algorithm
	 *            the algorithm to add
	 * @throws Exception
	 */
	abstract boolean add(IAlgorithm algorithm) throws Exception;

	/**
	 * Removes an algorithm.
	 * 
	 * @param algorithm
	 *            the algorithm to remove
	 * @return the removed algorithm
	 * @throws Exception
	 */
	abstract boolean remove(IAlgorithm algorithm) throws Exception;

	/**
	 * Updates the list of selectable algorithms. Afterwards, the list holds all
	 * and only the algorithms capable to traverse edges as given by type.
	 * 
	 * @param edgeType
	 *            the edge type
	 * @throws Exception
	 */
	abstract void updateSelectableList(EdgeType edgeType) throws Exception;

	/**
	 * Returns an array of human readable names of selectable algorithms.
	 * 
	 * @return the algorithm names
	 * @throws Exception
	 */
	abstract String[] getSelectableNames() throws Exception;

	/**
	 * Selects an algorithm by index, loads and returns the algorithm.
	 * 
	 * @param index
	 *            the algorithm index
	 * @return the algorithm
	 * @throws Exception
	 */
	abstract IAlgorithm select(int index) throws Exception;

}