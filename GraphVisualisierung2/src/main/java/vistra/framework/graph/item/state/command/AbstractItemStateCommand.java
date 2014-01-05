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
	protected IItemStateHandler stateHandler;

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
		this.stateHandler.setPreviousState();
	}

}
