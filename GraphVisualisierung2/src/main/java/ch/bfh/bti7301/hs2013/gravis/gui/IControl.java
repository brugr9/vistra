/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui;

/**
 * A control as in MVC.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IControl {

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
		IMPORT_GRAPH, DELETE_GRAPH,
		// IO algorithm
		IMPORT_ALGORITHM, DELETE_ALGORITHM,
		// player settings
		SET_DELAY, SET_STEP,
		// player
		GOTO_BEGINNING, BACKWARD, FORWARD, GOTO_END, PLAY, PAUSE, RESUME, STOP,
	}

}
