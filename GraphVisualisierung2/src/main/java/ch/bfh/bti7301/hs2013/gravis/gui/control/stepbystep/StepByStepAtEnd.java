/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.stepbystep;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

/**
 * A step-by-step state: at the end.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepByStepAtEnd extends AbstractStepByStepState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stepByStepStateHandler
	 *            a step-by-step handler
	 */
	StepByStepAtEnd(IStepByStepStateHandler stepByStepStateHandler) {
		super(stepByStepStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewEnd();
	}

}
