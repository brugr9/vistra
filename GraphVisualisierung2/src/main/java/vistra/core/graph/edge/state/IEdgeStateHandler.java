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
	 */
	abstract void handleInitialise();

	/**
	 * Handles back.
	 */
	abstract void handleBack();

	/**
	 * Handles visit.
	 */
	abstract void handleVisit();

	/**
	 * Handles discard.
	 */
	abstract void handleDiscard();

	/**
	 * Handles solve.
	 */
	abstract void handleSolve();

}
