package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * An edge state: back.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see EdgeStateHandler
 */
class BackEdgeState extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	BackEdgeState(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setLayoutBack();
		} catch (Exception e) {
			throw e;
		}
	}

}
