package vistra.core.graph.item.edge;

import vistra.util.IState;

/**
 * An edge state: forward.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class EdgeStateForward extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	EdgeStateForward(IEdge stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewForward();
		} catch (Exception e) {
			throw e;
		}
	}

}
