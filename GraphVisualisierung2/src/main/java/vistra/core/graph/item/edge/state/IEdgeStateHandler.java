package vistra.core.graph.item.edge.state;

import vistra.core.graph.item.IItemStateHandler;

/**
 * An interface for an edge state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
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
	 * Handles solution.
	 * 
	 * @throws Exception
	 */
	abstract void handleSolution() throws Exception;

}
