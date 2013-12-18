package vistra.core.graph;

import vistra.core.graph.item.IGraphItem;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * An observable gravis graph interface.
 * 
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