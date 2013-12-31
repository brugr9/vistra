package vistra.core.graph.item.state;

/**
 * An interface for an item state handler.
 * <p>
 * This handler has a cellar at its disposal. It is therefore able to hold the
 * state history of the item and handles setting a previous state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IVertexStateHandler
 * @see IEdgeStateHandler
 * 
 */
public interface IItemStateHandler {

	/**
	 * Handles unexplored.
	 * 
	 * @throws Exception
	 */
	void handleUnexplored() throws Exception;

	/**
	 * Handles solution member.
	 * 
	 * @throws Exception
	 */
	void handleSolutionMember() throws Exception;

	/**
	 * Handles setting the previous state as getting it from the state cellar.
	 * 
	 * @throws Exception
	 */
	void handleSetPreviousState() throws Exception;

}
