package vistra.framework.traversal.step;

import java.util.List;

import net.datastructures.Entry;
import net.datastructures.Map;
import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.UpdatedVertexCommand;

/**
 * A step: updated vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class UpdatedVertexStep extends AbstractStep implements IStep {

	/**
	 * Single item / single value constructor.
	 * 
	 * @param vertex
	 *            the vertex
	 * @param value
	 *            the values
	 */
	public UpdatedVertexStep(IVertex vertex, String value) {
		super();
		try {
			IItemStateCommand command = new UpdatedVertexCommand(vertex, value);
			this.commandHandler.addCommand(command);
			// command.execute();
			this.commandHandler.execute();
			//
			this.description.append("Vertex "
					+ ((IVertexLayout) vertex).getId() + ", value updated to "
					+ value + System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item / single value constructor.
	 * 
	 * @param vertices
	 *            the vertices
	 * @param value
	 *            a value
	 */
	public UpdatedVertexStep(Iterable<IVertex> vertices, String value) {
		super();
		try {
			for (IVertex vertex : vertices) {
				IItemStateCommand command = new UpdatedVertexCommand(vertex,
						value);
				this.commandHandler.addCommand(command);
				// command.execute();
				this.commandHandler.execute();
				this.description.append("Vertex "
						+ ((IVertexLayout) vertex).getId()
						+ ", value updated to " + value
						+ System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item / multi value constructor.
	 * 
	 * @param vertices
	 *            the vertices
	 * @param values
	 *            the values
	 */
	public UpdatedVertexStep(List<IVertex> vertices, List<String> values) {
		super();
		try {
			IVertex vertex;
			String value;
			for (int index = 0; index < vertices.size(); index++) {
				vertex = vertices.get(index);
				value = values.get(index);
				IItemStateCommand command = new UpdatedVertexCommand(vertex,
						value);
				this.commandHandler.addCommand(command);
				// command.execute();
				this.commandHandler.execute();
				this.description.append("Vertex "
						+ ((IVertexLayout) vertex).getId()
						+ ", value updated to " + value
						+ System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item / multi value constructor.
	 * 
	 * @param items
	 *            a map of vertices and values
	 */
	public UpdatedVertexStep(Map<IVertex, String> items) {
		super();
		try {
			IVertex vertex;
			String value;
			Iterable<Entry<IVertex, String>> entries = items.entrySet();
			for (Entry<IVertex, String> entry : entries) {
				vertex = entry.getKey();
				value = entry.getValue();
				IItemStateCommand command = new UpdatedVertexCommand(vertex,
						value);
				this.commandHandler.addCommand(command);
				// command.execute();
				this.commandHandler.execute();
				this.description.append("Vertex "
						+ ((IVertexLayout) vertex).getId()
						+ ", value updated to " + value
						+ System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
