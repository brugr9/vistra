package vistra.gui.control.parameter;

import vistra.util.IState;

/**
 * A parameter state: algorithm selected.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
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
	ParameterAlgorithmSelected(IParameterStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewAlgorithmSelected();
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
			super.stateHandler.enableTraversalPlayer(true);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void stopDo() throws Exception {
		try {
			super.stateHandler.enableTraversalPlayer(false);
		} catch (Exception e) {
			throw e;
		}
	}

}
