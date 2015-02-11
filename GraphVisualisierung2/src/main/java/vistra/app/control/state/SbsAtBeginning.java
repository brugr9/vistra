package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * A step-by-step state: at the beginning.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see SbsStateHandler
 * 
 */
class SbsAtBeginning extends AbstractSbsState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SbsAtBeginning(IStepByStep stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setBeginning();
		} catch (Exception e) {
			throw e;
		}
	}

}
