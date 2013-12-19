package vistra.core.graph.vertex.state;

import vistra.util.IState;

/**
 * A vertex state: active ('an active vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ActiveVertex extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param contextHandler
	 *            a contextHandler
	 */
	ActiveVertex(IVertexStateHandler contextHandler) {
		super(contextHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.activate();
	}

}
