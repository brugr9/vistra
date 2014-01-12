package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * A step-by-step state: off.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see StepByStep
 * 
 */
class SbsOff extends AbstractSbsState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SbsOff(IStepByStep stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		super.handler.setOff();
	}

}
