package vistra.core.graph.item.vertex.command;

import vistra.core.graph.item.edge.state.EdgeStateHandler;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.Vertex;
import vistra.core.graph.item.vertex.state.IVertexStateHandler;
import vistra.core.graph.item.vertex.state.VertexStateHandler;
import vistra.util.ICommand;
import vistra.util.IState;

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
	private VertexStateHandler stateHandler;

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
		// TODO if (counter > 0)
		this.stateHandler.handleVisited();
		// else
		// this.stateHandler.handleUnexplored();
	}

}
