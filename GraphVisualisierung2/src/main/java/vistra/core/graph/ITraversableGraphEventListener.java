package vistra.core.graph;

import java.util.EventListener;

/**
 * A traversable graph event listener interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ITraversableGraphEventListener extends EventListener {

	/**
	 * Method called by the process generating a traversable graph event to
	 * which this instance is listening.
	 */
	void handleTraversableGraphEvent(TraversableGraphEvent evt);

}
