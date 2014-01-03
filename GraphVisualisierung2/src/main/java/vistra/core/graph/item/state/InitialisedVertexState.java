package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * A vertex state: initialised.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see VertexStateHandler
 */
class InitialisedVertexState extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	InitialisedVertexState(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setLayoutInitialised();
		} catch (Exception e) {
			throw e;
		}
	}

}
