package vistra.core.graph.item.state.command;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.state.EdgeStateHandler;

/**
 * An item-state command: visited edge (discovery-edge).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisitedEdgeCommand extends AbstractItemStateCommand implements
		IItemStateCommand {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            an edge
	 */
	public VisitedEdgeCommand(IEdge edge) {
		super((EdgeStateHandler) edge);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		((EdgeStateHandler) super.stateHandler).handleVisited();
	}

}
