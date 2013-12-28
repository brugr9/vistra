package vistra.core.graph.item.state.command;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.state.EdgeStateHandler;

/**
 * An item-state command: forward-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ForwardEdgeCommand extends AbstractItemStateCommand implements
		IItemCommand {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            an edge
	 */
	public ForwardEdgeCommand(IEdge edge) {
		super((EdgeStateHandler) edge);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		((EdgeStateHandler) super.stateHandler).handleForward();
	}

}