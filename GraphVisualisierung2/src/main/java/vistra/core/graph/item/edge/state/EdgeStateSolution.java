package vistra.core.graph.item.edge.state;

import vistra.util.IState;

/**
 * An edge state: solution ('an solution member edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class EdgeStateSolution extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	EdgeStateSolution(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewSolution();
		} catch (Exception e) {
			throw e;
		}
	}

}
