package vistra.framework.graph.item.state;

import vistra.framework.util.IState;

/**
 * A vertex state: solution ('a solution member vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 *  @see VertexStateHandler
 */
class SolutionVertexState extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SolutionVertexState(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setPropertySolutionMember();
		} catch (Exception e) {
			throw e;
		}
	}

}
