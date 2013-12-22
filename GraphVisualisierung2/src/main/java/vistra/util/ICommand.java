package vistra.util;

/**
 * A (macro-)command interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ICommand extends ICommandHandler {

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
	 * A helper method, returns <code>true</code> if the command's operation can
	 * be reverted.
	 * 
	 * @return <code>true</code> if undoable
	 */
	abstract boolean isUndoable();

}
