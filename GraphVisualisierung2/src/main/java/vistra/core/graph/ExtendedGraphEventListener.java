package vistra.core.graph;

import java.util.List;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.traversal.IStep;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * A graph event listener for an extended graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ExtendedGraphEventListener implements
		GraphEventListener<IVertex, IEdge> {

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
	public void handleGraphEvent(GraphEvent<IVertex, IEdge> evt) {
		// TODO Auto-generated method stub

	}

}
