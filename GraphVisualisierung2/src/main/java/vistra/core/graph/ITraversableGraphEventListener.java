package vistra.core.graph;

import java.util.EventListener;

/**
 * An interface for classes that listen for traversable-graph events.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @param <V>
 *            the type of vertex
 * @param <E>
 *            the type of edge
 */
public interface ITraversableGraphEventListener<V, E> extends EventListener {

	/**
	 * Method called by the process generating a traversable-graph event to
	 * which this instance is listening.
	 */
	void handleTraversableGraphEvent(TraversableGraphEvent<V, E> evt);

}
