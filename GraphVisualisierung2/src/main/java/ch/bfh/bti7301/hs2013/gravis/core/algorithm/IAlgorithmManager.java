package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.io.File;

import ch.bfh.bti7301.hs2013.gravis.core.IParameterManager;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm.GraphType;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IAlgorithmManager extends IParameterManager {

	/**
	 * Returns the names of available parameters.
	 * 
	 * @param edgetype
	 * @return the names of available parameters
	 * @throws Exception
	 */
	public abstract String[] getNames(EdgeType edgetype) throws Exception;
	
	/**
	 * 
	 * @param index
	 * @return IAlgorithm
	 * @throws Exception
	 */
	public abstract IAlgorithm getAlgorithm(int index) throws Exception;

	/**
	 * Imports an algorithm class-file as given.
	 * 
	 * @param file
	 *            the algorithm file
	 * @return <code>true<code> if imported
	 * @throws Exception
	 */
	public abstract boolean addAlgorithm(File file) throws Exception;

	/**
	 * @return IAlgorithm
	 * @throws Exception
	 */
	public abstract IAlgorithm getDefaultAlgorithm() throws Exception;

	/**
	 * 
	 * @param types
	 *            an array of EdgeType
	 */
	public abstract void updateAlgorithmList(GraphType[] types);

	/**
	 * Deletes an imported algorithm.
	 * 
	 * @param file
	 *            the algorithm
	 * @return <code>true</code> if the algorithm got deleted
	 * @throws Exception
	 */
	public abstract boolean deleteAlgorithm(File file) throws Exception;

}
