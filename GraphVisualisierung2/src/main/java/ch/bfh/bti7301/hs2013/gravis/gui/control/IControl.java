package ch.bfh.bti7301.hs2013.gravis.gui.control;

/**
 * A control interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IControl {

	/**
	 * Initializes the control.
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception;

	/**
	 * Constants for different kind of GUI events.
	 * 
	 * @author Patrick Kofmel (kofmp1@bfh.ch)
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum EventSource {
		// i18n
		I18N, DE_DE, FR_FR, EN_US,
		// IO graph
		NEW_GRAPH_UNDIRECTED, NEW_GRAPH_DIRECTED, OPEN_GRAPH, SAVE_GRAPH, SAVE_GRAPH_AS, EDIT_GRAPH,
		// IO algorithm
		IMPORT_ALGORITHM, DELETE_ALGORITHM,
		// parameter
		PARAMETER_CHANGED,
		// player settings
		SET_DELAY, SET_STEPLENGTH,
		// step-by-step
		STEP_BY_STEP, TO_BEGINNING, BACKWARD, FORWARD, TO_END,
		// animation
		ANIMATION, PLAY, PAUSE, RESUME, STOP,
	}

}
