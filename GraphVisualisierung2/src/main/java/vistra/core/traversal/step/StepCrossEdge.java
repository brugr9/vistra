package vistra.core.traversal.step;

import vistra.core.graph.item.EdgeLayout;
import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.state.command.CrossEdgeCommand;
import vistra.core.graph.item.state.command.IItemStateCommand;

/**
 * A cross-edge step.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class StepCrossEdge extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge to mark as cross edge
	 */
	public StepCrossEdge(IEdge edge) {
		super();

		this.description = this.getClass().getSimpleName() + " "
				+ edge.getClass().getSimpleName() + " "
				+ ((EdgeLayout) edge).getId();

		try {
			// new
			IItemStateCommand crossEdge = new CrossEdgeCommand(edge);
			// add
			this.stepHandler.addCommand(crossEdge);
			// execute
			crossEdge.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
