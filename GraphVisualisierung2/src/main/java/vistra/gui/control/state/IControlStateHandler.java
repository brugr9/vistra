package vistra.gui.control.state;

/**
 * An interface for a control state handler. All control state handler can
 * handle off and idle.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
interface IControlStateHandler {

	/**
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception;

	/**
	 * Handles off.
	 * 
	 * @throws Exception
	 */
	void handleOff() throws Exception;

}
