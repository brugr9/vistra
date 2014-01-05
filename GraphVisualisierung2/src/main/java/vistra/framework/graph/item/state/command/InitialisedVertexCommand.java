package vistra.framework.graph.item.state.command;

import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.state.VertexStateHandler;

/**
 * An item-state command: initialised vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class InitialisedVertexCommand extends AbstractItemStateCommand
		implements IItemStateCommand {

	/**
	 * Main constructor.
	 * 
	 * @param vertex
	 *            a vertex
	 */
	public InitialisedVertexCommand(IVertex vertex) {
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
