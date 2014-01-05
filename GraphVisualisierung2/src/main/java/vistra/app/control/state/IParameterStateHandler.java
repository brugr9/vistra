package vistra.app.control.state;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
import edu.uci.ics.jung.graph.event.GraphEventListener;

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
	void handleNewGraphUndirected() throws Exception;

	/**
	 * Handles an interaction: new directed graph.
	 * 
	 * @throws Exception
	 */
	void handleNewGraphDirected() throws Exception;

	/**
	 * Handles an interaction: open graph.
	 * 
	 * @throws Exception
	 */
	void handleOpenGraph() throws Exception;

	/**
	 * Handles an interaction: save graph.
	 * 
	 * @throws Exception
	 */
	void handleSaveGraph() throws Exception;

	/**
	 * Handles an interaction: save graph as.
	 * 
	 * @throws Exception
	 */
	void handleSaveGraphAs() throws Exception;

	/**
	 * Handles an interaction: edit graph.
	 * 
	 * @throws Exception
	 */
	void handleEditGraph() throws Exception;

	/**
	 * Handles an interaction: select algorithm.
	 * 
	 * @throws Exception
	 */
	void handleSelectAlgorithm() throws Exception;

}
