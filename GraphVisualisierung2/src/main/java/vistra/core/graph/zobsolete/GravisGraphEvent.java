package vistra.core.graph.zobsolete;

import vistra.core.graph.zobsolete.item.IGraphItem;
import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEvent;

/**
 * An adapted JUNG graph event.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class GravisGraphEvent extends GraphEvent<IVertex, IEdge> {

	/**
	 * A field for the graph items.
	 */
	private IGraphItem[] items;

	/**
	 * Main constructor.
	 * 
	 * @param graph
	 *            a graph
	 * @param items
	 *            the graph items
	 */
	public GravisGraphEvent(Graph<IVertex, IEdge> graph, IGraphItem[] items) {
		super(graph, null);

		this.items = items;
	}

	/**
	 * Returns the graph items.
	 * 
	 * @return the graph items
	 */
	public IGraphItem[] getGraphItems() {
		return this.items;
	}

}
