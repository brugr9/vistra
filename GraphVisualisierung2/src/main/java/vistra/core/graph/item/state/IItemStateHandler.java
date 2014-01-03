package vistra.core.graph.item.state;

/**
 * An interface for an item state handler.
 * <p>
 * This handler has a cellar at its disposal. It is therefore able to hold the
 * state history and to set a previous state.
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
	 * Sets the previous state: removes the last state from the cellar and sets
	 * the removed state as actual state.
	 * 
	 * @throws Exception
	 */
	void setPreviousState() throws Exception;

}
