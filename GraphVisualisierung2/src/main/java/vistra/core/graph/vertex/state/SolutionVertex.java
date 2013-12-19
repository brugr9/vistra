package vistra.core.graph.vertex.state;

import vistra.util.IState;

/**
 * A vertex state: solution ('a solution member vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class SolutionVertex extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SolutionVertex(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.solve();
		} catch (Exception e) {
			throw e;
		}
	}

}
