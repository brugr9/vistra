package vistra.framework.step;

import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.state.command.ForwardEdgeCommand;
import vistra.framework.graph.item.state.command.IItemStateCommand;

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
		try {
			IItemStateCommand command = new ForwardEdgeCommand(edge);
			this.commandHandler.addCommand(command);
			//
			this.description.append("Forward-edge ");
			if (((IEdgeLayout) edge).getId() != null)
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
	public ForwardEdgeStep(Iterable<IEdge> edges) {
		super();
		try {
			for (IEdge edge : edges) {
				IItemStateCommand command = new ForwardEdgeCommand(edge);
				this.commandHandler.addCommand(command);
				//
				this.description.append("Forward-edge ");
				if (((IEdgeLayout) edge).getId() != null)
					if (((IEdgeLayout) edge).getId().length() != 0)
						this.description.append(((IEdgeLayout) edge).getId());
				this.description.append(System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
