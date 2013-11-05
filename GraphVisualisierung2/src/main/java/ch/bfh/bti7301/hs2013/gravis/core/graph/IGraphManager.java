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
	 * @param graphId
	 * @return IGravisGraph
	 * @throws Exception
	 */
	public abstract IGravisGraph getGraph(String graphId) throws Exception;

	/**
	 * Imports a graph from a GraphML-file into the existing graph.
	 * 
	 * TODO format description GraphML: weight and color attributes, ...
	 * 
	 * @param file
	 *            the file to import
	 * @return the imported graph
	 * @throws Exception
	 */
	public abstract IGravisGraph importGraph(File file) throws Exception;

	/**
	 * 
	 * @param graphId
	 * @return IGravisGraph
	 * @throws Exception
	 */
	public abstract IGravisGraph clearGraph(String graphId) throws Exception;

	/**
	 * Removes the graph with the given id from the application and returns a
	 * new empty graph.
	 * 
	 * @param graphId
	 * @throws Exception
	 */
	public abstract void deleteGraph(String graphId) throws Exception;

	/**
	 * 
	 * @param graphId
	 * @param destinationDir
	 * @return boolean
	 * @throws Exception
	 */
	public abstract boolean exportGraph(String graphId, File destinationDir)
			throws Exception;

	/**
	 * 
	 * @param graph
	 * @return boolean
	 * @throws Exception
	 */
	public abstract boolean saveGraph(IGravisGraph graph) throws Exception;

	/**
	 * @param file
	 */
	public abstract void deleteGraph(File file) throws Exception;

}
