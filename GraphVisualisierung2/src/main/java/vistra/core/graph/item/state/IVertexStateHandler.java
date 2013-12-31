package vistra.core.graph.item.state;

/**
 * An interface for a vertex state handler.
 * <p>
 * As being an item state handler, this handler has a cellar at its disposal. It
 * is therefore able to hold the state history of the item and handles setting a
 * previous state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IItemStateHandler
 * @see IEdgeStateHandler
 * 
 */
public interface IVertexStateHandler extends IItemStateHandler {

	/**
	 * Handles initialised.
	 * 
	 * @throws Exception
	 */
	 void handleInitialised() throws Exception;

	/**
	 * Handles updated.
	 * 
	 * @param value
	 *            the value to set
	 * @throws Exception
	 */
	 void handleUpdated(String value) throws Exception;

	/**
	 * Handles focussed.
	 * 
	 * @throws Exception
	 */
	 void handleFocussed() throws Exception;

	/**
	 * Handles visited.
	 * 
	 * @throws Exception
	 */
	 void handleVisited() throws Exception;

	/**
	 * Returns the visited status.
	 * 
	 * @return {@code true} if visited
	 */
	 boolean isVisited();

}
