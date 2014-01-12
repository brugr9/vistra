package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * A step-by-step state: at the end.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see StepByStep
 * 
 */
class SbsAtEnd extends AbstractSbsState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SbsAtEnd(IStepByStep stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setViewEnd();
		} catch (Exception e) {
			throw e;
		}
	}

}
