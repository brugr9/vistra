package vistra.core.graph.item.state;

import vistra.util.AbstractState;
import vistra.util.IState;

/**
 * An abstract vertex state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see VertexStateHandler
 */
abstract class AbstractVertexState extends AbstractState implements IState {

	/**
	 * A field for a state handler.
	 */
	protected VertexStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	AbstractVertexState(IVertexStateHandler stateHandler) {
		this.stateHandler = (VertexStateHandler) stateHandler;
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
	 * Handles initialised.
	 * 
	 * @throws Exception
	 */
	void handleInitialised() throws Exception {
		try {
			this.stateHandler.setState(new VertexStateInitialised(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles updated.
	 * 
	 * @param value
	 *            the value to set
	 * @throws Exception
	 */
	void handleUpdated(int value) throws Exception {
		try {
			this.stateHandler.setState(new VertexStateUpdated(
					this.stateHandler, value));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles visit.
	 * 
	 * @throws Exception
	 */
	void handleFocussed() throws Exception {
		try {
			this.stateHandler.setState(new VertexStateFocussed(
					this.stateHandler));
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
