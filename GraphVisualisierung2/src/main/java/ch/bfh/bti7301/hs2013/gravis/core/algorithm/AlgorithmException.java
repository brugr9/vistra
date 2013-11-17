package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class AlgorithmException extends Exception {

	private static final long serialVersionUID = 3774886120793515985L;

	public AlgorithmException() {
		super();
	}

	/**
	 * @param message
	 */
	public AlgorithmException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AlgorithmException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AlgorithmException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AlgorithmException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
