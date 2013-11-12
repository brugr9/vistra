package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;

import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;

/**
 * 
 * This interface gives access to all important core classes. It is a facade to
 * different other classes and interfaces (facade pattern).
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ICore {

	/**
	 * Selects a graph as parameter for the traversal. Invokes the rebuild of
	 * list with possible algorithms too.
	 * 
	 * @param graphId
	 * @return Graph<IVertex, IEdge>
	 * @throws Exception
	 */
	public abstract Graph<IVertex, IEdge> selectGraph(String graphId)
			throws Exception;

	/**
	 * Imports a graph given as file.
	 * 
	 * @param file
	 *            the graph file
	 * @return the imported graph
	 * @throws Exception
	 */
	public abstract Graph<IVertex, IEdge> importGraph(File file)
			throws Exception;

	// /**
	// *
	// * @param graphId
	// * @throws Exception
	// * @deprecated
	// */
	// public abstract void deleteGraph(String graphId) throws Exception;

	/**
	 * Deletes an imported graph file.
	 * 
	 * @param file
	 *            the graph file to delete
	 * @throws Exception
	 */
	public abstract void deleteGraph(File file) throws Exception;

	// TODO Methode nicht notwendig?

	/**
	 * Saves the current graph.
	 * 
	 * @return boolean
	 * @throws Exception
	 */
	public abstract boolean saveGraph() throws Exception;

	/**
	 * 
	 * @param graphId
	 * @param directory
	 * @return Graph<IVertex, IEdge>
	 * @throws Exception
	 */
	public abstract Graph<IVertex, IEdge> exportGraph(String graphId,
			File directory) throws Exception;

	/**
	 * 
	 * @param graphId
	 * @return String
	 */
	public abstract String getGraphName(String graphId) throws Exception;

	/**
	 * @return String[]
	 * @throws Exception
	 */
	public abstract String[] getGraphNames() throws Exception;

	/**
	 * Selects an algorithm as parameter for the traversal.
	 * 
	 * @param algorithmId
	 * @throws Exception
	 */
	public abstract void selectAlgorithm(String algorithmId) throws Exception;

	/**
	 * Imports an algorithm file.
	 * 
	 * @param file
	 *            the algorithm file
	 * @return the algorithmId
	 * @throws Exception
	 */
	public abstract int importAlgorithm(File file) throws Exception;

	// /**
	// * Deletes an imported algorithm.
	// *
	// * @param algorithmId
	// * @throws Exception
	// * @deprecated
	// */
	// public abstract void deleteAlgorithm(String algorithmId) throws
	// Exception;

	/**
	 * Deletes an imported algorithm file.
	 * 
	 * @param file
	 *            the algorithm file to delete
	 * @throws Exception
	 */
	// TODO return boolean -> warum?
	public abstract void deleteAlgorithm(File file) throws Exception;

	// TODO Methode nicht notwendig?

	/**
	 * @return String
	 */
	public abstract String getAlgorithmName(String algorithmId)
			throws Exception;

	/**
	 * @return String[]
	 * @throws Exception
	 */
	public abstract String[] getAlgorithmNames() throws Exception;

	/**
	 * 
	 * @param listener
	 * @throws Exception
	 */
	public abstract void executeTraverser(ChangeListener listener)
			throws Exception;

	/**
	 * @return int
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
	 * @param graphId
	 * @return Graph<IVertex, IEdge>
	 * @throws Exception
	 */
	public Graph<IVertex, IEdge> clearGraph(String graphId) throws Exception;

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
}
