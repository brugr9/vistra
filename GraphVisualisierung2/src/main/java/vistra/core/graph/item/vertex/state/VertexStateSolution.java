package vistra.core.graph.item.vertex.state;

import vistra.util.IState;

/**
 * A vertex state: solution ('a solution member vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VertexStateSolution extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	VertexStateSolution(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewSolved();
		} catch (Exception e) {
			throw e;
		}
	}

}
