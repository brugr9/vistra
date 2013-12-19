package vistra.core.graph.vertex.state;

/**
 * An interface for an vertex state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertexStateHandler {

	/**
	 * Handles initialise.
	 */
	abstract void handleInitialise();

	/**
	 * Handles activate.
	 */
	abstract void handleActivate();

	/**
	 * Handles visit.
	 */
	abstract void handleVisit();

	/**
	 * Handles solve.
	 */
	abstract void handleSolve();

}
