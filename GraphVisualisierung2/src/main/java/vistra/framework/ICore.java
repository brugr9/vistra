package vistra.framework;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.framework.graph.IExtendedGraph;
import vistra.framework.traversal.ITraversal;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A core interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ICore {

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
	 * @throws CoreException
	 */
	IExtendedGraph newGraph(EdgeType edgeType) throws CoreException;

	/**
	 * Opens a graph given as file.
	 * 
	 * @param source
	 *            the graph file to import
	 * @return the graph
	 * @throws CoreException
	 */
	IExtendedGraph openGraph(File source) throws CoreException;

	/**
	 * Saves the graph as GraphML-file.
	 * 
	 * @throws CoreException
	 */
	void saveGraph() throws CoreException;

	/**
	 * Saves the graph into a GraphML-file with name as given.
	 * 
	 * @param file
	 *            the file to write into
	 * @throws CoreException
	 */
	void saveGraphAs(File file) throws CoreException;

	/**
	 * Updates the list of selectable algorithms. Afterwards, the list holds all
	 * and only the algorithms capable to traverse edges as given by type.
	 * 
	 * @param edgeType
	 *            the edge type
	 * @throws CoreException
	 */
	void updateSelectableNames(EdgeType edgeType) throws CoreException;

	/**
	 * Returns an array of human readable names of selectable algorithms.
	 * 
	 * @return the algorithm names
	 * @throws CoreException
	 */
	String[] getSelectableNames() throws CoreException;

	/**
	 * Selects an algorithm.
	 * 
	 * @param index
	 *            the algorithm index
	 * @throws CoreException
	 */
	void selectAlgorithm(int index) throws CoreException;

	/**
	 * Returns the algorithm description.
	 * 
	 * @return the description
	 */
	String getAlgorithmDescription() throws CoreException;

	/**
	 * Traverses a graph as given by executing the algorithm. Returns traversal
	 * as immutable list of steps generated during the execution of the
	 * algorithm. A step contains several commands which modifies the graph.
	 * 
	 * @param g
	 *            the graph to traverse
	 * @return the traversal
	 * @throws CoreException
	 */
	ITraversal traverse(IExtendedGraph g) throws CoreException;

}
