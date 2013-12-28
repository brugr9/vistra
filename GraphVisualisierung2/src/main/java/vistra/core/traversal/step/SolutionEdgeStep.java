package vistra.core.traversal.step;

import vistra.core.graph.item.EdgeLayout;
import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.state.command.IItemStateCommand;
import vistra.core.graph.item.state.command.SolutionEdgeCommand;

/**
 * A step: Solution-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class SolutionEdgeStep extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public SolutionEdgeStep(IEdge edge) {
		super();
		this.description = "Solution edge " + ((EdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new SolutionEdgeCommand(edge);
			this.stepHandler.addCommand(command);
			command.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
