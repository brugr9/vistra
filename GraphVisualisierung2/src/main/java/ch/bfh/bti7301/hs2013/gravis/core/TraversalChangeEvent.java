package ch.bfh.bti7301.hs2013.gravis.core;

import javax.swing.event.ChangeEvent;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class TraversalChangeEvent extends ChangeEvent {

	private static final long serialVersionUID = -6094850288655318973L;

	private String message;
	
	/**
	 * @param source
	 */
	protected TraversalChangeEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getMessage();
	}

	
}
