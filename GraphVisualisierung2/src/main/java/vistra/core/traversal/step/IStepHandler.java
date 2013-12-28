package vistra.core.traversal.step;

import vistra.core.graph.item.command.IItemCommand;
import vistra.util.ICommand;

/**
 * A step handler interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
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
