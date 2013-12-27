package vistra.core.traversal.step;

import vistra.core.graph.item.state.command.IItemStateCommand;
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
	 *            the command to add
	 * @throws Exception
	 */
	public void addCommand(IItemStateCommand command) throws Exception;

}
