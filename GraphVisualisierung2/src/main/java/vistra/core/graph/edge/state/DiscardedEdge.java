package vistra.core.graph.edge.state;

import vistra.util.IState;

/**
 * An edge state: discarded ('a discarded edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class DiscardedEdge extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	DiscardedEdge(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.discard();
		} catch (Exception e) {
			throw e;
		}
	}

}
