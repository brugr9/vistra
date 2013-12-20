package vistra.core.graph.item.edge.state;

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
	 *            a stateHandler
	 */
	AbstractEdgeState(IEdgeStateHandler stateHandler) {
		this.stateHandler = (EdgeStateHandler) stateHandler;
	}

	/**
	 * Handles an initialisation.
	 */
	void handleInitialise() throws Exception {
		try {
			this.stateHandler.setState(new InitialEdge(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles a back.
	 */
	void handleBack() throws Exception {
		try {
			this.stateHandler.setState(new BackEdge(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles a visit.
	 */
	void handleVisit() throws Exception {
		try {
			this.stateHandler.setState(new VisitedEdge(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles a discard.
	 */
	void handleDiscard() throws Exception {
		try {
			this.stateHandler.setState(new DiscardedEdge(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Handles a solve.
	 */
	void handleSolve() throws Exception {
		try {
			this.stateHandler.setState(new SolutionEdge(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
