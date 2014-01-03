package vistra.core.traversal.step;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.item.state.command.DiscoveryEdgeCommand;
import vistra.core.graph.item.state.command.IItemStateCommand;
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
		this.description = "Visit vertex " + ((IVertexLayout) vertex).getId();
		try {
			// new
			IItemStateCommand discoveryEdge = new DiscoveryEdgeCommand(edge);
			IItemStateCommand visitedVertex = new VisitedVertexCommand(vertex);
			// add
			this.stepHandler.addItemStateCommand(discoveryEdge);
			this.stepHandler.addItemStateCommand(visitedVertex);
			// execute
			discoveryEdge.execute();
			visitedVertex.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
