package vistra.gui.control.parameter;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import vistra.gui.control.IControlStateHandler;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * An interface for a parameter state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IParameterStateHandler extends IControlStateHandler,
		ActionListener, ItemListener, GraphEventListener<IVertex, IEdge> {

	/**
	 * Handles an interaction: new undirected graph.
	 * 
	 * @throws Exception
	 */
	abstract void handleNewGraphUndirected() throws Exception;

	/**
	 * Handles an interaction: new directed graph.
	 * 
	 * @throws Exception
	 */
	abstract void handleNewGraphDirected() throws Exception;

	/**
	 * Handles an interaction: open graph.
	 * 
	 * @throws Exception
	 */
	abstract void handleOpenGraph() throws Exception;

	/**
	 * Handles an interaction: save graph.
	 * 
	 * @throws Exception
	 */
	abstract void handleSaveGraph() throws Exception;

	/**
	 * Handles an interaction: save graph as.
	 * 
	 * @throws Exception
	 */
	abstract void handleSaveGraphAs() throws Exception;

	/**
	 * Handles an interaction: edit graph.
	 * 
	 * @throws Exception
	 */
	abstract void handleEditGraph() throws Exception;

	/**
	 * Handles an interaction: select algorithm.
	 * 
	 * @throws Exception
	 */
	abstract void handleSelectAlgorithm() throws Exception;

	/**
	 * Handles an interaction: import algorithm.
	 * 
	 * @throws Exception
	 */
	abstract void handleImportAlgorithm() throws Exception;

	/**
	 * Handles an interaction: delete algorithm.
	 * 
	 * @throws Exception
	 */
	abstract void handleDeleteAlgorithm() throws Exception;

}
