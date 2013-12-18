/**
 * 
 */
package vistra.gui.control.stepbystep;

import vistra.util.IState;
import vistra.util.State;

/**
 * An abstract step-by-step state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractStepByStepState extends State implements IState {

	/**
	 * A field for a context.
	 */
	protected StepByStepStateHandler context;

	/**
	 * Main constructor.
	 * 
	 * @param stepByStepStateHandler
	 *            a step-by-step handler
	 */
	protected AbstractStepByStepState(
			IStepByStepStateHandler stepByStepStateHandler) {
		this.context = (StepByStepStateHandler) stepByStepStateHandler;
	}

	/**
	 * Handles an interaction: idle.
	 */
	void handleIdle() {
		this.context.setState(new StepByStepIdle(this.context));
	}

	/**
	 * Handles an interaction: to beginning.
	 */
	void handleToBeginning() {
		this.context.goToBeginning();
		this.context.setState(new StepByStepAtBeginning(this.context));
	}

	/**
	 * Handles an interaction: backward.
	 */
	void handleBackward() {
		boolean hasPrevious = this.context.goBackward();
		if (hasPrevious)
			this.context.setState(new StepByStepIntermediate(this.context));
		else
			this.context.setState(new StepByStepAtBeginning(this.context));
	}

	/**
	 * Handles an interaction: forward.
	 */
	void handleForward() {
		boolean hasNext = this.context.goForward();
		if (hasNext)
			this.context.setState(new StepByStepIntermediate(this.context));
		else
			this.context.setState(new StepByStepAtEnd(this.context));
	}

	/**
	 * Handles an interaction: to end.
	 */
	void handleToEnd() {
		this.context.goToEnd();
		this.context.setState(new StepByStepAtEnd(this.context));
	}

	/**
	 * Handles an interaction: off.
	 */
	void handleOff() {
		this.context.setState(new StepByStepOff(this.context));
	}

}
