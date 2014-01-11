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
	 * Some general action commands.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ActionCommandGeneral {
		I18N, QUIT;
		public static final String i18n = I18N.toString();
		public static final String quit = QUIT.toString();
	}

	/**
	 * Parameter action commands.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ActionCommandParameter {

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
		//
		EDIT("edit"),
		//
		START("start"),
		//
		END("end"),
		//
		DELETE("delete"),

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
		ActionCommandParameter(String value) {
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

		public static final String newUndirected = NEW_UNDIRECTED.getValue();
		public static final String newDirected = NEW_DIRECTED.getValue();
		public static final String open = OPEN.getValue();
		public static final String save = SAVE.getValue();
		public static final String saveAs = SAVE_AS.getValue();
		public static final String edit = EDIT.getValue();
		public static final String start = START.getValue();
		public static final String end = END.getValue();
		public static final String delete = DELETE.getValue();

	}

	/**
	 * Animation action commands.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ActionCommandAnimation {

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
		ActionCommandAnimation(String value) {
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

		public static final String delay = DELAY.getValue();
		public static final String play = PLAY.getValue();
		public static final String pause = PAUSE.getValue();
		public static final String resume = RESUME.getValue();
		public static final String stop = STOP.getValue();

	}

	/**
	 * Step-by-step action commands.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ActionCommandSbs {

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
		ActionCommandSbs(String value) {
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

		public static final String steplength = STEPLENGTH.getValue();
		public static final String toBeginning = TO_BEGINNING.getValue();
		public static final String backward = BACKWARD.getValue();
		public static final String forward = FORWARD.getValue();
		public static final String toEnd = TO_END.getValue();

	}

}
