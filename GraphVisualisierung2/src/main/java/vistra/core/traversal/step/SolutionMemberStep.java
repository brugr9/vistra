package vistra.core.traversal.step;

import java.util.List;

import vistra.core.graph.item.EdgeLayout;
import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.VertexLayout;
import vistra.core.graph.item.state.command.IItemStateCommand;
import vistra.core.graph.item.state.command.SolutionMemberEdgeCommand;
import vistra.core.graph.item.state.command.SolutionMemberVertexCommand;

/**
 * A step: solution-member. TODO parameter: a map
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
		this.description = "Solution member: vertex "
				+ ((VertexLayout) vertex).getId() + " due to edge "
				+ ((EdgeLayout) edge).getId();
		try {
			IItemStateCommand edgeCommand = new SolutionMemberEdgeCommand(edge);
			IItemStateCommand vertexCommand = new SolutionMemberVertexCommand(
					vertex);
			this.stepHandler.addItemStateCommand(edgeCommand);
			this.stepHandler.addItemStateCommand(vertexCommand);
			edgeCommand.execute();
			vertexCommand.execute();
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
		this.description = "Solution member: ";
		try {
			IEdge edge;
			IVertex vertex;
			for (int index = 0; index < edges.size(); index++) {
				edge = edges.get(index);
				vertex = vertices.get(index);
				IItemStateCommand edgeCommand = new SolutionMemberEdgeCommand(
						edge);
				IItemStateCommand vertexCommand = new SolutionMemberVertexCommand(
						vertex);
				this.stepHandler.addItemStateCommand(edgeCommand);
				this.stepHandler.addItemStateCommand(vertexCommand);
				edgeCommand.execute();
				vertexCommand.execute();
				this.description += "vertex " + ((VertexLayout) vertex).getId()
						+ " due to edge " + ((EdgeLayout) edge).getId();
				if (index < edges.size() - 1)
					this.description += ", ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
