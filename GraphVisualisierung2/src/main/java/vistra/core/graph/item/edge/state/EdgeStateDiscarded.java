package vistra.core.graph.item.edge.state;

import vistra.util.IState;

/**
 * An edge state: discarded ('a discarded edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class EdgeStateDiscarded extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	EdgeStateDiscarded(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewDiscarded();
		} catch (Exception e) {
			throw e;
		}
	}

}
