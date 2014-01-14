package vistra.framework.graph;

import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.VertexFactory;
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
	 * Creates an undirected {@code ILayoutGraph}.
	 * 
	 * @return the graph
	 */
	public ILayoutGraph create() {
		return create(EdgeType.UNDIRECTED);
	}

	/**
	 * Creates an {@code ILayoutGraph} with edge type as given based on a JUNG
	 * {@code SparseGraph}.
	 * 
	 * @param edgeType
	 *            the edge type
	 * @return the graph
	 */
	public static ILayoutGraph create(EdgeType edgeType) {
		ILayoutGraph graph = createGraph();
		graph.setEdgeType(edgeType);
		return graph;
	}

	/**
	 * Creates a default JUNG {@code SparseGraph} and extends it to an
	 * {@code ILayoutGraph}.
	 * 
	 * @return the graph
	 */
	private static ILayoutGraph createGraph() {
		ILayoutGraph graph = new LayoutGraph(
				new SparseGraph<ILayoutVertex, ILayoutEdge>());
		VertexFactory.resetSigma();
		return graph;
	}

}
