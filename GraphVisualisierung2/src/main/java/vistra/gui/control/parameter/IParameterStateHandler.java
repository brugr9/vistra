package vistra.gui.control.parameter;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.core.graph.item.vertex.IVertexLayout;
import vistra.gui.control.IControlStateHandler;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * An interface for a parameter state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IParameterStateHandler extends IControlStateHandler,
		ActionListener, ItemListener,
		GraphEventListener<IVertexLayout, IEdgeLayout> {

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

}
