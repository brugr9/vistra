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
		I18N("i18n"),
		// IO graph
		GRAPH("graph"),
		//
		NEW_UNDIRECTED("newUndirected"),
		//
		NEW_DIRECTED("newDirected"),
		//
		OPEN("open"),
		//
		SAVE("save"),
		//
		SAVE_AS("saveAs"),

		// edit
		MODE("mode"),
		//
		EDIT("edit"),
		//
		START("start"),
		//
		END("end"),
		//
		DELETE("delete"),

		// algorithm
		ALGORITHM("algorithm"),
		// player settings
		DELAY("delay"),
		//
		STEPLENGTH("steplenth"),
		// step-by-step
		STEP_BY_STEP("stepByStep"),
		//
		TO_BEGINNING("toBeginning"),
		//
		BACKWARD("backward"),
		//
		FORWARD("forward"),
		//
		TO_END("toEnd"),
		// animation
		ANIMATION("animation"),
		//
		PLAY("play"),
		//
		PAUSE("pause"),
		//
		RESUME("resume"),
		//
		STOP("stop"),

		;

		/**
		 * A field for a value.
		 */
		private String value;

		/**
		 * Main constructor.
		 * 
		 * @param value
		 *            a value
		 */
		EventSource(String value) {
			this.value = value;
		}

		/**
		 * Returns the value.
		 * 
		 * @return the value
		 */
		public String getValue() {
			return this.value;
		}

	}

}
