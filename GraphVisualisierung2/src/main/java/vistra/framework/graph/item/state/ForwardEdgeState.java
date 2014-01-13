package vistra.framework.graph.item.state;

import vistra.framework.util.IState;

/**
 * An edge state: forward.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see EdgeStateHandler
 */
class ForwardEdgeState extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	ForwardEdgeState(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setPropertyForward();
		} catch (Exception e) {
			throw e;
		}
	}

}
