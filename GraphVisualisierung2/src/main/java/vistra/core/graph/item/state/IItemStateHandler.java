package vistra.core.graph.item.state;

/**
 * An interface for an item state handler.
 * <p>
 * As being an item state handler, this handler has a cellar at its disposal.
 * Its therefore able to hold the state history of the item and handles setting
 * a previous state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IVertexStateHandler
 * @see IEdgeStateHandler
 * 
 */
public interface IItemStateHandler {

	/**
	 * Handles setting the previous state as getting it from the state cellar.
	 * 
	 * @throws Exception
	 */
	abstract void handleSetPreviousState() throws Exception;

}
