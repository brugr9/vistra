package vistra.core.graph.item.edge.state;

import vistra.core.graph.item.vertex.state.IVertexStateHandler;
import vistra.core.graph.item.vertex.state.VertexStateHandler;
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
