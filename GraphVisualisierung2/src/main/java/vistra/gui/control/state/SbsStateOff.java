package vistra.gui.control.state;

import vistra.util.IState;

/**
 * A step-by-step state: off.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see SbsStateHandler
 * 
 */
class SbsStateOff extends AbstractSbsState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	SbsStateOff(ISbsStateHandler stateHandler) {
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
