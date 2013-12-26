package vistra.core.traversal.step;

import vistra.core.graph.item.edge.EdgeLayout;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.edge.command.CrossEdgeCommand;
import vistra.util.ICommand;

/**
 * A step: marks an edge as cross edge.
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
			ICommand crossEdge = new CrossEdgeCommand(edge);
			// add
			this.stepHandler.addCommand(crossEdge);
			// execute
			crossEdge.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
