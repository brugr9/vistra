package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEvent;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisGraphEvent extends GraphEvent<IVertex, IEdge> {

	private IGraphItem item;

	/**
	 * 
	 * @param graph
	 * @param item
	 */
	protected GravisGraphEvent(Graph<IVertex, IEdge> graph, IGraphItem item) {
		super(graph, null);
		this.item = item;
	}

	/**
	 * @return IGraphItem
	 */
	public IGraphItem getIGraphItem() {
		return this.item;
	}

}
