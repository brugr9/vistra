package vistra.core.traversal.step;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.state.command.BackEdgeCommand;
import vistra.core.graph.item.state.command.IItemStateCommand;

/**
 * A step: Back-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class BackEdgeStep extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public BackEdgeStep(IEdge edge) {
		super();
		this.description = "Backedge " + ((IEdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new BackEdgeCommand(edge);
			this.stepHandler.addCommand(command);
			command.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
