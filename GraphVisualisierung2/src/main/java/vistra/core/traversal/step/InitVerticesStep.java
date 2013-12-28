package vistra.core.traversal.step;

import java.util.List;

import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.state.command.IItemCommand;
import vistra.core.graph.item.state.command.InitVertexCommand;

/**
 * A step: initialises vertices.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class InitVerticesStep extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param vertices
	 *            the vertices to initialise
	 */
	public InitVerticesStep(List<IVertex> vertices) {
		super();
		this.description = "Initialise vertices.";
		try {
			for (IVertex vertex : vertices) {
				IItemCommand initVertex = new InitVertexCommand(vertex);
				this.stepHandler.addCommand(initVertex);
				initVertex.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
