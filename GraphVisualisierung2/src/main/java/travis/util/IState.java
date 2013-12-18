package travis.util;

/**
 * A state interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IState {

	/**
	 * Executes the entry behaviour.
	 */
	abstract void entry();

	/**
	 * Executes the exit behaviour.
	 */
	abstract void exit();

}
