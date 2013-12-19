package vistra.gui.control.stepbystep;

import vistra.util.IState;

/**
 * A step-by-step state: off.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepByStepOff extends AbstractStepByStepState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	StepByStepOff(IStepByStepStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		super.stateHandler.setViewOff();
	}

}
