package vistra.util;

/**
 * A command interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ICommand {

	/**
	 * Executes the command.
	 * 
	 * @throws Exception
	 */
	void execute() throws Exception;

	/**
	 * Undoes the command.
	 * 
	 * @throws Exception
	 */
	void undo() throws Exception;

}
