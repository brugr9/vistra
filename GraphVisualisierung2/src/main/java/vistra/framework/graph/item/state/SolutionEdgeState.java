package vistra.framework.graph.item.state;

import vistra.framework.util.IState;

/**
 * An edge state: solution ('an solution member edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see EdgeStateHandler
 */
class SolutionEdgeState extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	SolutionEdgeState(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setPropertySolution();
		} catch (Exception e) {
			throw e;
		}
	}

}
