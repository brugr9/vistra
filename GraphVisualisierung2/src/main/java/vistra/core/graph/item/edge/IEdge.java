package vistra.core.graph.item.edge;

/**
 * An interface for an edge (state handler).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IEdge extends IEdgeModel {

	/**
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	abstract void handleIdle() throws Exception;

	/**
	 * Handles visit.
	 * 
	 * @throws Exception
	 */
	abstract void handleVisit() throws Exception;

	/**
	 * Handles discard.
	 * 
	 * @throws Exception
	 */
	abstract void handleDiscard() throws Exception;

	/**
	 * Handles solve.
	 * 
	 * @throws Exception
	 */
	abstract void handleSolve() throws Exception;

}
