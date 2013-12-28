package vistra.core.graph;

import java.util.List;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.IVertexLayout;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.event.GraphEventListener;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A graph factory.
 * 
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
	 * Creates a undirected <code>ExtendedGraph</code>.
	 * 
	 * @return the graph
	 */
	public IExtendedGraph create() {
		return create(EdgeType.UNDIRECTED);
	}

	/**
	 * Creates a default JUNG <code>SparseGraph</code> and extends it to a
	 * <code>ExtendedGraph</code>.
	 * 
	 * @return the graph
	 */
	public static IExtendedGraph createGraph() {
		IExtendedGraph graph = new ExtendedGraph(
				new SparseGraph<IVertexLayout, IEdgeLayout>());
		return graph;
	}

	/**
	 * Creates a <code>ExtendedGraph</code> based on a JUNG
	 * <code>SparseGraph</code>.
	 * 
	 * @param edgeType
	 *            an edge type
	 * @return the graph
	 */
	public static IExtendedGraph create(EdgeType edgeType) {
		IExtendedGraph graph = new ExtendedGraph(
				new SparseGraph<IVertexLayout, IEdgeLayout>());
		graph.setEdgeType(edgeType);
		return graph;
	}

	/**
	 * Creates an <code>ExtendedGraph</code> based on a JUNG
	 * <code>SparseGraph</code>.
	 * 
	 * @param edgeType
	 *            an edge type
	 * @param listener
	 *            a listener to add
	 * @return the graph
	 */
	public static IExtendedGraph create(EdgeType edgeType,
			GraphEventListener<IVertexLayout, IEdgeLayout> listener) {
		ExtendedGraph graph = (ExtendedGraph) create(edgeType);
		graph.addGraphEventListener(listener);
		return graph;
	}

	/**
	 * Converts a list of into an array
	 * 
	 * @param list
	 *            the list
	 * @return the array
	 */
	public static IItemLayout[] toArray(List<IItemLayout> list) {
		return list.toArray(new IItemLayout[list.size()]);
	}

}
