package vistra.util;

/**
 * A (macro-)command interface.
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

	/**
	 * Adds a command at the end of the list of commands.
	 * 
	 * @param command
	 *            the command to add
	 * @throws Exception
	 */
	public void addCommand(ICommand command) throws Exception;

	/**
	 * A helper method, returns <code>true</code> if the command's operation can
	 * be reverted.
	 * 
	 * @return <code>true</code> if undoable
	 */
	abstract boolean isUndoable();

}
