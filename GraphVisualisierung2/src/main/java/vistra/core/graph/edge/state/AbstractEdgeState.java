/**
 * 
 */
package vistra.core.graph.edge.state;

import vistra.util.IState;
import vistra.util.State;

/**
 * An abstract edge state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractEdgeState extends State implements IState {

	/**
	 * A field for a context.
	 */
	protected EdgeStateHandler context;

	/**
	 * Main constructor.
	 * 
	 * @param contextHandler
	 *            a contextHandler
	 */
	AbstractEdgeState(IEdgeStateHandler contextHandler) {
		this.context = (EdgeStateHandler) contextHandler;
	}

	/**
	 * Handles an initialisation.
	 */
	void handleInitialise() {
		this.context.setState(new InitialEdge(this.context));
	}

	/**
	 * Handles a back.
	 */
	void handleBack() {
		this.context.setState(new BackEdge(this.context));
	}

	/**
	 * Handles a visit.
	 */
	void handleVisit() {
		this.context.setState(new VisitedEdge(this.context));
	}

	/**
	 * Handles a discard.
	 */
	void handleDiscard() {
		this.context.setState(new DiscardedEdge(this.context));
	}

	/**
	 * Handles a solve.
	 */
	void handleSolve() {
		this.context.setState(new SolutionEdge(this.context));
	}

}
