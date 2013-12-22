package vistra.core.graph.item.vertex;

/**
 * An interface for an vertex (state handler).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertex extends IVertexModel {

	/**
	 * Handles unexplored.
	 * 
	 * @throws Exception
	 */
	abstract void handleUnexplored() throws Exception;

	/**
	 * Handles visit.
	 * 
	 * @throws Exception
	 */
	abstract void handleVisit() throws Exception;

	/**
	 * Handles visited.
	 * 
	 * @throws Exception
	 */
	abstract void handleVisited() throws Exception;

	/**
	 * Handles solve.
	 * 
	 * @throws Exception
	 */
	abstract void handleSolution() throws Exception;

}
