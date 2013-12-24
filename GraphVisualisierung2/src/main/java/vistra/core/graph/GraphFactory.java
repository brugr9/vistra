package vistra.core.graph;

import java.util.List;

import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.traversal.step.IStep;
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

	/* Layout */
	public final static float STROKE_WIDTH_DEFAULT = 1.5f;
	public final static float STROKE_WIDTH_BOLD = 3.0f;
	/* vertex */
	public final static double V_HEIGHT_DEFAULT = 40.0;
	public final static double V_WIDTH_DEFAULT = 45.0;
	public final static int V_FONT_SIZE_DEFAULT = 18;
	public final static float V_TAGGED_STROKE = 3.0f;
	/* edge */
	public final static double E_LABEL_CLOSENESS = 0.5;
	public final static int E_FONT_SIZE_DEFAULT = 18;
	public final static float E_DASH_PHASE = 1.0f;
	public final static float[] E_SOLID = null;
	public final static float[] E_DASH_BACK = new float[] { 12.0f, 10.0f };
	public final static float[] E_DASH_FWD = new float[] { 1.0f, 8.0f };
	public final static float[] E_DASH_CROSS = new float[] { 10.0f, 10.0f, 1.0f,
			10.0f };

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
				new SparseGraph<IVertex, IEdge>());
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
				new SparseGraph<IVertex, IEdge>());
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
			GraphEventListener<IVertex, IEdge> listener) {
		ExtendedGraph graph = (ExtendedGraph) create(edgeType);
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
