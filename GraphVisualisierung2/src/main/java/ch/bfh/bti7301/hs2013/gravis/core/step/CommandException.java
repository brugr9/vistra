package ch.bfh.bti7301.hs2013.gravis.core.step;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class CommandException extends Exception {

	private static final long serialVersionUID = -985202167979838848L;

	public CommandException() {
		super();
	}

	/**
	 * @param message
	 */
	public CommandException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CommandException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CommandException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CommandException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
