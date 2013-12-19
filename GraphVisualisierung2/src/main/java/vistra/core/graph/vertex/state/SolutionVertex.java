/**
 * 
 */
package vistra.core.graph.vertex.state;

import vistra.util.IState;

/**
 * A vertex state: solution ('a solution member vertex').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class SolutionVertex extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param contextHandler
	 *            a contextHandler
	 */
	SolutionVertex(IVertexStateHandler contextHandler) {
		super(contextHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.solve();
	}

}
