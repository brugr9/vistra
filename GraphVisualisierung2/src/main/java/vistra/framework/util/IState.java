package vistra.framework.util;

/**
 * A state interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IState {

	/**
	 * Executes the entry behaviour.
	 * 
	 * @throws Exception
	 */
	void entry() throws Exception;

	/**
	 * Executes the exit behaviour.
	 * 
	 * @throws Exception
	 */
	void exit() throws Exception;

}
