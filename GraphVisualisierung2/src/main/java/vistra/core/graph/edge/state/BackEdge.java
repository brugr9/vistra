package vistra.core.graph.edge.state;

import vistra.util.IState;

/**
 * An edge state: back ('a backedge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class BackEdge extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param edgeStateHandler
	 *            an edgeStateHandler
	 */
	BackEdge(IEdgeStateHandler edgeStateHandler) {
		super(edgeStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.back();
	}

}
