package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * A step-by-step state: inter (... neither beginning nor end).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see SbsStateHandler
 * 
 */
class SbsStateInter extends AbstractSbsState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SbsStateInter(ISbsStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewInter();
		} catch (Exception e) {
			throw e;
		}
	}

}
