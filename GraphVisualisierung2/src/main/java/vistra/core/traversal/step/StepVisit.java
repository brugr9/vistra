package vistra.core.traversal.step;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.VertexLayout;
import vistra.core.graph.item.state.command.DiscoveryEdgeCommand;
import vistra.core.graph.item.state.command.IItemStateCommand;
import vistra.core.graph.item.state.command.VisitedVertexCommand;

/**
 * A step: visits a vertex over an edge as given.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class StepVisit extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	public StepVisit(IEdge edge, IVertex vertex) {
		super();
		this.description = "visit" + " "
				+ vertex.getClass().getSimpleName().toLowerCase() + " "
				+ ((VertexLayout) vertex).getId();
		try {
			// new
			IItemStateCommand discoverEdge = new DiscoveryEdgeCommand(edge);
			IItemStateCommand visitVertex = new VisitedVertexCommand(vertex);
			// add
			this.stepHandler.addCommand(discoverEdge);
			this.stepHandler.addCommand(visitVertex);
			// execute
			discoverEdge.execute();
			visitVertex.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
