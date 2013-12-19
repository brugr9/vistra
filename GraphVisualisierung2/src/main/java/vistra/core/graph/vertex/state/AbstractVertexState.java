/**
 * 
 */
package vistra.core.graph.vertex.state;

import vistra.util.IState;
import vistra.util.State;

/**
 * An abstract vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractVertexState extends State implements IState {

	/**
	 * A field for a context.
	 */
	protected VertexStateHandler context;

	/**
	 * Main constructor.
	 * 
	 * @param vertexStateHandler
	 *            an edgeStateHandler
	 */
	AbstractVertexState(IVertexStateHandler vertexStateHandler) {
		this.context = (VertexStateHandler) vertexStateHandler;
	}

	/**
	 * Handles initialise.
	 */
	void handleInitialise() {
		this.context.setState(new InitialVertex(this.context));
	}

	/**
	 * Handles activate.
	 */
	void handleActivate() {
		this.context.setState(new ActiveVertex(this.context));
	}

	/**
	 * Handles visiting.
	 */
	void handleVisit() {
		this.context.setState(new VisitedVertex(this.context));
	}

	/**
	 * Handles solving.
	 */
	void handleSolve() {
		this.context.setState(new SolutionVertex(this.context));
	}

}
