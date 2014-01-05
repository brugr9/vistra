package vistra.app.control.state;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

/**
 * An interface for an animation state handler. An animation state machine
 * handles the animated iteration over a traversal-object.
 * <p>
 * As a part of the graphic user interface control, this state handler is an is
 * a focus listener (delay setting) and an action listener (buttons), too.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IParameterStateHandler
 * @see ISbsStateHandler
 */
public interface IAnimationStateHandler extends IControlStateHandler,
		FocusListener, ActionListener {

	/**
	 * Handles an interaction: play.
	 * 
	 * @throws Exception
	 */
	void handlePlaying() throws Exception;

	/**
	 * Handles an interaction: pause.
	 * 
	 * @throws Exception
	 */
	void handlePaused() throws Exception;

	/**
	 * Handles an interaction: stop.
	 * 
	 * @throws Exception
	 */
	void handleStopped() throws Exception;

}
