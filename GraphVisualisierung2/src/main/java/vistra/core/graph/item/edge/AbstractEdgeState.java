package vistra.core.graph.item.edge;

import vistra.util.AbstractState;
import vistra.util.IState;

/**
 * An abstract edge state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractEdgeState extends AbstractState implements IState {

	/**
	 * A field for a state handler.
	 */
	protected Edge stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	AbstractEdgeState(IEdge stateHandler) {
		this.stateHandler = (Edge) stateHandler;
	}

	/**
	 * Handles an initialise.
	 */
	void handleInitialise() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateIdle(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles a visit.
	 */
	void handleVisit() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateVisited(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles a discard.
	 */
	void handleDiscard() throws Exception {
		try {
			this.stateHandler
					.setState(new EdgeStateDiscarded(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles a solve.
	 */
	void handleSolve() throws Exception {
		try {
			this.stateHandler
					.setState(new EdgeStateSolution(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
