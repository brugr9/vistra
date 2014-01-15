package vistra.framework.step;

import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.IVertex;
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
					+ ((ILayoutVertex) s).getId() + " initialised"
					+ System.lineSeparator());
			//
			for (IVertex vertex : i) {
				IItemStateCommand command = new InitialisedVertexCommand(vertex);
				this.commandHandler.addCommand(command);
				//
				this.description.append("Vertex "
						+ ((ILayoutVertex) vertex).getId() + " initialised"
						+ System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
