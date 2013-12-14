/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.util;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

/**
 * An abstract state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class State implements IState {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.control.IState#entry()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void entry() {
		this.doEntry();
		this.startDo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.control.IState#exit()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void exit() {
		this.stopDo();
		this.doExit();
	}

	/**
	 * Does the entry.
	 */
	protected void doEntry() {
		// default empty implementation
	}

	/**
	 * Starts doing.
	 */
	protected void startDo() {
		// default empty implementation
	}

	/**
	 * Stops doing.
	 */
	protected void stopDo() {
		// default empty implementation
	}

	/**
	 * Does the exit.
	 */
	protected void doExit() {
		// default empty implementation
	}

}
