/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.parameter;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

/**
 * A parameter state: graph edited.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ParameterGraphSaved extends AbstractParameterState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param parameterStateHandler
	 *            a parameter state handler
	 */
	ParameterGraphSaved(IParameterStateHandler parameterStateHandler) {
		super(parameterStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewGraphSaved();
	}

}
