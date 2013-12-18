/**
 * 
 */
package vistra.gui.control.stepbystep;

import vistra.util.IState;

/**
 * A step-by-step state: intermediate.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepByStepIntermediate extends AbstractStepByStepState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stepByStepStateHandler
	 *            a step-by-step handler
	 */
	StepByStepIntermediate(IStepByStepStateHandler stepByStepStateHandler) {
		super(stepByStepStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewIntermediate();
	}

}
