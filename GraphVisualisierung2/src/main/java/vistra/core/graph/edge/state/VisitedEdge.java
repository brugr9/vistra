package vistra.core.graph.edge.state;

import vistra.util.IState;

/**
 * An edge state: visited ('a visited edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VisitedEdge extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param edgeStateHandler
	 *            an edgeStateHandler
	 */
	VisitedEdge(IEdgeStateHandler edgeStateHandler) {
		super(edgeStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.visit();
	}

}
