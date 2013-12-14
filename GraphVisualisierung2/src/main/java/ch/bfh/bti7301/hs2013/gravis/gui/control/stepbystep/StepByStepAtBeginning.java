/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.stepbystep;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

/**
 * A step-by-step state: at the beginning.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepByStepAtBeginning extends AbstractStepByStepState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stepByStepStateHandler
	 *            a step-by-step handler
	 */
	StepByStepAtBeginning(IStepByStepStateHandler stepByStepStateHandler) {
		super(stepByStepStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewBeginning();
	}

}
