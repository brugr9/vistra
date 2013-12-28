package vistra.core.graph.item.state;

/**
 * An interface for a vertex state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IItemStateHandler
 * @see IEdgeStateHandler
 * 
 */
public interface IVertexStateHandler extends IItemStateHandler {

	/**
	 * Handles unexplored.
	 * 
	 * @throws Exception
	 */
	abstract void handleUnexplored() throws Exception;

	/**
	 * Handles initialised.
	 * 
	 * @throws Exception
	 */
	abstract void handleInitialised() throws Exception;

	/**
	 * Handles updated.
	 * 
	 * @param value
	 *            the value to set
	 * @throws Exception
	 */
	abstract void handleUpdated(int value) throws Exception;

	/**
	 * Handles focussed.
	 * 
	 * @throws Exception
	 */
	abstract void handleFocussed() throws Exception;

	/**
	 * Handles visited.
	 * 
	 * @throws Exception
	 */
	abstract void handleVisited() throws Exception;

	/**
	 * Handles solution.
	 * 
	 * @throws Exception
	 */
	abstract void handleSolution() throws Exception;

}
