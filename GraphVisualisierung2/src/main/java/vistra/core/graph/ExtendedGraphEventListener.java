package vistra.core.graph;

import java.util.List;

import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.core.graph.item.vertex.IVertexLayout;
import vistra.core.traversal.step.IStep;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * A graph event listener for an extended graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ExtendedGraphEventListener implements
		GraphEventListener<IVertexLayout, IEdgeLayout> {

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
	public ExtendedGraphEventListener(List<IStep> stepList) {
		this.stepList = stepList;
	}

	@Override
	public void handleGraphEvent(GraphEvent<IVertexLayout, IEdgeLayout> evt) {
		// TODO Auto-generated method stub

	}

}
