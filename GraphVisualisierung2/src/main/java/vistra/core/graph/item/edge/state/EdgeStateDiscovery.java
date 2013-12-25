package vistra.core.graph.item.edge.state;

import vistra.util.IState;

/**
 * An edge state: discovery ('a discovery edge').
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
	EdgeStateDiscovery(IEdgeStateHandler stateHandler) {
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
