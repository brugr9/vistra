package vistra.gui.control.state.animation;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import vistra.gui.control.state.IControlStateHandler;

/**
 * An interface for an animation state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IAnimationStateHandler extends IControlStateHandler,
		FocusListener, ActionListener {

	/**
	 * Handles an interaction: play.
	 * 
	 * @throws Exception
	 */
	abstract void handlePlay() throws Exception;

	/**
	 * Handles an interaction: pause.
	 * 
	 * @throws Exception
	 */
	abstract void handlePause() throws Exception;

	/**
	 * Handles an interaction: stop.
	 * 
	 * @throws Exception
	 */
	abstract void handleStop() throws Exception;

}
