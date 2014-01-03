package vistra.core.traversal.step;

import java.util.List;

import vistra.core.graph.item.EdgeLayout;
import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.state.command.DiscardedEdgeCommand;
import vistra.core.graph.item.state.command.IItemStateCommand;

/**
 * A step: Discarded edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DiscardedEdgeStep extends AbstractStep implements IStep {

	/**
	 * Single item constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public DiscardedEdgeStep(IEdge edge) {
		super();
		this.description = "Discarded edge: " + ((EdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new DiscardedEdgeCommand(edge);
			this.stepHandler.addItemStateCommand(command);
			command.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi items constructor.
	 * 
	 * @param edges
	 *            the edges
	 */
	public DiscardedEdgeStep(List<IEdge> edges) {
		super();
		this.description = "Discarded edges: ";
		try {
			for (IEdge edge : edges) {
				IItemStateCommand command = new DiscardedEdgeCommand(edge);
				this.stepHandler.addItemStateCommand(command);
				command.execute();
				this.description += ((EdgeLayout) edge).getId() + ", ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
