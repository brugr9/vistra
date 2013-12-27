package vistra.core.graph.event;

import java.util.EventListener;

/**
 * A listener interface on render-graph events.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @param <V>
 *            the type of vertex
 * @param <E>
 *            the type of edge
 */
public interface IRenderGraphEventListener<V, E> extends EventListener {

	/**
	 * Method called by the process generating a render-graph event to which
	 * this instance is listening.
	 */
	void handleRenderGraphEvent(RenderGraphEvent<V, E> evt);

}
