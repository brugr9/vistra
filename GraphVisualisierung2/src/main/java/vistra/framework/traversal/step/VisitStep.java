package vistra.framework.traversal.step;

import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.state.command.DiscoveryEdgeCommand;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.VisitedVertexCommand;

/**
 * A step: visit vertex over edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisitStep extends AbstractStep implements IStep {

	/**
	 * Step: visit vertex via edge.
	 * 
	 * @param vertex
	 *            the vertex to visit
	 * @param edge
	 *            the edge to discover
	 */
	public VisitStep(IVertex vertex, IEdge edge) {
		super();
		try {
			IItemStateCommand edgeCommand = new DiscoveryEdgeCommand(edge);
			IItemStateCommand vertexCommand = new VisitedVertexCommand(vertex);
			this.commandHandler.addCommand(edgeCommand);
			this.commandHandler.addCommand(vertexCommand);
			//
			this.description.append("Vertex "
					+ ((ILayoutVertex) vertex).getId() + " visited");
			if (((ILayoutEdge) edge).getId() != null)
				if (((ILayoutEdge) edge).getId().length() != 0)
					this.description.append(" via edge "
							+ ((ILayoutEdge) edge).getId());
			this.description.append(System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
