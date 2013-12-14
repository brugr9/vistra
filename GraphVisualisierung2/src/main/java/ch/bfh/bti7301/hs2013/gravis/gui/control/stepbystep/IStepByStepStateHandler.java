package ch.bfh.bti7301.hs2013.gravis.gui.control.stepbystep;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

/**
 * An interface for a step-by-step state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IStepByStepStateHandler extends FocusListener, ActionListener {

	/**
	 * A field for a second (in milliseconds).
	 */
	public final static int A_SECOND = 1000;

	/**
	 * Handles an interaction: idle.
	 */
	abstract void handleIdle();

	/**
	 * Handles an interaction: to beginning |<<.
	 */
	abstract void handleToBeginning();

	/**
	 * Handles an interaction: backward <<.
	 */
	abstract void handleBackward();

	/**
	 * Handles an interaction: forward >>.
	 */
	abstract void handleForward();

	/**
	 * Handles an interaction: to end (>>|.
	 */
	abstract void handleToEnd();

	/**
	 * Handles an interaction: off.
	 */
	abstract void handleOff();

}
