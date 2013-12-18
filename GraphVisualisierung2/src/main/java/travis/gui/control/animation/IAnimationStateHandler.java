package travis.gui.control.animation;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

/**
 * An interface for an animation state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IAnimationStateHandler extends FocusListener, ActionListener {

	/**
	 * A field for a second (in milliseconds).
	 */
	public final static int A_SECOND = 1000;

	/**
	 * Handles an interaction: idle.
	 */
	abstract void handleIdle();

	/**
	 * Handles an interaction: play.
	 */
	abstract void handlePlay();

	/**
	 * Handles an interaction: pause.
	 */
	abstract void handlePause();

	/**
	 * Handles an interaction: stop.
	 */
	abstract void handleStop();

	/**
	 * Handles an interaction: off.
	 */
	abstract void handleOff();

}
