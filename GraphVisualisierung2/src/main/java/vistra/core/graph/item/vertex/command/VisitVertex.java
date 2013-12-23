package vistra.core.graph.item.vertex.command;

import vistra.core.graph.item.AbstractItemCommand;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.state.VertexStateHandler;
import vistra.util.ICommand;

/**
 * A vertex command: visit vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisitVertex extends AbstractItemCommand implements ICommand {

	/**
	 * Main constructor.
	 * 
	 * @param vertex
	 *            a vertex
	 */
	public VisitVertex(IVertex vertex) {
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
