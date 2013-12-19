package vistra.gui.control.stepbystep;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import vistra.gui.control.IControlStateHandler;

/**
 * An interface for a step-by-step state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IStepByStepStateHandler extends IControlStateHandler,
		FocusListener, ActionListener {

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
