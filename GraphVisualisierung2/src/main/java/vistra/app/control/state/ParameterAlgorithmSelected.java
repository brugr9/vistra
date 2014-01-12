package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * A parameter state: algorithm selected.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ParameterStateHandler
 * 
 */
class ParameterAlgorithmSelected extends AbstractParameterState implements
		IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	ParameterAlgorithmSelected(IParameterHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setViewEnableTraversal(true);
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
			super.handler.setViewEnableTraversal(false);
		} catch (Exception e) {
			throw e;
		}
	}

}
