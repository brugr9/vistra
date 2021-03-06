package vistra.framework.traversal.step;

import net.datastructures.Entry;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.UpdatedVertexCommand;

/**
 * A step: updated vertex.
 * 
 * The integer values get parsed to string.
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
	public UpdatedVertexStep(IVertex vertex, Integer value) {
		super();
		try {
			IItemStateCommand command = new UpdatedVertexCommand(vertex,
					value.toString());
			this.commandHandler.addCommand(command);
			//
			this.description.append("Vertex "
					+ ((ILayoutVertex) vertex).getId() + ", value updated to "
					+ value + System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item / multi value constructor.
	 * 
	 * @param u
	 *            the vertices to update with a value as given
	 */
	public UpdatedVertexStep(Entry<Integer, IVertex> u) {
		super();
		try {
			Integer value = u.getKey();
			IVertex vertex = u.getValue();
			IItemStateCommand command = new UpdatedVertexCommand(vertex,
					value.toString());
			this.commandHandler.addCommand(command);
			this.description.append("Vertex "
					+ ((ILayoutVertex) vertex).getId() + ", value updated to "
					+ value + System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
