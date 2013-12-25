package vistra.gui.control.state.parameter;

import vistra.util.IState;

/**
 * A parameter state: off.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ParameterStateOff extends AbstractParameterState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	ParameterStateOff(IParameterStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewOff();
		} catch (Exception e) {
			throw e;
		}
	}

}
