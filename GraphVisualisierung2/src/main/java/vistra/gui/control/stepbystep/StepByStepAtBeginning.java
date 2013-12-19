package vistra.gui.control.stepbystep;

import vistra.util.IState;

/**
 * A step-by-step state: at the beginning.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepByStepAtBeginning extends AbstractStepByStepState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	StepByStepAtBeginning(IStepByStepStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewBeginning();
		} catch (Exception e) {
			throw e;
		}
	}

}
