package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * A vertex state: visited.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see VertexStateHandler
 */
class VisitedVertexState extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	VisitedVertexState(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setLayoutVisited();
		} catch (Exception e) {
			throw e;
		}
	}

}
