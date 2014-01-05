package vistra.framework.traversal.step;

import java.util.List;

import vistra.framework.graph.item.EdgeLayout;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.state.command.BackEdgeCommand;
import vistra.framework.graph.item.state.command.IItemStateCommand;

/**
 * A step: Back-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class BackEdgeStep extends AbstractStep implements IStep {

	/**
	 * Single item constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public BackEdgeStep(IEdge edge) {
		super();
		this.description = "Back-edge: " + ((EdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new BackEdgeCommand(edge);
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
	public BackEdgeStep(List<IEdge> edges) {
		super();
		this.description = "Back-edges: ";
		try {
			for (IEdge edge : edges) {
				IItemStateCommand command = new BackEdgeCommand(edge);
				this.stepHandler.addItemStateCommand(command);
				command.execute();
				this.description += ((EdgeLayout) edge).getId() + ", ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
