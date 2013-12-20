package vistra.core.graph.item.vertex.state;

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
	protected VertexStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	AbstractVertexState(IVertexStateHandler stateHandler) {
		this.stateHandler = (VertexStateHandler) stateHandler;
	}

	/**
	 * Handles initialise.
	 * 
	 * @throws Exception
	 */
	void handleInitialise() throws Exception {
		try {
			this.stateHandler.setState(new InitialVertex(this.stateHandler));
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
			this.stateHandler.setState(new ActiveVertex(this.stateHandler));
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
			this.stateHandler.setState(new VisitedVertex(this.stateHandler));
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
			this.stateHandler.setState(new SolutionVertex(this.stateHandler));
		} catch (Exception e) {
			throw e;
		}
	}

}
