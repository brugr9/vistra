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
	 * Handles initialise.
	 * 
	 * @throws Exception
	 */
	void handleInitialise() throws Exception {
		try {
			this.stateHandler.setState(new VertexStateIdle(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles activate.
	 * 
	 * @throws Exception
	 */
	void handleActivate() throws Exception {
		try {
			this.stateHandler.setState(new VertexStateActive(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles visiting.
	 * 
	 * @throws Exception
	 */
	void handleVisit() throws Exception {
		try {
			this.stateHandler.setState(new VertexStateVisited(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles solving.
	 * 
	 * @throws Exception
	 */
	void handleSolve() throws Exception {
		try {
			this.stateHandler.setState(new VertexStateSolution(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
