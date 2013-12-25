package vistra.gui.control.stepbystep;

import vistra.util.IState;

/**
 * A step-by-step state: intermediate.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class SbsStateIntermediate extends AbstractSbsState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SbsStateIntermediate(ISbsStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewIntermediate();
		} catch (Exception e) {
			throw e;
		}
	}

}
