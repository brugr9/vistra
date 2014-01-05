package vistra.framework.traversal.step;

import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.util.ICommand;

/**
 * A step handler interface. A step handler is a command handler specialised on
 * item-state-commands.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see IStep
 * @see IItemStateCommand
 * 
 */
interface IStepHandler extends ICommand {

	/**
	 * Adds an item-state command.
	 * 
	 * @param command
	 *            the item-state command to add
	 * @throws Exception
	 */
	void addItemStateCommand(IItemStateCommand command) throws Exception;

}
