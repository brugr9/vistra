package vistra.core.graph.zobsolete;

import vistra.core.graph.zobsolete.item.IGraphItem;
import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * An interface for a observable graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IObservableGraph extends IGravisGraph,
		IGraphItemUpdate<IGraphItem> {

	/**
	 * Adds a graph event listener.
	 * 
	 * @param listener
	 *            the graph event listener
	 */
	public abstract void addGraphEventListener(
			GraphEventListener<IVertex, IEdge> listener);

	/**
	 * Removes a graph event listener.
	 * 
	 * @param listener
	 *            the graph event listener
	 */
	public abstract void removeGraphEventListener(
			GraphEventListener<IVertex, IEdge> listener);

}