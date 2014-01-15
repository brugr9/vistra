package vistra.framework.traversal.step;

/**
 * An abstract step. Delegates its execute- and undo-method to an
 * {@code IItemStateCommandHandler} (macro command).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractStep implements IStep {

	/**
	 * A field for a description.
	 */
	StringBuilder description;
	/**
	 * A field for an item-state-command handler.
	 */
	IItemStateCommandHandler commandHandler;

	/**
	 * Main constructor.
	 */
	AbstractStep() {
		this.description = new StringBuilder();
		this.commandHandler = new ItemStateCommandHandler();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		this.commandHandler.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() throws Exception {
		this.commandHandler.undo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return this.description.toString();
	}

}
