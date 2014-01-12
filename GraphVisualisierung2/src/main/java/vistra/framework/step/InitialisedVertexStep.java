package vistra.framework.step;

import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.InitialisedVertexCommand;

/**
 * A step: initialized vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class InitialisedVertexStep extends AbstractStep implements IStep {

	/**
	 * Single item constructor.
	 * 
	 * @param vertex
	 *            the vertex
	 */
	public InitialisedVertexStep(IVertex vertex) {
		super();
		try {
			IItemStateCommand command = new InitialisedVertexCommand(vertex);
			this.commandHandler.addCommand(command);
			//
			this.description.append("Vertex "
					+ ((IVertexLayout) vertex).getId() + " initialised"
					+ System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item constructor.
	 * 
	 * @param vertices
	 *            the vertices
	 */
	public InitialisedVertexStep(Iterable<IVertex> vertices) {
		super();
		try {
			for (IVertex vertex : vertices) {
				IItemStateCommand command = new InitialisedVertexCommand(vertex);
				this.commandHandler.addCommand(command);
				//
				this.description.append("Vertex "
						+ ((IVertexLayout) vertex).getId() + " initialised"
						+ System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}