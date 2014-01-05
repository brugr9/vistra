package vistra.framework.graph.item.state;

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
	 * Handles back-edge.
	 * 
	 * @throws Exception
	 */
	void handleBack() throws Exception;

	/**
	 * Handles forward-edge.
	 * 
	 * @throws Exception
	 */
	void handleForward() throws Exception;

	/**
	 * Handles cross-edge.
	 * 
	 * @throws Exception
	 */
	void handleCross() throws Exception;

	/**
	 * Handles discarded edge.
	 * 
	 * @throws Exception
	 */
	void handleDiscarded() throws Exception;

}
