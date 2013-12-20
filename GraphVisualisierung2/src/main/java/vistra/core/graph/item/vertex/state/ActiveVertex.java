package vistra.core.graph.item.vertex.state;

import vistra.util.IState;

/**
 * A vertex state: active ('an active vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ActiveVertex extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	ActiveVertex(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
		super.stateHandler.activate();
	} catch (Exception e) {
		throw e;
	}
}

}
