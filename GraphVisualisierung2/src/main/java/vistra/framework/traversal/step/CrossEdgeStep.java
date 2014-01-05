package vistra.framework.traversal.step;

import java.util.List;

import vistra.framework.graph.item.EdgeLayout;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.state.command.CrossEdgeCommand;
import vistra.framework.graph.item.state.command.IItemStateCommand;

/**
 * A step: Cross-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class CrossEdgeStep extends AbstractStep implements IStep {

	/**
	 * Single item constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public CrossEdgeStep(IEdge edge) {
		super();
		this.description = "Cross-edge: " + ((EdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new CrossEdgeCommand(edge);
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
	public CrossEdgeStep(List<IEdge> edges) {
		super();
		this.description = "Cross-edges: ";
		try {
			for (IEdge edge : edges) {
				IItemStateCommand command = new CrossEdgeCommand(edge);
				this.stepHandler.addItemStateCommand(command);
				command.execute();
				this.description += ((EdgeLayout) edge).getId() + ", ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
