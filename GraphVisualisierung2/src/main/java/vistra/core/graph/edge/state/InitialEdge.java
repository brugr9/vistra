package vistra.core.graph.edge.state;

import vistra.util.IState;

/**
 * An edge state: initial ('the initial state of an edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class InitialEdge extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param edgeStateHandler
	 *            an edgeStateHandler
	 */
	InitialEdge(IEdgeStateHandler edgeStateHandler) {
		super(edgeStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.initialise();
	}

}
