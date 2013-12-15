/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.parameter;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

/**
 * A parameter state: off.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ParameterOff extends AbstractParameterState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param parameterStateHandler
	 *            a parameter state handler
	 */
	ParameterOff(IParameterStateHandler parameterStateHandler) {
		super(parameterStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewOff();
	}

}