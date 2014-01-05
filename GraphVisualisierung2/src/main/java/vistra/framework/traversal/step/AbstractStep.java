package vistra.framework.traversal.step;

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
	 * A field for a step handler.
	 */
	IStepHandler stepHandler;

	/**
	 * Main constructor.
	 */
	AbstractStep() {
		this.description = new StringBuilder();
		this.stepHandler = new StepHandler();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		this.stepHandler.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() throws Exception {
		this.stepHandler.undo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return this.description.toString();
	}

}
