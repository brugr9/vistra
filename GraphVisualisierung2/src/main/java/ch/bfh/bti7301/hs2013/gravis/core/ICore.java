package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IObservableGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.traversal.Traversal;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * This interface gives access to all important core classes. It is a facade to
 * different other classes and interfaces (facade pattern).
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ICore {

	/**
	 * Returns the graph filename filter.
	 * 
	 * @return the graph filename extension filter
	 */
	public abstract FileNameExtensionFilter getGraphFilter();

	/**
	 * Returns an empty graph of edge type as given.
	 * 
	 * @return the graph
	 * @throws CoreException
	 */
	public abstract IObservableGravisGraph getNewGraph() throws CoreException;

	/**
	 * Opens a graph given as file.
	 * 
	 * @param source
	 *            the graph file to import
	 * @return the graph
	 * @throws CoreException
	 */
	public abstract IObservableGravisGraph openGraph(File source)
			throws CoreException;

	/**
	 * Saves a graph as GraphML-file with the name as given.
	 * 
	 * @param graph
	 *            the graph to save
	 * @throws CoreException
	 */
	public abstract void save(IGravisGraph graph) throws CoreException;

	/**
	 * Saves a graph into a GraphML-file.
	 * 
	 * @param graph
	 *            the graph to save
	 * @param file
	 *            the file to write into
	 * @throws CoreException
	 */
	public abstract void saveAs(IGravisGraph graph, File file)
			throws CoreException;

	/**
	 * Returns the algorithm workbench directory.
	 * 
	 * @return the algorithm workbench directory
	 */
	public abstract File getAlgorithmWorkbenchDir();

	/**
	 * Returns the algorithm filename extension filter.
	 * 
	 * @return the algorithm filename extension filter
	 */
	public abstract FileNameExtensionFilter getAlgorithmFilter();

	/**
	 * Imports an algorithm given as file and returns the edge types the
	 * algorithm can handle.
	 * 
	 * @param source
	 *            the algorithm file to import
	 * @return the edge types
	 * @throws CoreException
	 */
	public abstract EdgeType[] importAlgorithm(File source)
			throws CoreException;

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
	public abstract String[] getAlgorithms(EdgeType edgeType)
			throws CoreException;

	/**
	 * Selects and returns an algorithm.
	 * 
	 * @param index
	 *            the algorithm index
	 * @return the algorithm
	 * @throws CoreException
	 */
	public abstract IAlgorithm selectAlgorithm(int index) throws CoreException;

	/**
	 * Deletes an imported algorithm file and returns the edge types the
	 * algorithm was able to handle.
	 * 
	 * @param file
	 *            the algorithm file to delete
	 * @return the edge types if success (<code>null</code> else)
	 * @throws CoreException
	 */
	public abstract EdgeType[] deleteAlgorithm(File file) throws CoreException;

	/**
	 * Renders a traversal by executing an algorithm as given over a graph as
	 * given. Returns an immutable list of steps generated during the execution
	 * of the algorithm. A step contains several commands which modifies the
	 * graph.
	 * 
	 * @param graph
	 *            the graph to traverse
	 * @param algorithm
	 *            the algorithm to execute
	 * @return the traversal
	 * @throws CoreException
	 */
	public Traversal renderTraversal(IGravisGraph graph, IAlgorithm algorithm)
			throws CoreException;

}
