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
			this.stateHandler.setState(new UnexploredEdgeState(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles back-edge.
	 */
	void handleBack() throws Exception {
		try {
			this.stateHandler.setState(new BackEdgeState(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles forward-edge.
	 */
	void handleForward() throws Exception {
		try {
			this.stateHandler.setState(new ForwardEdgeState(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles cross-edge.
	 */
	void handleCross() throws Exception {
		try {
			this.stateHandler.setState(new CrossEdgeState(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles discarded edge.
	 */
	void handleDiscarded() throws Exception {
		try {
			this.stateHandler
					.setState(new DiscardedEdgeState(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles visited.
	 */
	void handleVisited() throws Exception {
		try {
			this.stateHandler.setState(new VisitedEdgeState(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles solution.
	 */
	void handleSolution() throws Exception {
		try {
			this.stateHandler.setState(new SolutionEdgeState(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
