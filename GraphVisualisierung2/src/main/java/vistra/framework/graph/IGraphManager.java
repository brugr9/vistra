package vistra.framework.graph;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A graph manager interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGraphManager {

	/**
	 * Creates and returns an empty graph.
	 * 
	 * @param edgeType
	 *            the edge type
	 * @return the graph
	 * @throws Exception
	 */
	ILayoutGraph newGraph(EdgeType edgeType) throws Exception;

	/**
	 * Opens a GraphML-file as graph.
	 * 
	 * @param file
	 *            the file to open
	 * @return the graph
	 * @throws Exception
	 */
	ILayoutGraph open(File file) throws Exception;

	/**
	 * Saves the graph as GraphML-file.
	 * 
	 * @throws Exception
	 */
	void save() throws Exception;

	/**
	 * Saves the graph into a GraphML-file as given.
	 * 
	 * @param file
	 *            the file to write into
	 * @throws Exception
	 */
	void saveAs(File file) throws Exception;

	/**
	 * Returns the file name extension filter.
	 * 
	 * @return the file name extension filter
	 */
	FileNameExtensionFilter getFilter();

}