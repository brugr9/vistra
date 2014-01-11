package vistra.framework.graph.item.state.command;

import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.state.EdgeStateHandler;

/**
 * An item-state command: solution-member edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class SolutionMemberEdgeCommand extends AbstractItemStateCommand implements
		IItemStateCommand {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            an edge
	 */
	public SolutionMemberEdgeCommand(IEdge edge) {
		super((EdgeStateHandler) edge);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		((EdgeStateHandler) super.itemStateHandler).handleSolution();
	}

}
