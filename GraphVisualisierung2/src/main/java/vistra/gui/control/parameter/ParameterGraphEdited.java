/**
 * 
 */
package vistra.gui.control.parameter;

import vistra.util.IState;

/**
 * A parameter state: graph edited.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ParameterGraphEdited extends AbstractParameterState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param parameterStateHandler
	 *            a parameter state handler
	 */
	ParameterGraphEdited(IParameterStateHandler parameterStateHandler) {
		super(parameterStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewGraphEdited();
	}

}
