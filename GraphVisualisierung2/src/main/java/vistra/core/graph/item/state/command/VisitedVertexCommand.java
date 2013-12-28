package vistra.core.graph.item.state.command;

import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.state.VertexStateHandler;

/**
 * An item-state command: visited vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisitedVertexCommand extends AbstractItemStateCommand implements
		IItemCommand {

	/**
	 * Main constructor.
	 * 
	 * @param vertex
	 *            a vertex
	 */
	public VisitedVertexCommand(IVertex vertex) {
		super((VertexStateHandler) vertex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		((VertexStateHandler) super.stateHandler).handleFocussed();
	}

}
