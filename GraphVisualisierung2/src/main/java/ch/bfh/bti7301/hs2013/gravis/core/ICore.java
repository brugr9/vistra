package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;

import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import edu.uci.ics.jung.graph.Graph;

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
	 * Selects a graph as parameter for the traversal, invokes the rebuild of
	 * the list with available algorithms and returns the loaded graph.
	 * 
	 * @param index
	 *            the graph index
	 * @return the graph
	 * @throws Exception
	 */
	public abstract Graph<IVertex, IEdge> selectGraph(int index)
			throws Exception;

	/**
	 * Imports a graph given as file.
	 * 
	 * @param source
	 *            the graph file to import
	 * @return the names of available graphs
	 * @throws Exception
	 */
	public abstract String[] importGraph(File source) throws Exception;

	/**
	 * Deletes an imported graph file.
	 * 
	 * @param file
	 *            the graph file to delete
	 * @return the names of available graphs
	 * @throws Exception
	 */
	public abstract String[] deleteGraph(File file) throws Exception;

	/**
	 * Saves the current graph.
	 * 
	 * @return boolean
	 * @throws Exception
	 */
	public abstract boolean saveGraph() throws Exception;

	/**
	 * 
	 * @param source
	 * @param destinationDirectory
	 * @return <code>true<code> if success
	 * @throws Exception
	 */
	public abstract boolean exportGraph(File source, File destinationDirectory)
			throws Exception;

	/**
	 * Returns the names of available graphs.
	 * 
	 * @return the names of available graphs
	 * @throws Exception
	 */
	public abstract String[] getGraphs() throws Exception;

	/**
	 * Selects an algorithm as parameter for the traversal.
	 * 
	 * @param index
	 *            the algorithm index
	 * @throws Exception
	 */
	public abstract void selectAlgorithm(int index) throws Exception;

	/**
	 * Imports an algorithm given as file.
	 * 
	 * @param source
	 *            the algorithm file to import
	 * @return the names of available algorithms
	 * @throws Exception
	 */
	public abstract String[] importAlgorithm(File source) throws Exception;

	/**
	 * Deletes an imported algorithm file.
	 * 
	 * @param file
	 *            the algorithm file to delete
	 * @return the names of available algorithms
	 * @throws Exception
	 */
	public abstract String[] deleteAlgorithm(File file) throws Exception;

	/**
	 * Returns the names of available algorithms.
	 * 
	 * @return the names of available algorithms
	 * @throws Exception
	 */
	public abstract String[] getAlgorithms() throws Exception;

	/**
	 * Returns the number of steps the traversal has.
	 * 
	 * @return the number of steps
	 */
	public abstract int getGraphIteratorSize();

	/**
	 * 
	 * @throws Exception
	 */
	public abstract void goToBeginning() throws Exception;

	/**
	 * 
	 * @throws Exception
	 */
	public abstract void goToEnd() throws Exception;

	/**
	 * 
	 * @return <code>true</code> if there is one more element in minimum to
	 *         reach in direction forward after this operation
	 * @throws Exception
	 */
	public abstract boolean goForward() throws Exception;

	/**
	 * 
	 * @return <code>true</code> if there is one more element in minimum to
	 *         reach in direction backward after this operation
	 * @throws Exception
	 */
	public abstract boolean goBackward() throws Exception;

	/**
	 * Removes all vertices and edges from the graph with the given id and
	 * returns the empty graph.
	 * 
	 * @param index
	 * @return Graph<IVertex, IEdge>
	 * @throws Exception
	 */
	public Graph<IVertex, IEdge> clearGraph(int index) throws Exception;

	/**
	 * Returns the graph templates directory.
	 * 
	 * @return the graph templates directory
	 */
	public abstract File getGraphTemplatesDir();

	/**
	 * Returns the graph workbench directory.
	 * 
	 * @return the graph workbench directory
	 */
	public abstract File getGraphWorkbenchDir();

	/**
	 * Returns the graph filename filter.
	 * 
	 * @return the graph filename extension filter
	 */
	public abstract FileNameExtensionFilter getGraphFilter();

	/**
	 * Returns the algorithm templates directory.
	 * 
	 * @return the algorithm templates directory
	 */
	public abstract File getAlgorithmTemplatesDir();

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
	 * 
	 * @param listener
	 * @throws Exception
	 */
	void executeTraverser(ChangeListener listener) throws Exception;

}
