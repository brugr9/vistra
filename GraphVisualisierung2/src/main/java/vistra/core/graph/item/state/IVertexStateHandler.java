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
	void handleUpdatedVertex(String value) throws Exception;

	/**
	 * Handles focus on.
	 * 
	 * @throws Exception
	 */
	void handleFocusOnVertex() throws Exception;

	/**
	 * Handles visited.
	 * 
	 * @throws Exception
	 */
	void handleVisitedVertex() throws Exception;

	/**
	 * Returns the visited status.
	 * 
	 * @return {@code true} if visited
	 */
	boolean isVisited();

}
