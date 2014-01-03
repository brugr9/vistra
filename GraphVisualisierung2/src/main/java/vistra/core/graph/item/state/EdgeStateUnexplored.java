package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * An edge state: unexplored.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see EdgeStateHandler
 */
class EdgeStateUnexplored extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	EdgeStateUnexplored(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setLayoutUnexplored();
		} catch (Exception e) {
			throw e;
		}
	}

}
