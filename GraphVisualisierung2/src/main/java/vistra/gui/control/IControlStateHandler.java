package vistra.gui.control;

/**
 * An interface for a control state handler. All control state machines can be
 * off or idle.
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
