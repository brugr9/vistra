package vistra.core.graph;

import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.core.zobsolete.graph.IGravisGraph;
import vistra.core.zobsolete.graph.IObservableGraph;

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
	 * @return the graph
	 * @throws Exception
	 */
	public abstract IObservableGraph getNewGraph() throws Exception;

	/**
	 * Opens a GraphML-file as graph.
	 * 
	 * @param file
	 *            the file to open
	 * @return the graph
	 * @throws Exception
	 */
	public abstract IObservableGraph open(File file) throws Exception;

	/**
	 * Saves a graph as GraphML-file.
	 * 
	 * @param graph
	 *            the graph to save
	 * @throws Exception
	 */
	public void save(IGravisGraph graph) throws Exception;

	/**
	 * Saves a graph into a GraphML-file.
	 * 
	 * @param graph
	 *            the graph to save
	 * @param file
	 *            the file to write into
	 * @throws Exception
	 */
	public void saveAs(IGravisGraph graph, File file) throws Exception;

	/**
	 * Returns the file name extension filter.
	 * 
	 * @return the file name extension filter
	 */
	public abstract FileNameExtensionFilter getFilter();

}