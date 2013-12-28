package vistra.core.graph.item.state.command;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.state.EdgeStateHandler;

/**
 * An item-state command: cross-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class CrossEdgeCommand extends AbstractItemStateCommand implements
		IItemCommand {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            an edge
	 */
	public CrossEdgeCommand(IEdge edge) {
		super((EdgeStateHandler) edge);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		((EdgeStateHandler) super.stateHandler).handleCross();
	}

}
