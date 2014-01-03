package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * A vertex state: solution ('a solution member vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 *  @see VertexStateHandler
 */
class VertexStateSolutionMember extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	VertexStateSolutionMember(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setLayoutSolutionMember();
		} catch (Exception e) {
			throw e;
		}
	}

}
