package vistra.core.graph.item.vertex;

import vistra.util.IState;

/**
 * A vertex state: visit.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VertexStateFocussed extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	VertexStateFocussed(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewFocussed();
		} catch (Exception e) {
			throw e;
		}
	}

}
