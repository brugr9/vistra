package vistra.framework.traversal.step;

import java.util.List;

import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IEdgeLayout;
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
		try {
			IItemStateCommand command = new BackEdgeCommand(edge);
			this.stepHandler.addItemStateCommand(command);
			command.execute();
			this.description.append("Back-edge ");
			if (((IEdgeLayout) edge).getId().length() != 0)
				this.description.append(((IEdgeLayout) edge).getId());
			this.description.append(System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item constructor.
	 * 
	 * @param edges
	 *            the edges
	 */
	public BackEdgeStep(List<IEdge> edges) {
		super();
		try {
			for (IEdge edge : edges) {
				IItemStateCommand command = new BackEdgeCommand(edge);
				this.stepHandler.addItemStateCommand(command);
				command.execute();
				this.description.append("Back-edge ");
				if (((IEdgeLayout) edge).getId().length() != 0)
					this.description.append(((IEdgeLayout) edge).getId());
				this.description.append(System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
