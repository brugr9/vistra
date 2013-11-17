package ch.bfh.bti7301.hs2013.gravis.core;

/**
 * Gravis Core Exception<br>
 * This class extends <code>Exception</code> that indicates conditions that a
 * reasonable application might want to catch.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class CoreException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new exception with <code>null</code> as its detail message.
	 * The cause is not initialised, and may subsequently be initialised by a
	 * call to {@link #initCause}.
	 */
	public CoreException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message. The cause
	 * is not initialised, and may subsequently be initialised by a call to
	 * {@link #initCause}.
	 * 
	 * @param message
	 *            the detail message. The detail message is saved for later
	 *            retrieval by the {@link #getMessage()} method.
	 */
	public CoreException(String message) {
		super("GRAVIS: " + message);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * <p>
	 * Note that the detail message associated with <code>cause</code> is
	 * <i>not</i> automatically incorporated in this exception's detail message.
	 * 
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *            {@link #getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *            permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 */
	public CoreException(String message, Throwable cause) {
		super("GRAVIS: " + message, cause);
	}

	/**
	 * Constructs a new exception with the specified cause and a detail message
	 * of <tt>(cause==null ? null : cause.toString())</tt> (which typically
	 * contains the class and detail message of <tt>cause</tt>). This
	 * constructor is useful for exceptions that are little more than wrappers
	 * for other throwables (for example,
	 * {@link java.security.PrivilegedActionException}).
	 * 
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *            permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 */
	public CoreException(Throwable cause) {
		super(cause);
	}
}
