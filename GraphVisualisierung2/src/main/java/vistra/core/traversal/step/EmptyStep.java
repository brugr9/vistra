package vistra.core.traversal.step;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class EmptyStep implements IStep {

	protected EmptyStep() {
	}

	@Override
	public IStepResult execute() {
		// no operation
		return new StepResult();
	}

	@Override
	public IStepResult undo() {
		// no operation
		return new StepResult();
	}

}
