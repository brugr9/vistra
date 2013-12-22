package vistra.core.algorithm;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm manager.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IAlgorithmManager {

	/**
	 * Returns the workbench directory.
	 * 
	 * @return the workbench directory
	 */
	public abstract String getWorkbench();

	/**
	 * Returns the file name extension filter.
	 * 
	 * @return the file name extension filter
	 */
	public abstract FileNameExtensionFilter getFilter();

	/**
	 * Adds an algorithm file as given and returns the edge types the algorithm
	 * can handle.
	 * 
	 * @param file
	 *            the algorithm file
	 * @return the edge types
	 * @throws Exception
	 */
	public abstract EdgeType[] add(File file) throws Exception;

	/**
	 * Returns a list of names with algorithms capable to operate on graphs with
	 * the edge type as given.
	 * 
	 * @param edgeType
	 *            the graph type
	 * @return the algorithm names
	 * @throws Exception
	 */
	public abstract String[] getNames(EdgeType edgeType) throws Exception;

	/**
	 * Selects an algorithm by index, loads and returns the algorithm.
	 * 
	 * @param index
	 *            the algorithm index
	 * @return the algorithm
	 * @throws Exception
	 */
	public abstract IAlgorithm select(int index) throws Exception;

	/**
	 * Removes an imported algorithm file as given and returns the edge types
	 * the removed algorithm can handle.
	 * 
	 * 
	 * @param fileName
	 *            the algorithm file name
	 * @return the edge types
	 * @throws Exception
	 */
	public abstract EdgeType[] remove(String fileName) throws Exception;

}