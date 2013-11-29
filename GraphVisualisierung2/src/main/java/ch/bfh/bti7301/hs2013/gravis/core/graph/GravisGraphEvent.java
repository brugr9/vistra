package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEvent;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisGraphEvent extends GraphEvent<IVertex, IEdge> {

	private IGraphItem[] items;
	
	/**
	 * 
	 * @param graph
	 * @param items
	 */
	protected GravisGraphEvent(Graph<IVertex, IEdge> graph, IGraphItem[] items) {
		super(graph, null);
		
		this.items = items;
	}

	/**
	 * @return IGraphItem
	 */
	public IGraphItem[] getGraphItems() {
		return this.items;
	}
	
}
