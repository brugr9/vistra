package vistra.core.graph.vertex.state;

import vistra.util.IState;

/**
 * A vertex state: initial ('the initial state of a vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class InitialVertex extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	InitialVertex(IVertexStateHandler stateHandler) {
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
