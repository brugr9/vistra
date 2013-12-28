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
	 * Handles unexplored.
	 * 
	 * @throws Exception
	 */
	abstract void handleUnexplored() throws Exception;

	/**
	 * Handles discovery.
	 * 
	 * @throws Exception
	 */
	abstract void handleDiscovery() throws Exception;

	/**
	 * Handles back.
	 * 
	 * @throws Exception
	 */
	abstract void handleBack() throws Exception;

	/**
	 * Handles forward.
	 * 
	 * @throws Exception
	 */
	abstract void handleForward() throws Exception;

	/**
	 * Handles cross.
	 * 
	 * @throws Exception
	 */
	abstract void handleCross() throws Exception;

	/**
	 * Handles discarded.
	 * 
	 * @throws Exception
	 */
	abstract void handleDiscarded() throws Exception;

	/**
	 * Handles solution.
	 * 
	 * @throws Exception
	 */
	abstract void handleSolution() throws Exception;

}
