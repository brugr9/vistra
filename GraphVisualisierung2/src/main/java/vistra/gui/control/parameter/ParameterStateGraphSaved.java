package vistra.gui.control.parameter;

import vistra.util.IState;

/**
 * A parameter state: graph saved.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ParameterStateGraphSaved extends AbstractParameterState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	ParameterStateGraphSaved(IParameterStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewGraphSaved();
		} catch (Exception e) {
			throw e;
		}
	}

}
