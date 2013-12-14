/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.parameter;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

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
	 * @param parameterStateHandler
	 *            a parameter state handler
	 */
	ParameterAlgorithmSelected(IParameterStateHandler parameterStateHandler) {
		super(parameterStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewAlgorithmSelected();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void startDo() {
		try {
			super.context.enableTraversalPlayer(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void stopDo() {
		try {
			super.context.enableTraversalPlayer(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
