package vistra.framework.step;

import net.datastructures.Entry;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.DiscoveryEdgeCommand;
import vistra.framework.graph.item.state.command.VisitedVertexCommand;

/**
 * A step: visit vertex over edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisitStep extends AbstractStep implements IStep {

	/**
	 * Single pair of items constructor, visit vertex via edge.
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
					+ ((IVertexLayout) vertex).getId() + " visited");
			if (((IEdgeLayout) edge).getId() != null)
				if (((IEdgeLayout) edge).getId().length() != 0)
					this.description.append(" via edge "
							+ ((IEdgeLayout) edge).getId());
			this.description.append(System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item constructor, visit vertex via edge.
	 * 
	 * @param items
	 *            the edges and vertices to visit
	 */
	public VisitStep(Iterable<Entry<IVertex, IEdge>> items) {
		super();
		try {
			IEdge edge;
			IVertex vertex;
			for (Entry<IVertex, IEdge> entry : items) {
				vertex = entry.getKey();
				edge = entry.getValue();
				//
				IItemStateCommand edgeCommand = new DiscoveryEdgeCommand(edge);
				IItemStateCommand vertexCommand = new VisitedVertexCommand(
						vertex);
				this.commandHandler.addCommand(edgeCommand);
				this.commandHandler.addCommand(vertexCommand);
				//
				this.description.append("Vertex "
						+ ((IVertexLayout) vertex).getId() + " visited");
				if (((IEdgeLayout) edge).getId() != null)
					if (((IEdgeLayout) edge).getId().length() != 0)
						this.description.append(" via edge "
								+ ((IEdgeLayout) edge).getId());
				this.description.append(System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
