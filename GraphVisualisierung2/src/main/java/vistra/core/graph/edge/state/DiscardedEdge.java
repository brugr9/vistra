/**
 * 
 */
package vistra.core.graph.edge.state;

import vistra.util.IState;

/**
 * An edge state: discarded ('a discarded edge').
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class DiscardedEdge extends AbstractEdgeState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param edgeStateHandler
	 *            an edgeStateHandler
	 */
	DiscardedEdge(IEdgeStateHandler edgeStateHandler) {
		super(edgeStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.discard();
	}

}
