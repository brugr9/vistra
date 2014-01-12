package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * A parameter state: graph saved.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ParameterStateHandler
 * 
 */
class ParameterGraphSaved extends AbstractParameterState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	ParameterGraphSaved(IParameterHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setViewEnableAlgorithms(true);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExit() throws Exception {
		try {
			super.handler.setViewEnableAlgorithms(false);
		} catch (Exception e) {
			throw e;
		}
	}

}
