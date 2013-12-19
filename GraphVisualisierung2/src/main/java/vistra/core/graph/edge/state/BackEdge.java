package vistra.core.graph.edge.state;

import vistra.util.IState;

/**
 * An edge state: back ('a backedge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class BackEdge extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	BackEdge(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.back();
		} catch (Exception e) {
			throw e;
		}
	}
}
