package vistra.core.traversal.step;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.edge.command.DiscoverEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.VertexLayout;
import vistra.core.graph.item.vertex.command.VisitVertex;
import vistra.util.ICommand;

/**
 * A step: visits a vertex over an edge as given.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Visit extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	public Visit(IEdge edge, IVertex vertex) {
		super();

		this.description = this.getClass().getSimpleName() + " "
				+ vertex.getClass().getSimpleName() + " "
				+ ((VertexLayout) vertex).getId();

		try {
			// new
			ICommand discoverEdge = new DiscoverEdge(edge);
			ICommand visitVertex = new VisitVertex(vertex);
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
