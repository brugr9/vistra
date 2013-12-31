package vistra.core.traversal.step;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IEdgeLayout;
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
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public ForwardEdgeStep(IEdge edge) {
		super();
		this.description = "Forward-edge " + ((IEdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new ForwardEdgeCommand(edge);
			this.stepHandler.addCommand(command);
			command.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
