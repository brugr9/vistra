package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.io.File;

import ch.bfh.bti7301.hs2013.gravis.core.IParameterManager;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGraphManager extends IParameterManager {

	/**
	 * 
	 * @param index
	 *            the graph index
	 * @return IGravisGraph
	 * @throws Exception
	 */
	public abstract IGravisGraph getGraph(int index) throws Exception;

	/**
	 * Imports a graph from a GraphML-file into the system.
	 * 
	 * @param file
	 *            the file to import
	 * @return the names of available graphs
	 * @throws Exception
	 */
	public abstract String[] importGraph(File file) throws Exception;

	/**
	 * Removes the graph with the given id from the application and returns a
	 * new empty graph.
	 * 
	 * @param index
	 * @return IGravisGraph
	 * @throws Exception
	 */
	public abstract IGravisGraph clearGraph(int index) throws Exception;

	/**
	 * 
	 * @param index
	 * @param destinationDir
	 * @throws Exception
	 */
	public abstract void exportGraph(int index, File destinationDir)
			throws Exception;

	/**
	 * 
	 * @param graph
	 * @return boolean
	 * @throws Exception
	 */
	public abstract boolean saveGraph(IGravisGraph graph) throws Exception;

	/**
	 * 
	 * @param file
	 * @return the names of available graphs
	 * @throws Exception
	 */
	public abstract String[] deleteGraph(File file) throws Exception;

}
