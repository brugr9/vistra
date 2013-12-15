package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
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
