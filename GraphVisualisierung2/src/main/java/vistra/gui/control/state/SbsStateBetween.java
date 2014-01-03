package vistra.gui.control.state;

import vistra.util.IState;

/**
 * A step-by-step state: between (... beginning and end).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see SbsStateHandler
 * 
 */
class SbsStateBetween extends AbstractSbsState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SbsStateBetween(ISbsStateHandler stateHandler) {
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
