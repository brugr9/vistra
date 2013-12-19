package vistra.gui.control.parameter;

import vistra.util.IState;

/**
 * A parameter state: idle.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ParameterIdle extends AbstractParameterState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	ParameterIdle(IParameterStateHandler stateHandler) {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void startDo() throws Exception {
		try {
			super.stateHandler.idle();
		} catch (Exception e) {
			throw e;
		}
	}

}
