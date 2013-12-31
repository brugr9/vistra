package vistra.core.graph.item.state;

/**
 * An interface for an edge state handler.
 * <p>
 * As being an item state handler, this handler has a cellar at its disposal. It
 * is therefore able to hold the state history of the item and handles setting a
 * previous state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IItemStateHandler
 * @see IVertexStateHandler
 * 
 */
public interface IEdgeStateHandler extends IItemStateHandler {

	/**
	 * Handles discovery edge.
	 * 
	 * @throws Exception
	 */
	void handleDiscoveryEdge() throws Exception;

	/**
	 * Handles back-edge.
	 * 
	 * @throws Exception
	 */
	void handleBackEdge() throws Exception;

	/**
	 * Handles forward-edge.
	 * 
	 * @throws Exception
	 */
	void handleForwardEdge() throws Exception;

	/**
	 * Handles cross-edge.
	 * 
	 * @throws Exception
	 */
	void handleCrossEdge() throws Exception;

	/**
	 * Handles discarded edge.
	 * 
	 * @throws Exception
	 */
	void handleDiscardedEdge() throws Exception;

}
