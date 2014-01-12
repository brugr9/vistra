package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * A parameter state: graph edited.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ParameterStateHandler
 * 
 */
class ParameterGraphEdited extends AbstractParameterState implements
		IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	ParameterGraphEdited(IParameterStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setViewGraphSaved(false);
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
			super.handler.setViewGraphSaved(true);
		} catch (Exception e) {
			throw e;
		}
	}

}
