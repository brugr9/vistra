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
		NEW_GRAPH_UNDIRECTED("newGraphUndirected"),
		//
		NEW_GRAPH_DIRECTED("newGraphDirected"),
		//
		OPEN_GRAPH("openGraph"),
		//
		SAVE_GRAPH("saveGraph"),
		//
		SAVE_GRAPH_AS("saveGraphAs"),
		//
		EDIT_GRAPH("editGraph"),
		// edit
		MODE("mode"),
		//
		START("start"),
		//
		FINISH("editGraph"),
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
