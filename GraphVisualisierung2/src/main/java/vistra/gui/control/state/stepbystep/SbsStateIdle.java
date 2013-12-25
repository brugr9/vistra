package vistra.gui.control.state.stepbystep;

import vistra.util.IState;

/**
 * A step-by-step state: idle.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class SbsStateIdle extends AbstractSbsState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SbsStateIdle(ISbsStateHandler stateHandler) {
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
