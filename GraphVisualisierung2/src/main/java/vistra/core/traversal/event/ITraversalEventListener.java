package vistra.core.traversal.event;

import java.util.EventListener;

/**
 * A listener interface on step events.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @param <V>
 *            the type of vertex
 * @param <E>
 *            the type of edge
 */
public interface ITraversalEventListener<V, E> extends EventListener {

	/**
	 * Method called by the process generating a step event to which this
	 * instance is listening.
	 */
	void handleStepEvent(TraversalEvent<V, E> evt);

}
