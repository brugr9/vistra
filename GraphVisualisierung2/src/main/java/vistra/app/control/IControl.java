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
	public enum ControlEvent {
		I18N, QUIT;
		public final static String quit = QUIT.toString();
	}

}
