package vistra.core;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.core.algorithm.IAlgorithm;
import vistra.core.graph.IExtendedGraph;
import vistra.core.traversal.Traversal;
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
	abstract FileNameExtensionFilter getGraphFilter();

	/**
	 * Returns an empty graph of edge type as given.
	 * 
	 * @return the graph
	 * @throws CoreException
	 */
	abstract IExtendedGraph getNewGraph() throws CoreException;

	/**
	 * Opens a graph given as file.
	 * 
	 * @param source
	 *            the graph file to import
	 * @return the graph
	 * @throws CoreException
	 */
	abstract IExtendedGraph openGraph(File source) throws CoreException;

	/**
	 * Saves a graph as GraphML-file with the name as given.
	 * 
	 * @param graph
	 *            the graph to save
	 * @throws CoreException
	 */
	abstract void save(IExtendedGraph graph) throws CoreException;

	/**
	 * Saves a graph into a GraphML-file.
	 * 
	 * @param graph
	 *            the graph to save
	 * @param file
	 *            the file to write into
	 * @throws CoreException
	 */
	abstract void saveAs(IExtendedGraph graph, File file) throws CoreException;

	/**
	 * Returns an array of available algorithms as names.
	 * <p>
	 * The list is filtered: it contains only the names of algorithms able to
	 * traverse the edge type as given.
	 * 
	 * @param edgeType
	 *            the edge type
	 * @return the array of available algorithms
	 * @throws CoreException
	 */
	abstract String[] getAlgorithms(EdgeType edgeType) throws CoreException;

	/**
	 * Selects an algorithm.
	 * 
	 * @param index
	 *            the algorithm index
	 * @return the algorithm
	 * @throws CoreException
	 */
	abstract IAlgorithm selectAlgorithm(int index) throws CoreException;

	/**
	 * Sets an algorithm.
	 * 
	 * @param algorithm
	 *            the algorithm to set
	 */
	abstract void setAlgorithm(IAlgorithm algorithm) throws CoreException;

	/**
	 * Traverses a graph as given by executing the algorithm. Returns traversal
	 * as immutable list of steps generated during the execution of the
	 * algorithm. A step contains several commands which modifies the graph.
	 * 
	 * @param graph
	 *            the graph to traverse
	 * @return the traversal
	 * @throws CoreException
	 */
	public Traversal traverse(IExtendedGraph graph) throws CoreException;

}
