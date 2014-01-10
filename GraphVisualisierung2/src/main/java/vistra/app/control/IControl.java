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
		//
		I18N("i18n"),
		// mode
		MODE("mode"),
		//
		EDITING("editing"),
		//
		PICKING("picking"),
		//
		QUIT("quit"),

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

		//
		public static final String i18n = I18N.getValue();
		// mode
		public static final String mode = MODE.getValue();
		//
		public static final String editing = EDITING.getValue();
		//
		public static final String picking = PICKING.getValue();
		//
		public static final String quit = QUIT.getValue();

	}

	/**
	 * Control events.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ParameterEvent {

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
		EDIT("edit"),
		//
		START("start"),
		//
		END("end"),
		//
		DELETE("delete"),
		// algorithm
		ALGORITHM("algorithm"),

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
		ParameterEvent(String value) {
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
		public static final String edit = EDIT.getValue();
		//
		public static final String start = START.getValue();
		//
		public static final String end = END.getValue();
		//
		public static final String delete = DELETE.getValue();
		// algorithm
		public static final String algorithm = ALGORITHM.getValue();

	}

	/**
	 * Animation events.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum AnimationEvent {

		// animation
		ANIMATION("animation"),
		//
		DELAY("delay"),
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
		AnimationEvent(String value) {
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

		// animation
		public static final String animation = ANIMATION.getValue();
		//
		public static final String delay = DELAY.getValue();
		//
		public static final String play = PLAY.getValue();
		//
		public static final String pause = PAUSE.getValue();
		//
		public static final String resume = RESUME.getValue();
		//
		public static final String stop = STOP.getValue();

	}

	/**
	 * Step-by-step events.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum SbsEvent {

		// step-by-step
		STEP_BY_STEP("stepByStep"),
		//
		STEPLENGTH("steplenth"),
		//
		TO_BEGINNING("toBeginning"),
		//
		BACKWARD("backward"),
		//
		FORWARD("forward"),
		//
		TO_END("toEnd"),

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
		SbsEvent(String value) {
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

		// step-by-step
		public static final String stepByStep = STEP_BY_STEP.getValue();
		//
		public static final String steplength = STEPLENGTH.getValue();
		//
		public static final String toBeginning = TO_BEGINNING.getValue();
		//
		public static final String backward = BACKWARD.getValue();
		//
		public static final String forward = FORWARD.getValue();
		//
		public static final String toEnd = TO_END.getValue();

	}
}
