package vistra.framework.traversal.step;

import net.datastructures.Entry;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.SolutionMemberEdgeCommand;
import vistra.framework.graph.item.state.command.SolutionMemberVertexCommand;

/**
 * A step: solution-member edge and vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class SolutionMemberStep extends AbstractStep implements IStep {

	/**
	 * Single items constructor.
	 * 
	 * @param vertex
	 *            a vertex
	 */
	public SolutionMemberStep(IVertex vertex) {
		super();
		try {
			IItemStateCommand vertexCommand = new SolutionMemberVertexCommand(
					vertex);
			this.commandHandler.addCommand(vertexCommand);
			this.description.append("Vertex "
					+ ((ILayoutVertex) vertex).getId() + ": Solution member");
			this.description.append(System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Single pair of items constructor.
	 * 
	 * @param vertex
	 *            a vertex
	 * @param edge
	 *            an edge
	 */
	public SolutionMemberStep(IVertex vertex, IEdge edge) {
		super();
		try {
			//
			IItemStateCommand edgeCommand = new SolutionMemberEdgeCommand(edge);
			IItemStateCommand vertexCommand = new SolutionMemberVertexCommand(
					vertex);
			//
			this.commandHandler.addCommand(edgeCommand);
			this.commandHandler.addCommand(vertexCommand);
			//
			this.description.append("Vertex "
					+ ((ILayoutVertex) vertex).getId() + ": Solution member");
			this.description.append(System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item constructor.
	 * 
	 * @param items
	 *            the edges and the vertices
	 */
	public SolutionMemberStep(Iterable<Entry<IVertex, IEdge>> items) {
		super();
		try {
			IEdge edge;
			IVertex vertex;
			for (Entry<IVertex, IEdge> entry : items) {
				vertex = entry.getKey();
				edge = entry.getValue();
				//
				IItemStateCommand edgeCommand = new SolutionMemberEdgeCommand(
						edge);
				IItemStateCommand vertexCommand = new SolutionMemberVertexCommand(
						vertex);
				//
				this.commandHandler.addCommand(edgeCommand);
				this.commandHandler.addCommand(vertexCommand);
				//
				this.description.append("Vertex "
						+ ((ILayoutVertex) vertex).getId()
						+ ": Solution member");
				this.description.append(System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
