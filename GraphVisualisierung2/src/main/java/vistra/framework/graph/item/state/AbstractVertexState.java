package vistra.framework.graph.item.state;

import vistra.framework.util.AbstractState;
import vistra.framework.util.IState;

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
			this.stateHandler.setState(new UnexploredVertexState(
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
			this.stateHandler.setState(new InitialisedVertexState(
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
	void handleUpdated(String value) throws Exception {
		try {
			this.stateHandler.setState(new UpdatedVertexState(
					this.stateHandler, value));
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
					.setState(new VisitedVertexState(this.stateHandler));
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
			this.stateHandler.setState(new SolutionVertexState(
					this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
