package vistra.core.graph.item.vertex.command;

import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.state.IVertexStateHandler;
import vistra.core.graph.item.vertex.state.VertexStateHandler;
import vistra.util.ICommand;

/**
 * A vertex command: visit vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisitVertex implements ICommand {

	/**
	 * A field for a state handler.
	 */
	private IVertexStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param vertex
	 *            a vertex
	 */
	public VisitVertex(IVertex vertex) {
		this.stateHandler = (VertexStateHandler) vertex;
	}

	@Override
	public void execute() throws Exception {
		this.stateHandler.handleFocussed();
	}

	@Override
	public void undo() throws Exception {
		this.stateHandler.handleVisited();
	}

}
