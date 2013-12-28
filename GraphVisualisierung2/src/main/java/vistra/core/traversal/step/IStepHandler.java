package vistra.core.traversal.step;

import vistra.core.graph.item.state.command.IItemCommand;
import vistra.util.ICommand;

/**
 * A step handler interface. A step handler is a command handler specialised on
 * handling item-commands.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see IStep
 * @see IItemCommand
 * 
 */
interface IStepHandler extends ICommand {

	/**
	 * Adds an item command.
	 * 
	 * @param command
	 *            the item command to add
	 * @throws Exception
	 */
	public void addCommand(IItemCommand command) throws Exception;

}
