package vistra.framework.graph;

import java.util.List;

import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IItemLayout;
import vistra.framework.graph.item.IVertexLayout;
import edu.uci.ics.jung.graph.SparseGraph;
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
	 * Creates an undirected {@code IExtendedGraph}.
	 * 
	 * @return the graph
	 */
	public IExtendedGraph create() {
		return create(EdgeType.UNDIRECTED);
	}

	/**
	 * Creates a default JUNG {@code SparseGraph} and extends it to an
	 * {@code IExtendedGraph}.
	 * 
	 * @return the graph
	 */
	public static IExtendedGraph createGraph() {
		IExtendedGraph graph = new ExtendedGraph(
				new SparseGraph<IVertexLayout, IEdgeLayout>());
		return graph;
	}

	/**
	 * Creates an {@code IExtendedGraph} with edge type as given based on a JUNG
	 * {@code SparseGraph}.
	 * 
	 * @param edgeType
	 *            the edge type
	 * @return the graph
	 */
	public static IExtendedGraph create(EdgeType edgeType) {
		IExtendedGraph graph = createGraph();
		graph.setEdgeType(edgeType);
		return graph;
	}

	/**
	 * Converts a list of {@code IItemLayout} to an array.
	 * 
	 * @param list
	 *            the list
	 * @return the array
	 */
	public static IItemLayout[] toArray(List<IItemLayout> list) {
		return list.toArray(new IItemLayout[list.size()]);
	}

}
