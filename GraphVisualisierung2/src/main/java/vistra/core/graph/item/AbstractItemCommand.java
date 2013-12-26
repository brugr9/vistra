package vistra.core.graph.item;

import vistra.util.ICommand;

/**
 * An abstract item-command.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractItemCommand implements ICommand {

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
	protected AbstractItemCommand(IItemStateHandler stateHandler) {
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
