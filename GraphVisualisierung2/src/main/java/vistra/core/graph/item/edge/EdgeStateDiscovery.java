package vistra.core.graph.item.edge;

import vistra.util.IState;

/**
 * An edge state: visited ('a visited edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class EdgeStateDiscovery extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	EdgeStateDiscovery(IEdge stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewDiscovery();
		} catch (Exception e) {
			throw e;
		}
	}

}
