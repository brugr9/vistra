package vistra.core.graph;

import java.util.List;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.traversal.IStep;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * A graph factory.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GraphFactory {

	/**
	 * A main (no-)constructor.
	 */
	private GraphFactory() {
	}

	/**
	 * Creates an <code>ExtendedGraph</code> based on a JUNG
	 * <code>SparseGraph</code>.
	 * 
	 * @return the graph
	 */
	public static IExtendedGraph create() {
		return new ExtendedGraph(new SparseGraph<IVertex, IEdge>());
	}

	/**
	 * Creates an <code>ExtendedGraph</code> based on a JUNG
	 * <code>SparseGraph</code>.
	 * 
	 * @param listener
	 *            a listener to add
	 * @return the graph
	 */
	public static IExtendedGraph create(
			GraphEventListener<IVertex, IEdge> listener) {
		ExtendedGraph graph = (ExtendedGraph) create();
		graph.addGraphEventListener(listener);
		return graph;
	}

	/**
	 * Creates a <code>GraphEventListener</code>.
	 * 
	 * @param stepList
	 *            a list for steps
	 * @return the listener
	 */
	public static GraphEventListener<IVertex, IEdge> createListener(
			List<IStep> stepList) {
		return new ExtendedGraphEventListener(stepList);
	}

}
