package vistra.core.graph.item.state.command;

import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.state.VertexStateHandler;

/**
 * An item-state command: initialise vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class InitVertexCommand extends AbstractItemStateCommand implements
		IItemCommand {

	/**
	 * Main constructor.
	 * 
	 * @param vertex
	 *            a vertex
	 */
	public InitVertexCommand(IVertex vertex) {
		super((VertexStateHandler) vertex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		((VertexStateHandler) super.stateHandler).handleInitialised();
	}

}
