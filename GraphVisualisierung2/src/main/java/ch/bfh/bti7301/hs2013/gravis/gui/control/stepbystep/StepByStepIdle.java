/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.stepbystep;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

/**
 * A step-by-step state: idle.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepByStepIdle extends AbstractStepByStepState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stepByStepStateHandler
	 *            a step-by-step handler
	 */
	StepByStepIdle(IStepByStepStateHandler stepByStepStateHandler) {
		super(stepByStepStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewIdle();
	}

}
