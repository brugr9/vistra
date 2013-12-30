package vistra.core.traversal.step;

import java.util.List;

import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.item.state.command.IItemStateCommand;
import vistra.core.graph.item.state.command.UpdateVertexCommand;

/**
 * A step: updates vertices.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class UpdateVerticesStep extends AbstractStep implements IStep {

	/**
	 * Main constructor. TODO map as parameter
	 * 
	 * @param vertices
	 *            the vertices to update
	 * @param values
	 *            the values to set
	 */
	public UpdateVerticesStep(List<IVertex> vertices, List<String> values) {
		super();
		this.description = "Update values of vertices: ";
		try {
			for (int i = 0; i < vertices.size(); i++) {
				this.description += ((IVertexLayout) vertices.get(i)).getId();
				if (i < vertices.size() - 1)
					this.description += ", ";
				IItemStateCommand updateVertex = new UpdateVertexCommand(
						(IVertex) vertices.get(i), values.get(i));
				this.stepHandler.addCommand(updateVertex);
				updateVertex.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
