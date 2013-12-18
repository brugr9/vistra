package vistra.core.graph;

import vistra.core.graph.item.IGraphItem;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEvent;

/**
 * A JUNG graph event adapted for GRAVIS.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisGraphEvent extends GraphEvent<IVertex, IEdge> {

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
	protected GravisGraphEvent(Graph<IVertex, IEdge> graph, IGraphItem[] items) {
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
