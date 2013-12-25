package vistra.core.graph;

import java.util.List;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.traversal.step.IStep;

/**
 * A graph event listener for a traversable graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class TraversableGraphEventListener implements
		ITraversableGraphEventListener<IVertex, IEdge> {

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

	@Override
	public void handleTraversableGraphEvent(
			TraversableGraphEvent<IVertex, IEdge> evt) {

		IStep step = null;

		switch (evt.type) {
		case VISIT_VERTEX:

			break;

		default:
			break;
		}

		this.stepList.add(step);

	}
}
