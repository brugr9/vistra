package vistra.core.graph.item.state.command;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.state.EdgeStateHandler;

/**
 * An item-state command: discovery-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DiscoveryEdgeCommand extends AbstractItemStateCommand implements
		IItemStateCommand {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            an edge
	 */
	public DiscoveryEdgeCommand(IEdge edge) {
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
