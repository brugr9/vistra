package vistra.framework.traversal.step;

import java.util.List;

import net.datastructures.Entry;
import net.datastructures.Map;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.SolutionMemberEdgeCommand;
import vistra.framework.graph.item.state.command.SolutionMemberVertexCommand;

/**
 * A step: solution-member edge and vertex. TODO parameter: a map
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class SolutionMemberStep extends AbstractStep implements IStep {

	/**
	 * Single pair of items constructor.
	 * 
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	public SolutionMemberStep(IEdge edge, IVertex vertex) {
		super();
		try {
			//
			IItemStateCommand edgeCommand = new SolutionMemberEdgeCommand(edge);
			IItemStateCommand vertexCommand = new SolutionMemberVertexCommand(
					vertex);
			//
			this.stepHandler.addItemStateCommand(edgeCommand);
			this.stepHandler.addItemStateCommand(vertexCommand);
			//
			// edgeCommand.execute();
			// vertexCommand.execute();
			this.stepHandler.execute();
			//
			this.description.append("Vertex "
					+ ((IVertexLayout) vertex).getId() + ": Solution member ");
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
	public SolutionMemberStep(List<IEdge> edges, List<IVertex> vertices) {
		super();
		try {
			IEdge edge;
			IVertex vertex;
			for (int index = 0; index < edges.size(); index++) {
				edge = edges.get(index);
				vertex = vertices.get(index);
				//
				IItemStateCommand edgeCommand = new SolutionMemberEdgeCommand(
						edge);
				IItemStateCommand vertexCommand = new SolutionMemberVertexCommand(
						vertex);
				//
				this.stepHandler.addItemStateCommand(edgeCommand);
				this.stepHandler.addItemStateCommand(vertexCommand);
				//
				// edgeCommand.execute();
				// vertexCommand.execute();
				this.stepHandler.execute();
				//
				this.description.append("Vertex "
						+ ((IVertexLayout) vertex).getId()
						+ ": Solution member ");
				if (((IEdgeLayout) edge).getId().length() != 0)
					this.description.append(" via edge "
							+ ((IEdgeLayout) edge).getId());
				this.description.append(System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item constructor.
	 * 
	 * @param items
	 *            a map of edges and vertices
	 */
	public SolutionMemberStep(Map<IEdge, IVertex> items) {
		super();
		try {
			IEdge edge;
			IVertex vertex;
			Iterable<Entry<IEdge, IVertex>> entries = items.entrySet();
			for (Entry<IEdge, IVertex> entry : entries) {
				edge = entry.getKey();
				vertex = entry.getValue();
				//
				IItemStateCommand edgeCommand = new SolutionMemberEdgeCommand(
						edge);
				IItemStateCommand vertexCommand = new SolutionMemberVertexCommand(
						vertex);
				//
				this.stepHandler.addItemStateCommand(edgeCommand);
				this.stepHandler.addItemStateCommand(vertexCommand);
				//
				// edgeCommand.execute();
				// vertexCommand.execute();
				this.stepHandler.execute();
				//
				this.description.append("Vertex "
						+ ((IVertexLayout) vertex).getId()
						+ ": Solution member ");
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
