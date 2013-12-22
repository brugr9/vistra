package vistra.core.graph.item.edge;

import vistra.util.AbstractState;
import vistra.util.IState;

/**
 * An abstract edge state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AbstractEdgeState extends AbstractState implements IState {

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
	 * Handles unexplored.
	 */
	void handleUnexplored() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateUnexplored(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles discovery.
	 */
	void handleDiscovery() throws Exception {
		try {
			this.stateHandler
					.setState(new EdgeStateDiscovery(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles back.
	 */
	void handleBack() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateBack(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles forward.
	 */
	void handleForward() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateForward(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles cross.
	 */
	void handleCross() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateCross(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles discarded.
	 */
	void handleDiscarded() throws Exception {
		try {
			this.stateHandler
					.setState(new EdgeStateDiscarded(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles a solution.
	 */
	void handleSolution() throws Exception {
		try {
			this.stateHandler
					.setState(new EdgeStateSolution(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
