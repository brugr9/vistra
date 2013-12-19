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
	 * @param stateHandler
	 *            a state handler
	 */
	VisitedEdge(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.visit();
		} catch (Exception e) {
			throw e;
		}
	}

}
