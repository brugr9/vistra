package vistra.core.graph.vertex.state;

import vistra.util.IState;

/**
 * A vertex state: initial  ('the initial state of a vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class InitialVertex extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param contextHandler
	 *            a contextHandler
	 */
	InitialVertex(IVertexStateHandler contextHandler) {
		super(contextHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.initialise();
	}

}
