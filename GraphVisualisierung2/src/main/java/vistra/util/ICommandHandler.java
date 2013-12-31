package vistra.util;

/**
 * A command handler interface (macro command).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ICommandHandler {

	/**
	 * Adds a command.
	 * 
	 * @param command
	 *            the command to add
	 * @throws Exception
	 */
	void addCommand(ICommand command) throws Exception;

}
