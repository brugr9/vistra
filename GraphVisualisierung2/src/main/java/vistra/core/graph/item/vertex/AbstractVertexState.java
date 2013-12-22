package vistra.core.graph.item.vertex;

import vistra.util.AbstractState;
import vistra.util.IState;

/**
 * An abstract vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractVertexState extends AbstractState implements IState {

	/**
	 * A field for a state handler.
	 */
	protected Vertex stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	AbstractVertexState(IVertex stateHandler) {
		this.stateHandler = (Vertex) stateHandler;
	}

	/**
	 * Handles unexplored.
	 * 
	 * @throws Exception
	 */
	void handleUnexplored() throws Exception {
		try {
			this.stateHandler.setState(new VertexStateUnexplored(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles visit.
	 * 
	 * @throws Exception
	 */
	void handleVisit() throws Exception {
		try {
			this.stateHandler.setState(new VertexStateVisit(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles visited.
	 * 
	 * @throws Exception
	 */
	void handleVisited() throws Exception {
		try {
			this.stateHandler
					.setState(new VertexStateVisited(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles solution.
	 * 
	 * @throws Exception
	 */
	void handleSolution() throws Exception {
		try {
			this.stateHandler.setState(new VertexStateSolution(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
