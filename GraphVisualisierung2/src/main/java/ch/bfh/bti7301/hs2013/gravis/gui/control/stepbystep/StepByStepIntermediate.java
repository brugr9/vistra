/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.stepbystep;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

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
