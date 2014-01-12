package vistra.app.control.state;

/**
 * An interface for a control context: handles off and idle.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
interface IControlContext {

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
