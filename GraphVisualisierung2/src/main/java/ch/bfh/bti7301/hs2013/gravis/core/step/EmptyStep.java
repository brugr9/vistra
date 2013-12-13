package ch.bfh.bti7301.hs2013.gravis.core.step;

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
	public IStepResult unExecute() {
		// no operation
		return new StepResult();
	}

}
