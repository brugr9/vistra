package vistra.core.traversal.step;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.state.command.CrossEdgeCommand;
import vistra.core.graph.item.state.command.IItemStateCommand;

/**
 * A step: Cross-edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class CrossEdgeStep extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge
	 */
	public CrossEdgeStep(IEdge edge) {
		super();
		this.description = "Cross-edge " + ((IEdgeLayout) edge).getId();
		try {
			IItemStateCommand command = new CrossEdgeCommand(edge);
			this.stepHandler.addItemStateCommand(command);
			command.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
