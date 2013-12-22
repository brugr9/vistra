package vistra.core.graph.item.edge;

import vistra.util.IState;

/**
 * An edge state: initial ('the initial state of an edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class EdgeStateUnexplored extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	EdgeStateUnexplored(IEdge stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewUnexplored();
		} catch (Exception e) {
			throw e;
		}
	}

}
