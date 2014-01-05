package vistra.framework.traversal.step;

import java.util.List;

import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.VisitedEdgeCommand;
import vistra.framework.graph.item.state.command.VisitedVertexCommand;

/**
 * A step: visit vertex over edge. TODO parameter: a map
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisitStep extends AbstractStep implements IStep {

	/**
	 * Single pair of items constructor.
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
			this.stepHandler.addItemStateCommand(edgeCommand);
			this.stepHandler.addItemStateCommand(vertexCommand);
			edgeCommand.execute();
			vertexCommand.execute();
			this.description.append("Vertex "
					+ ((IVertexLayout) vertex).getId() + " visited");
			if (((IEdgeLayout) edge).getId().length() != 0)
				this.description.append(" via edge "
						+ ((IEdgeLayout) edge).getId());
			this.description.append(System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi pair of items constructor.
	 * 
	 * @param edges
	 *            the edges to discover
	 * @param vertices
	 *            the vertices to visit
	 */
	public VisitStep(List<IEdge> edges, List<IVertex> vertices) {
		super();
		try {
			IEdge edge;
			IVertex vertex;
			for (int index = 0; index < edges.size(); index++) {
				edge = edges.get(index);
				vertex = vertices.get(index);
				//
				IItemStateCommand edgeCommand = new VisitedEdgeCommand(edge);
				IItemStateCommand vertexCommand = new VisitedVertexCommand(
						vertex);
				//
				this.stepHandler.addItemStateCommand(edgeCommand);
				this.stepHandler.addItemStateCommand(vertexCommand);
				//
				edgeCommand.execute();
				vertexCommand.execute();
				//
				this.description.append("Vertex "
						+ ((IVertexLayout) vertex).getId() + " visited");
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
