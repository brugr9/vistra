package vistra.framework.traversal.step;

import vistra.framework.graph.item.state.command.IItemStateCommand;
import vistra.framework.util.ICommand;

/**
 * An item-state-command handler interface (macro command). A
 * {@code ICommandHandler} specialized on {@code IItemStateCommand}s.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see IStep
 * @see IItemStateCommand
 * 
 */
interface IItemStateCommandHandler extends ICommand {

	/**
	 * Adds an item-state command.
	 * 
	 * @param c
	 *            the item-state command to add
	 * @throws Exception
	 */
	void addCommand(IItemStateCommand c) throws Exception;

}
