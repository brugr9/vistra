package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractAnimationState implements IAnimationState {

	protected final Color stateColor;

	protected ICommand predecessorCommand;

	/**
	 * 
	 * @param color
	 */
	protected AbstractAnimationState(Color color) {
		this.stateColor = color;

		// Null Object
		this.predecessorCommand = new EmptyCommand();
	}

	@Override
	public ICommand getPredecessorCommand() {
		return this.predecessorCommand;
	}

}