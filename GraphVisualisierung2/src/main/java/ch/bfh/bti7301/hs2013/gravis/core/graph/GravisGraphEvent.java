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

	private IGraphItem item;

	/**
	 * 
	 * @param graph
	 * @param item
	 */
	protected GravisGraphEvent(Graph<IVertex, IEdge> graph, IGraphItem item) {
		super(graph, item instanceof IEdge ? Type.EDGE_ADDED: Type.VERTEX_ADDED);
		this.item = item;
	}

	/**
	 * @return IGraphItem
	 */
	public IGraphItem getIGraphItem() {
		return this.item;
	}

}
