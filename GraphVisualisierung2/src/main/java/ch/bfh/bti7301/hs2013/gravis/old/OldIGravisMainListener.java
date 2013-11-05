package ch.bfh.bti7301.hs2013.gravis.old;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Observer;

/**
 * A tagging interface that extends all necessary listener interfaces used by ui
 * events.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @deprecated
 */
public interface OldIGravisMainListener extends ActionListener, ItemListener,
		OldIGravisObservable, Observer {

	/**
	 * This enum constants are usefull to distinguish between different kinds of
	 * ui events.
	 * 
	 * @author Patrick Kofmel (kofmp1@bfh.ch)
	 * 
	 */
	public enum EventSource {
		IMPORT_GRAPH, IMPORT_ALGORITHM, SELECT_GRAPH, SELECT_ALGORITHM, START_PROCESSING, DELETE_GRAPH, DELETE_ALGORITHM, SAVE_GRAPH, EXPORT_GRAPH, EXIT_APPLICATION, PLAY_ANIMATION, PAUSE_ANIMATION, STOP_ANIMATION, BEGINNING_ANIMATION, END_ANIMATION, FORWARD_ANIMATION, BACKWARD_ANIMATION, TIME_INTERVALL, STEP_INCREMENT
	}
}
