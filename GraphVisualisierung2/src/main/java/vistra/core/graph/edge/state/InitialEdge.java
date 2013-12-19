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
	 * @param stateHandler
	 *            a state handler
	 */
	InitialEdge(IEdgeStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.initialise();
		} catch (Exception e) {
			throw e;
		}
	}

}
