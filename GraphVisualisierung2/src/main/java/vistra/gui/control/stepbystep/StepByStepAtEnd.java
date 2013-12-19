package vistra.gui.control.stepbystep;

import vistra.util.IState;

/**
 * A step-by-step state: at the end.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepByStepAtEnd extends AbstractStepByStepState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	StepByStepAtEnd(IStepByStepStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewEnd();
		} catch (Exception e) {
			throw e;
		}
	}

}
