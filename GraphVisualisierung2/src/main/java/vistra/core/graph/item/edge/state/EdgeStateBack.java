package vistra.core.graph.item.edge.state;

import vistra.util.IState;

/**
 * An edge state: back.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class EdgeStateBack extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	EdgeStateBack(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewBack();
		} catch (Exception e) {
			throw e;
		}
	}

}
