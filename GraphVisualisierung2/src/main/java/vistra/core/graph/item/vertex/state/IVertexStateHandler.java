package vistra.core.graph.item.vertex.state;

/**
 * An interface for an vertex state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertexStateHandler {

	/**
	 * Handles initialise.
	 * 
	 * @throws Exception
	 */
	abstract void handleInitialise() throws Exception;

	/**
	 * Handles activate.
	 * 
	 * @throws Exception
	 */
	abstract void handleActivate() throws Exception;

	/**
	 * Handles visit.
	 * 
	 * @throws Exception
	 */
	abstract void handleVisit() throws Exception;

	/**
	 * Handles solve.
	 * 
	 * @throws Exception
	 */
	abstract void handleSolve() throws Exception;

}
