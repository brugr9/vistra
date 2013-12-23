package vistra.core.graph.item.edge.command;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.edge.state.EdgeStateHandler;
import vistra.core.graph.item.edge.state.IEdgeStateHandler;
import vistra.util.ICommand;

/**
 * An edge command: discover.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DiscoverEdge implements ICommand {

	/**
	 * A field for a state handler.
	 */
	private IEdgeStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            an edge
	 */
	public DiscoverEdge(IEdge edge) {
		this.stateHandler = (EdgeStateHandler) edge;
	}

	@Override
	public void execute() throws Exception {
		this.stateHandler.handleDiscovery();
	}

	@Override
	public void undo() throws Exception {
		this.stateHandler.handleUnexplored();
	}

}
