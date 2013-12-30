package vistra.core.graph.item.state.command;

import vistra.core.graph.item.state.IItemStateHandler;

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
	IItemStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            an state handler
	 */
	AbstractItemStateCommand(IItemStateHandler stateHandler) {
		this.stateHandler = stateHandler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() throws Exception {
		this.stateHandler.handleSetPreviousState();
	}

}
