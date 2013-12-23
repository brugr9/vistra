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
	abstract void execute() throws Exception;

	/**
	 * Undoes the command.
	 * 
	 * @throws Exception
	 */
	abstract void undo() throws Exception;

}
