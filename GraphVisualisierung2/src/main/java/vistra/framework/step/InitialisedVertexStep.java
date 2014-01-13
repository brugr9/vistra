package vistra.framework.step;

import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.graph.item.state.command.InitialisedVertexCommand;
import vistra.framework.graph.item.state.command.SolutionMemberVertexCommand;
import vistra.framework.graph.item.state.command.UpdatedVertexCommand;

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
	 * @param i
	 *            the vertex
	 * @deprecated
	 */
	public InitialisedVertexStep(IVertex i) {
		super();
		try {
			IItemStateCommand command = new InitialisedVertexCommand(i);
			this.commandHandler.addCommand(command);
			//
			this.description.append("Vertex " + ((IVertexLayout) i).getId()
					+ " initialised" + System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Multi item constructor.
	 * 
	 * @param i
	 *            the vertices
	 * @deprecated
	 */
	public InitialisedVertexStep(Iterable<IVertex> i) {
		super();
		try {
			for (IVertex vertex : i) {
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

	/**
	 * Multi item constructor.
	 * 
	 * @param s
	 *            the start vertex
	 * @param i
	 *            the other vertices
	 */
	public InitialisedVertexStep(IVertex s, Iterable<IVertex> i) {
		super();
		try {
			IItemStateCommand startCommand = new UpdatedVertexCommand(s, "0");
			this.commandHandler.addCommand(startCommand);
			IItemStateCommand solutionMember = new SolutionMemberVertexCommand(
					s);
			this.commandHandler.addCommand(solutionMember);
			this.description.append("Start vertex "
					+ ((IVertexLayout) s).getId() + " initialised"
					+ System.lineSeparator());
			//
			for (IVertex vertex : i) {
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
