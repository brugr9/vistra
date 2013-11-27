package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;

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
	public abstract IGravisGraph selectGraph(int index)
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
	 * @return String
	 * @throws Exception
	 */
	public abstract String goToBeginning() throws Exception;

	/**
	 * 
	 * @return String
	 * @throws Exception
	 */
	public abstract String goToEnd() throws Exception;

	/**
	 * 
	 * @return <code>true</code> if there is one more element in minimum to
	 *         reach in direction forward after this operation
	 * @throws Exception
	 */
	public abstract String goForward() throws Exception;

	/**
	 * 
	 * @return <code>true</code> if there is one more element in minimum to
	 *         reach in direction backward after this operation
	 * @throws Exception
	 */
	public abstract String goBackward() throws Exception;

	/**
	 * Removes all vertices and edges from the graph with the given id and
	 * returns the empty graph.
	 * 
	 * @param index
	 * @throws Exception
	 */
	public void clearGraph(int index) throws Exception;

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
	public abstract void executeTraverser(TraversalChangeListener listener) throws Exception;

	/**
	 * 
	 * @param graph
	 * @throws Exception
	 */
	public abstract void saveGraph(IGravisGraph graph) throws Exception;

	/**
	 * 
	 * @param graph
	 * @param file
	 * @throws Exception
	 */
	public abstract void exportGraph(IGravisGraph graph, File file) throws Exception;

	/**
	 * @param graph
	 */
	public abstract void selectGraph(IGravisGraph graph);

}
