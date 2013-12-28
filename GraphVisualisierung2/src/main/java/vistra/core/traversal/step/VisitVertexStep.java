package vistra.core.traversal.step;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.VertexLayout;
import vistra.core.graph.item.state.command.DiscoveryEdgeCommand;
import vistra.core.graph.item.state.command.IItemCommand;
import vistra.core.graph.item.state.command.VisitedVertexCommand;

/**
 * A step: visits a vertex over an edge as given.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisitVertexStep extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	public VisitVertexStep(IEdge edge, IVertex vertex) {
		super();
		this.description = "Visit" + " "
				+ vertex.getClass().getSimpleName().toLowerCase() + " "
				+ ((VertexLayout) vertex).getId();
		try {
			// new
			IItemCommand discoveryEdge = new DiscoveryEdgeCommand(edge);
			IItemCommand visitedVertex = new VisitedVertexCommand(vertex);
			// add
			this.stepHandler.addCommand(discoveryEdge);
			this.stepHandler.addCommand(visitedVertex);
			// execute
			discoveryEdge.execute();
			visitedVertex.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
