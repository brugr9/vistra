package vistra.gui.control.stepbystep;

import vistra.util.IState;

/**
 * A step-by-step state: idle.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepByStepIdle extends AbstractStepByStepState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	StepByStepIdle(IStepByStepStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewIdle();
		} catch (Exception e) {
			throw e;
		}
	}

}
