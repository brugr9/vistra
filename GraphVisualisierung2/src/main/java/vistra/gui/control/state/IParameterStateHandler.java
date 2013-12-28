package vistra.gui.control.state;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import edu.uci.ics.jung.graph.event.GraphEventListener;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.control.IControlStateHandler;

/**
 * An interface for a parameter state handler. A parameter state machine handles
 * a graph and an algorithm as parameter for generating a traversal-object.
 * <p>
 * As a part of the graphic user interface control, this state handler is an
 * action listener (file menu for the graph) and an item listener (algorithm
 * combo box), too. Furthermore, this handler listens on graph-events (e.g. the
 * graph got edited or saved).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ISbsStateHandler
 * @see IAnimationStateHandler
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
