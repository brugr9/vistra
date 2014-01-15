package vistra.framework;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.framework.graph.ILayoutGraph;
import vistra.framework.traversal.ITraversal;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A parameter manager interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IParameterManager {

	/**
	 * Returns the graph filename filter.
	 * 
	 * @return the graph filename extension filter
	 */
	FileNameExtensionFilter getGraphFilter();

	/**
	 * Returns an empty graph of edge type as given.
	 * 
	 * @param edgeType
	 *            the edge type
	 * @return the graph
	 * @throws ParameterException
	 */
	ILayoutGraph newGraph(EdgeType edgeType) throws ParameterException;

	/**
	 * Opens a graph given as file.
	 * 
	 * @param source
	 *            the graph file to import
	 * @return the graph
	 * @throws ParameterException
	 */
	ILayoutGraph openGraph(File source) throws ParameterException;

	/**
	 * Saves the graph as GraphML-file.
	 * 
	 * @throws ParameterException
	 */
	void saveGraph() throws ParameterException;

	/**
	 * Saves the graph into a GraphML-file with name as given.
	 * 
	 * @param file
	 *            the file to write into
	 * @throws ParameterException
	 */
	void saveGraphAs(File file) throws ParameterException;

	/**
	 * Updates the list of selectable algorithms. Afterwards, the list holds all
	 * and only the algorithms capable to traverse edges as given by type.
	 * 
	 * @param edgeType
	 *            the edge type
	 * @throws ParameterException
	 */
	void updateSelectableAlgorithms(EdgeType edgeType)
			throws ParameterException;

	/**
	 * Returns an array of human readable names of selectable algorithms.
	 * 
	 * @return the algorithm names
	 * @throws ParameterException
	 */
	String[] getSelectableAlgorithmNames() throws ParameterException;

	/**
	 * Selects an algorithm.
	 * 
	 * @param index
	 *            the algorithm index
	 * @throws ParameterException
	 */
	void selectAlgorithm(int index) throws ParameterException;

	/**
	 * Returns the algorithm description.
	 * 
	 * @return the description
	 */
	String getAlgorithmDescription() throws ParameterException;

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
	ITraversal executeAlgorithm(ILayoutGraph g) throws ParameterException;

}
