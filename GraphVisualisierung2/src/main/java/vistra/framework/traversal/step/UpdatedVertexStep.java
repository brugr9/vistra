package vistra.framework.traversal.step;

import java.util.List;

import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.UpdatedVertexCommand;

/**
 * A step: updated vertex. TODO parameter: a map
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class UpdatedVertexStep extends AbstractStep implements IStep {

	/**
	 * Single item constructor.
	 * 
	 * @param vertex
	 *            the vertex
	 * @param value
	 *            the values
	 */
	public UpdatedVertexStep(IVertex vertex, String value) {
		super();
		this.description = "Updated vertex: ";
		try {
			IItemStateCommand command = new UpdatedVertexCommand(vertex, value);
			this.stepHandler.addItemStateCommand(command);
			command.execute();
			this.description += vertex + ": " + value;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi items constructor.
	 * 
	 * @param vertices
	 *            the vertices
	 * @param values
	 *            the values
	 */
	public UpdatedVertexStep(List<IVertex> vertices, List<String> values) {
		super();
		this.description = "Updated vertices: ";
		try {
			IVertex vertex;
			String value;
			for (int index = 0; index < vertices.size(); index++) {
				vertex = vertices.get(index);
				value = values.get(index);
				IItemStateCommand command = new UpdatedVertexCommand(vertex,
						value);
				this.stepHandler.addItemStateCommand(command);
				command.execute();
				this.description += vertex + ": " + value;
				if (index < vertices.size() - 1)
					this.description += ", ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
