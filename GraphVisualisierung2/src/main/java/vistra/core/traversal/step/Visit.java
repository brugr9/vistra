package vistra.core.traversal.step;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.edge.command.DiscoverEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.command.VisitVertex;
import vistra.core.traversal.step.handler.IStepHandler;
import vistra.core.traversal.step.handler.VisitStepHandler;
import vistra.util.ICommand;

/**
 * A step: visit.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Visit implements IStep {

	/**
	 * A field for a step handler.
	 */
	private IStepHandler stepHandler;

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	public Visit(IEdge edge, IVertex vertex) {
		this.stepHandler = new VisitStepHandler();
		String description = this.getClass().getSimpleName() + " "
				+ vertex.getId();
		this.stepHandler.setDescription(description);
		try {
			// new
			ICommand discoverEdge = new DiscoverEdge(edge);
			ICommand visitVertex = new VisitVertex(vertex);
			// add
			this.stepHandler.addCommand(discoverEdge);
			this.stepHandler.addCommand(visitVertex);
			// execute
			discoverEdge.execute();
			visitVertex.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		this.stepHandler.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() throws Exception {
		this.stepHandler.undo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return this.stepHandler.getDescription();
	}

}
