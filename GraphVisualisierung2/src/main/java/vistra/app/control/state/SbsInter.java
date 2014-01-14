package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * A step-by-step state: inter (... neither beginning nor end).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see StepByStep
 * 
 */
class SbsInter extends AbstractSbsState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SbsInter(IStepByStep stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setInter();
		} catch (Exception e) {
			throw e;
		}
	}
	
}
