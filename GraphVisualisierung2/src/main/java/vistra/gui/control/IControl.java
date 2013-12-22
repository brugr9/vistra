package vistra.gui.control;

/**
 * A control interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IControl {

	/**
	 * A field for a second (in milliseconds).
	 */
	public final static int A_SECOND = 1000;

	/**
	 * Constants for different kind of GUI events.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum EventSource {
		// i18n
		I18N, DE_DE, FR_FR, EN_US,
		// IO graph
		GRAPH, NEW_GRAPH_UNDIRECTED, NEW_GRAPH_DIRECTED, OPEN_GRAPH, SAVE_GRAPH, SAVE_GRAPH_AS, EDIT_GRAPH,
		// IO algorithm
		ALGORITHM,
		// player settings
		DELAY, STEPLENGTH,
		// step-by-step
		STEP_BY_STEP, TO_BEGINNING, BACKWARD, FORWARD, TO_END,
		// animation
		ANIMATION, PLAY, PAUSE, RESUME, STOP,
	}

	/**
	 * Initialises the control.
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception;

}
