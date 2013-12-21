package vistra.core.graph.item.vertex;

import vistra.util.IState;

/**
 * A vertex state: active ('an active vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VertexStateActive extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	VertexStateActive(IVertex stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
		super.stateHandler.setViewActivated();
	} catch (Exception e) {
		throw e;
	}
}

}
