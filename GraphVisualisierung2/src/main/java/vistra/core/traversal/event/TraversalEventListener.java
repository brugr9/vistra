package vistra.core.traversal.event;

import java.util.List;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import vistra.core.traversal.step.IStep;

/**
 * A step event listener.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class TraversalEventListener implements
		ITraversalEventListener<IVertex, IEdge> {

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
	public TraversalEventListener(List<IStep> stepList) {
		this.stepList = stepList;
	}

	@Override
	public void handleStepEvent(TraversalEvent<IVertex, IEdge> evt) {

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
