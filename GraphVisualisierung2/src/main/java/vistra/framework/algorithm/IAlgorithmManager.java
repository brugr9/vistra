package vistra.framework.algorithm;

import vistra.framework.ParameterException;
import vistra.framework.graph.ILayoutGraph;
import vistra.framework.traversal.ITraversal;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm manager interface.
 * <p>
 * An algorithm manager holds two lists:
 * <ul>
 * <li>a list with all algorithms available
 * <li>a list with selectable algorithms supporting an edge type (as a selection
 * out of the algorithms available)
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IAlgorithmManager {

	/**
	 * Adds an algorithm to the list of available algorithms.
	 * 
	 * @param algorithm
	 *            the algorithm to add
	 * @throws Exception
	 */
	boolean addAvailable(IAlgorithm algorithm) throws Exception;

	/**
	 * Removes an algorithm from the list of available algorithms. The list of
	 * supported algorithms will be updated.
	 * 
	 * @param algorithm
	 *            the algorithm to remove
	 * @return the removed algorithm
	 * @throws Exception
	 */
	boolean removeAvailable(IAlgorithm algorithm) throws Exception;

	/**
	 * Updates the list of supported algorithms. Afterwards, the list holds all
	 * and only the algorithms capable to traverse edges as given by type.
	 * 
	 * @param edgeType
	 *            the edge type
	 * @throws Exception
	 */
	void updateSupported(EdgeType edgeType) throws Exception;

	/**
	 * Returns an array of algorithm names representing the list of supported
	 * algorithms.
	 * 
	 * @return the algorithm names
	 * @throws Exception
	 */
	String[] getNames() throws Exception;

	/**
	 * Returns an algorithm out of the list of supported algorithm chosen by
	 * index. The index TODO 'nimmt Bezug auf' to the list of names as given by
	 * the method {@code getNames()}.
	 * 
	 * @param index
	 *            the algorithm index
	 * @return the algorithm
	 * @throws Exception
	 */
	IAlgorithm getSupported(int index) throws Exception;

	/**
	 * Selects an algorithm.
	 * 
	 * @param index
	 *            the algorithm index
	 * @throws ParameterException
	 */
	void select(int index) throws ParameterException;

	/**
	 * Returns the description of the selected algorithm.
	 * 
	 * @return the description
	 */
	String getDescription();

	/**
	 * Traverses a graph as given by executing the algorithm. Returns a
	 * traversal as immutable list of {@code IStep}s generated during the
	 * execution of the algorithm.
	 * 
	 * @param g
	 *            the graph to traverse
	 * @return the traversal
	 * @throws ParameterException
	 */
	ITraversal execute(ILayoutGraph graph) throws ParameterException;

}