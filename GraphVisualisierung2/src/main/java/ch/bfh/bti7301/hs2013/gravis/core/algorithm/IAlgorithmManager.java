package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.io.File;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm.GraphType;
import ch.bfh.bti7301.hs2013.gravis.core.IParameterManager;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IAlgorithmManager extends IParameterManager {

	/**
	 * 
	 * @param algorithmId
	 * @return IAlgorithm
	 * @throws Exception
	 */
	public abstract IAlgorithm getAlgorithm(String algorithmId)
			throws Exception;

	/**
	 * Imports an algorithm class-file as given.
	 * 
	 * @param file
	 *            the graph file
	 * @return the imported algorithm
	 * @throws Exception
	 */
	public abstract IAlgorithm importAlgorithm(File file) throws Exception;

	/**
	 * Deletes an imported algorithm.
	 * 
	 * @param algorithmId
	 *            the algorithm ID
	 * @return <code>true</code> if the algorithm got deleted
	 * @throws Exception
	 */
	public abstract boolean deleteAlgorithm(String algorithmId)
			throws Exception;

	/**
	 * @return IAlgorithm
	 * @throws Exception
	 */
	public abstract IAlgorithm getDefaultAlgorithm() throws Exception;

	/**
	 * 
	 * @param types
	 *            GraphType[]
	 */
	public abstract void updateAlgorithmList(GraphType[] types);

	/**
	 * @param file
	 */
	public abstract void deleteAlgorithm(File file);

}
