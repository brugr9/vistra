package vistra.core.graph.item.state;

import vistra.util.AbstractState;
import vistra.util.IState;

/**
 * An abstract edge state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see EdgeStateHandler
 */
abstract class AbstractEdgeState extends AbstractState implements IState {

	/**
	 * A field for a state handler.
	 */
	protected EdgeStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	AbstractEdgeState(IEdgeStateHandler stateHandler) {
		this.stateHandler = (EdgeStateHandler) stateHandler;
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
	 * Handles discovery-edge.
	 */
	void handleDiscoveryEdge() throws Exception {
		try {
			this.stateHandler
					.setState(new EdgeStateDiscovery(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles back-edge.
	 */
	void handleBackEdge() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateBack(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles forward-edge.
	 */
	void handleForwardEdge() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateForward(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles cross-edge.
	 */
	void handleCrossEdge() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateCross(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles discarded edge.
	 */
	void handleDiscardedEdge() throws Exception {
		try {
			this.stateHandler
					.setState(new EdgeStateDiscarded(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles solution member.
	 */
	void handleSolutionMember() throws Exception {
		try {
			this.stateHandler.setState(new EdgeStateSolutionMember(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
