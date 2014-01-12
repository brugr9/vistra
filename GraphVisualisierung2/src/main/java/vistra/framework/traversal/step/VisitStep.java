package vistra.framework.traversal.step;

import net.datastructures.Entry;
import net.datastructures.Map;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.VisitedEdgeCommand;
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
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	public VisitStep(IEdge edge, IVertex vertex) {
		super();
		try {
			IItemStateCommand edgeCommand = new VisitedEdgeCommand(edge);
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
	 *            a map of edges and vertices
	 */
	public VisitStep(Map<IEdge, IVertex> items) {
		super();
		try {
			IEdge edge;
			IVertex vertex;
			Iterable<Entry<IEdge, IVertex>> entries = items.entrySet();
			for (Entry<IEdge, IVertex> entry : entries) {
				edge = entry.getKey();
				vertex = entry.getValue();
				//
				IItemStateCommand edgeCommand = new VisitedEdgeCommand(edge);
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
