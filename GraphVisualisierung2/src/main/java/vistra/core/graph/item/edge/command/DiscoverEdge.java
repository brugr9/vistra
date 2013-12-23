package vistra.core.graph.item.edge.command;

import vistra.core.graph.item.edge.IEdge;
import vistra.util.ICommand;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DiscoverEdge implements ICommand {

	/**
	 * A field for an edge.
	 */
	private IEdge edge;

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            an edge
	 */
	public DiscoverEdge(IEdge edge) {
		this.edge = edge;
	}

	@Override
	public void execute() throws Exception {
		this.edge.handleDiscovery();
	}

	@Override
	public void undo() throws Exception {
		this.edge.handleUnexplored();
	}

}
