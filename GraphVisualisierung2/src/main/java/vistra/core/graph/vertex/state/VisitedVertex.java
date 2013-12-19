package vistra.core.graph.vertex.state;

import vistra.util.IState;

/**
 * A vertex state: visited ('a visited vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VisitedVertex extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param contextHandler
	 *            a contextHandler
	 */
	VisitedVertex(IVertexStateHandler contextHandler) {
		super(contextHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.visit();
	}

}
