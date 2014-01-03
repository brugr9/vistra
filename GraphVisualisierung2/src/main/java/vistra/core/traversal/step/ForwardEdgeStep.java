package vistra.core.traversal.step;

import java.util.List;

import vistra.core.graph.item.EdgeLayout;
import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.state.command.ForwardEdgeCommand;
import vistra.core.graph.item.state.command.IItemStateCommand;

/**
 * A step: Forward-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ForwardEdgeStep extends AbstractStep implements IStep {

	/**
	 * Single item constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public ForwardEdgeStep(IEdge edge) {
		super();
		this.description = "Forward-edge: " + ((EdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new ForwardEdgeCommand(edge);
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
	public ForwardEdgeStep(List<IEdge> edges) {
		super();
		this.description = "Forward-edges: ";
		try {
			for (IEdge edge : edges) {
				IItemStateCommand command = new ForwardEdgeCommand(edge);
				this.stepHandler.addItemStateCommand(command);
				command.execute();
				this.description += ((EdgeLayout) edge).getId() + ", ";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
