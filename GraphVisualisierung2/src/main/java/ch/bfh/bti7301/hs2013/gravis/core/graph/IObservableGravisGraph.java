package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IObservableGravisGraph extends IGravisGraph,
		IGraphItemUpdate<IGraphItem> {

	/**
	 * 
	 * @param listener
	 */
	public abstract void addGraphEventListener(
			GraphEventListener<IVertex, IEdge> listener);

	/**
	 * 
	 * @param listener
	 */
	public abstract void removeGraphEventListener(
			GraphEventListener<IVertex, IEdge> listener);

}