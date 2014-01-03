package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * An edge state: discarded.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see EdgeStateHandler
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
			super.stateHandler.setLayoutDiscarded();
		} catch (Exception e) {
			throw e;
		}
	}

}
