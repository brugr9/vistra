package vistra.core.graph.vertex.state;

import vistra.util.IState;

/**
 * A vertex state: visited ('a visited vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VisitedVertex extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	VisitedVertex(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.visit();
		} catch (Exception e) {
			throw e;
		}
	}

}
