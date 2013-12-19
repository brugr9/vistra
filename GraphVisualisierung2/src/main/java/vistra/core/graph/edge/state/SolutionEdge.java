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
	 * @param edgeStateHandler
	 *            an edgeStateHandler
	 */
	SolutionEdge(IEdgeStateHandler edgeStateHandler) {
		super(edgeStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.solve();
	}

}
