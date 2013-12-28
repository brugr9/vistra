package vistra.core.traversal.step;

import vistra.core.graph.item.EdgeLayout;
import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.state.command.DiscardedEdgeCommand;
import vistra.core.graph.item.state.command.IItemStateCommand;

/**
 * A step: Discarded-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DiscardedEdgeStep extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public DiscardedEdgeStep(IEdge edge) {
		super();
		this.description = "Discarded edge " + ((EdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new DiscardedEdgeCommand(edge);
			this.stepHandler.addCommand(command);
			command.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
