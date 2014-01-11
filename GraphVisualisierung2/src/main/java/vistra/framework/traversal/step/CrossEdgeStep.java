package vistra.framework.traversal.step;

import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IEdgeLayout;
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
		try {
			IItemStateCommand command = new CrossEdgeCommand(edge);
			this.commandHandler.addCommand(command);
			//
			this.description.append("Cross-edge ");
			if (((IEdgeLayout) edge).getId().length() != 0)
				this.description.append(((IEdgeLayout) edge).getId());
			this.description.append(System.lineSeparator());
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
	public CrossEdgeStep(Iterable<IEdge> edges) {
		super();
		try {
			for (IEdge edge : edges) {
				IItemStateCommand command = new CrossEdgeCommand(edge);
				this.commandHandler.addCommand(command);
				//
				this.description.append("Cross-edge ");
				if (((IEdgeLayout) edge).getId().length() != 0)
					this.description.append(((IEdgeLayout) edge).getId());
				this.description.append(System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
