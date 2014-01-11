package vistra.framework.graph.item.state.command;

import vistra.framework.graph.item.state.IItemStateHandler;

/**
 * An abstract item-state command.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractItemStateCommand implements IItemStateCommand {

	/**
	 * A field for a state handler.
	 */
	protected IItemStateHandler itemStateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param itemStateHandler
	 *            an item state handler
	 */
	AbstractItemStateCommand(IItemStateHandler itemStateHandler) {
		this.itemStateHandler = itemStateHandler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() throws Exception {
		this.itemStateHandler.handlePreviousState();
	}

}
