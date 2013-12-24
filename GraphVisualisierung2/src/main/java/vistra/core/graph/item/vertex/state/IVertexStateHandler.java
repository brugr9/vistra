package vistra.core.graph.item.vertex.state;

import vistra.core.graph.item.IItemStateHandler;

/**
 * An interface for a vertex state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
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