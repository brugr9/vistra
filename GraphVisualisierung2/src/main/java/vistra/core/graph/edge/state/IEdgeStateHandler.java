package vistra.core.graph.edge.state;

/**
 * An interface for an edge state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IEdgeStateHandler {

	/**
	 * Handles initialise.
	 * 
	 * @throws Exception
	 */
	abstract void handleInitialise() throws Exception;

	/**
	 * Handles back.
	 * 
	 * @throws Exception
	 */
	abstract void handleBack() throws Exception;

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
