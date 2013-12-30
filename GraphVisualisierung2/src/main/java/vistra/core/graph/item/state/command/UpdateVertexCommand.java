package vistra.core.graph.item.state.command;

import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.state.VertexStateHandler;

/**
 * An item-state command: update vertex value.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class UpdateVertexCommand extends AbstractItemStateCommand implements
		IItemStateCommand {

	/**
	 * A field for a value.
	 */
	String value;

	/**
	 * Main constructor.
	 * 
	 * @param vertex
	 *            a vertex
	 * @param value
	 *            a value
	 */
	public UpdateVertexCommand(IVertex vertex, String value) {
		super((VertexStateHandler) vertex);
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		((VertexStateHandler) super.stateHandler).handleUpdated(this.value);
	}

}
