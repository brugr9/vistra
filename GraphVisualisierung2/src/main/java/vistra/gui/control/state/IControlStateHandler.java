package vistra.gui.control.state;

/**
 * An interface for a control state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IControlStateHandler {

	/**
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	abstract void handleIdle() throws Exception;

	/**
	 * Handles off.
	 * 
	 * @throws Exception
	 */
	abstract void handleOff() throws Exception;

}
