package vistra.core.graph.item;

/**
 * An abstract item command.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractItemCommand implements IItemCommand {

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
	public AbstractItemCommand(IItemStateHandler stateHandler) {
		this.stateHandler = stateHandler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		// default empty implementation

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() throws Exception {
		this.stateHandler.handleSetPreviousState();
	}

}
