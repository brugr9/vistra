package vistra.core.traversal.step;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.state.command.DiscoveryEdgeCommand;
import vistra.core.graph.item.state.command.IItemStateCommand;

/**
 * A step: Discovery-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DiscoveryEdgeStep extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public DiscoveryEdgeStep(IEdge edge) {
		super();
		this.description = "Discovery-edge " + ((IEdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new DiscoveryEdgeCommand(edge);
			this.stepHandler.addItemStateCommand(command);
			command.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
