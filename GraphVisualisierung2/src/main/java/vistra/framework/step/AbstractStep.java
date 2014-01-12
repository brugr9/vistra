package vistra.framework.step;

/**
 * An abstract step.
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
	 * A field for a command handler.
	 */
	IItemStateCommandHandler handler;

	/**
	 * Main constructor.
	 */
	AbstractStep() {
		this.description = new StringBuilder();
		this.handler = new ItemStateCommandHandler();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		this.handler.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() throws Exception {
		this.handler.undo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return this.description.toString();
	}

}
