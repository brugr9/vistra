package ch.bfh.bti7301.hs2013.gravis.core.graph;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class GraphException extends Exception {

	private static final long serialVersionUID = -6462515714563342030L;

	public GraphException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public GraphException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public GraphException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public GraphException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public GraphException(Throwable cause) {
		super(cause);
	}

	
}
