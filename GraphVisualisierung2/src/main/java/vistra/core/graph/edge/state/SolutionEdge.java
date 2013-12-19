/**
 * 
 */
package vistra.core.graph.edge.state;

import vistra.util.IState;

/**
 * An edge state: solution ('an solution member edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class SolutionEdge extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	SolutionEdge(IEdgeStateHandler stateHandler) {
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
