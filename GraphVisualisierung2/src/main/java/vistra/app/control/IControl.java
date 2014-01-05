package vistra.app.control;

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
	 * Control events.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ControlEvent {
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
		EDITING("editing"),
		//
		PICKING("picking"),
		// edit
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
		ControlEvent(String value) {
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

		// i18n
		public static final String i18n = I18N.getValue();
		// IO graph
		public static final String graph = GRAPH.getValue();
		//
		public static final String newUndirected = NEW_UNDIRECTED.getValue();
		//
		public static final String newDirected = NEW_DIRECTED.getValue();
		//
		public static final String open = OPEN.getValue();
		//
		public static final String save = SAVE.getValue();
		//
		public static final String saveAs = SAVE_AS.getValue();
		// edit
		public static final String mode = MODE.getValue();
		//
		public static final String editing = EDITING.getValue();
		//
		public static final String picking = PICKING.getValue();
		// edit
		public static final String edit = EDIT.getValue();
		//
		public static final String start = START.getValue();
		//
		public static final String end = END.getValue();
		//
		public static final String delete = DELETE.getValue();
		// algorithm
		public static final String algorithm = ALGORITHM.getValue();
		// player settings
		public static final String delay = DELAY.getValue();
		//
		public static final String steplength = STEPLENGTH.getValue();
		// step-by-step
		public static final String stepByStep = STEP_BY_STEP.getValue();
		//
		public static final String toBeginning = TO_BEGINNING.getValue();
		//
		public static final String backward = BACKWARD.getValue();
		//
		public static final String forward = FORWARD.getValue();
		//
		public static final String toEnd = TO_END.getValue();
		// animation
		public static final String animation = ANIMATION.getValue();
		//
		public static final String play = PLAY.getValue();
		//
		public static final String pause = PAUSE.getValue();
		//
		public static final String resume = RESUME.getValue();
		//
		public static final String stop = STOP.getValue();

	}

}
