package vistra.core.graph.item.vertex;

import vistra.util.IState;

/**
 * A vertex state: visit.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VertexStateVisit extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	VertexStateVisit(IVertex stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewVisit();
		} catch (Exception e) {
			throw e;
		}
	}

}
