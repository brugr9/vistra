package vistra.core.traversal.step;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.VertexLayout;
import vistra.core.graph.item.state.command.IItemStateCommand;
import vistra.core.graph.item.state.command.SolutionEdgeCommand;
import vistra.core.graph.item.state.command.VisitedVertexCommand;

/**
 * A step: adds a vertex (and an edge) to the solution.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class SolutionVertexStep extends AbstractStep implements IStep {

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge to add to the solution
	 * @param vertex
	 *            the vertex to add to the solution
	 */
	public SolutionVertexStep(IEdge edge, IVertex vertex) {
		super();
		this.description = "Solution member: vertex "
				+ ((VertexLayout) vertex).getId();
		try {
			// new
			IItemStateCommand solutionEdge = new SolutionEdgeCommand(edge);
			IItemStateCommand solutionVertex = new VisitedVertexCommand(vertex);
			// add
			this.stepHandler.addCommand(solutionEdge);
			this.stepHandler.addCommand(solutionVertex);
			// execute
			solutionEdge.execute();
			solutionVertex.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
