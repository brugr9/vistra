package vistra.gui.control.state;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;


/**
 * An interface for a step-by-step state handler.A step-by-step state machine
 * handles the step-by-step iteration over a traversal-object.
 * <p>
 * As a part of the graphic user interface control, this state handler is a
 * focus listener (step length setting) and an action listener (buttons), too.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IParameterStateHandler
 * @see IAnimationStateHandler
 */
public interface ISbsStateHandler extends IControlStateHandler, FocusListener,
		ActionListener {

	/**
	 * Handles an interaction: to beginning |<<.
	 * 
	 * @throws Exception
	 */
	abstract void handleToBeginning() throws Exception;

	/**
	 * Handles an interaction: backward <<.
	 * 
	 * @throws Exception
	 */
	abstract void handleBackward() throws Exception;

	/**
	 * Handles an interaction: forward >>.
	 * 
	 * @throws Exception
	 */
	abstract void handleForward() throws Exception;

	/**
	 * Handles an interaction: to end (>>|.
	 * 
	 * @throws Exception
	 */
	abstract void handleToEnd() throws Exception;

}
