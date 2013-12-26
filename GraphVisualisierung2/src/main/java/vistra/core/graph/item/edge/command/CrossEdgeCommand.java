package vistra.core.graph.item.edge.command;

import vistra.core.graph.item.AbstractItemCommand;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.edge.state.EdgeStateHandler;
import vistra.util.ICommand;

/**
 * An edge command: cross-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class CrossEdgeCommand extends AbstractItemCommand implements ICommand {

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
