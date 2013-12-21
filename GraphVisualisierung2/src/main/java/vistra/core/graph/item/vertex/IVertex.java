package vistra.core.graph.item.vertex;

/**
 * An interface for an vertex (state handler).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertex extends IVertexModel {

	/**
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	abstract void handleIdle() throws Exception;

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
