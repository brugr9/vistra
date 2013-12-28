package vistra.core.graph;

import java.util.List;

import vistra.core.graph.TraversableGraphEvent.EdgeVertexEvent;
import vistra.core.graph.TraversableGraphEvent.VerticesEvent;
import vistra.core.traversal.step.BackEdgeStep;
import vistra.core.traversal.step.CrossEdgeStep;
import vistra.core.traversal.step.DiscardedEdgeStep;
import vistra.core.traversal.step.ForwardEdgeStep;
import vistra.core.traversal.step.IStep;
import vistra.core.traversal.step.InitVerticesStep;
import vistra.core.traversal.step.SolutionEdgeStep;
import vistra.core.traversal.step.SolutionVertexStep;
import vistra.core.traversal.step.UpdateVerticesStep;
import vistra.core.traversal.step.VisitVertexStep;

/**
 * A traversable-graph event listener.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class TraversableGraphEventListener implements
		ITraversableGraphEventListener {

	/**
	 * A field for a list of steps.
	 */
	List<IStep> stepList;

	/**
	 * Main constructor.
	 * 
	 * @param stepList
	 *            a list for steps
	 */
	public TraversableGraphEventListener(List<IStep> stepList) {
		this.stepList = stepList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleTraversableGraphEvent(TraversableGraphEvent evt) {

		IStep step = null;

		switch (evt.type) {
		case INIT: {
			VerticesEvent e = (VerticesEvent) evt;
			step = new InitVerticesStep(e.getVertices());
			break;
		}
		case UPDATE: {
			VerticesEvent e = (VerticesEvent) evt;
			step = new UpdateVerticesStep(e.getVertices(), e.getValues());
			break;
		}
		case VISIT: {
			EdgeVertexEvent e = (EdgeVertexEvent) evt;
			step = new VisitVertexStep(e.getEdge(), e.getVertex());
			break;
		}
		case SOLUTION: {
			EdgeVertexEvent e = (EdgeVertexEvent) evt;
			step = new SolutionVertexStep(e.getEdge(), e.getVertex());
			break;
		}
		case BACK_EDGE: {
			EdgeVertexEvent e = (EdgeVertexEvent) evt;
			step = new BackEdgeStep(e.getEdge());
			break;
		}
		case CROSS_EDGE: {
			EdgeVertexEvent e = (EdgeVertexEvent) evt;
			step = new CrossEdgeStep(e.getEdge());
			break;
		}
		case FORWARD_EDGE: {
			EdgeVertexEvent e = (EdgeVertexEvent) evt;
			step = new ForwardEdgeStep(e.getEdge());
			break;
		}
		case DISCARDED_EDGE: {
			EdgeVertexEvent e = (EdgeVertexEvent) evt;
			step = new DiscardedEdgeStep(e.getEdge());
			break;
		}
		case SOLUTION_EDGE: {
			EdgeVertexEvent e = (EdgeVertexEvent) evt;
			step = new SolutionEdgeStep(e.getEdge());
			break;
		}
		default:
			break;
		}

		this.stepList.add(step);

	}
}
