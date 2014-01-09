package vistra.framework.traversal.step;

import java.util.List;

import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.state.command.DiscardedEdgeCommand;
import vistra.framework.graph.item.state.command.IItemStateCommand;

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
		try {
			IItemStateCommand command = new DiscardedEdgeCommand(edge);
			this.stepHandler.addItemStateCommand(command);
			// command.execute();
			this.stepHandler.execute();
			this.description.append("Edge ");
			if (((IEdgeLayout) edge).getId().length() != 0)
				this.description.append(((IEdgeLayout) edge).getId() + " ");
			this.description.append("discarded" + System.lineSeparator());
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
		try {
			for (IEdge edge : edges) {
				IItemStateCommand command = new DiscardedEdgeCommand(edge);
				this.stepHandler.addItemStateCommand(command);
				// command.execute();
				this.stepHandler.execute();
				this.description.append("Edge ");
				if (((IEdgeLayout) edge).getId().length() != 0)
					this.description.append(((IEdgeLayout) edge).getId() + " ");
				this.description.append("discarded" + System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
