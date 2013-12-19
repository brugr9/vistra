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
	 * A field for a state handler.
	 */
	protected StepByStepStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	protected AbstractStepByStepState(IStepByStepStateHandler stateHandler) {
		this.stateHandler = (StepByStepStateHandler) stateHandler;
	}

	/**
	 * Handles an interaction: idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			this.stateHandler.setState(new StepByStepIdle(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles an interaction: to beginning.
	 * 
	 * @throws Exception
	 */
	void handleToBeginning() throws Exception {
		try {
			this.stateHandler.goToBeginning();
			this.stateHandler.setState(new StepByStepAtBeginning(
					this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles an interaction: backward.
	 * 
	 * @throws Exception
	 */
	void handleBackward() throws Exception {
		try {
			boolean hasPrevious = this.stateHandler.goBackward();
			if (hasPrevious)
				this.stateHandler.setState(new StepByStepIntermediate(
						this.stateHandler));
			else
				this.stateHandler.setState(new StepByStepAtBeginning(
						this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles an interaction: forward.
	 * 
	 * @throws Exception
	 */
	void handleForward() throws Exception {
		try {
			boolean hasNext = this.stateHandler.goForward();
			if (hasNext)
				this.stateHandler.setState(new StepByStepIntermediate(
						this.stateHandler));
			else
				this.stateHandler.setState(new StepByStepAtEnd(
						this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles an interaction: to end.
	 * 
	 * @throws Exception
	 */
	void handleToEnd() throws Exception {
		try {
			this.stateHandler.goToEnd();
			this.stateHandler.setState(new StepByStepAtEnd(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles an interaction: off.
	 * 
	 * @throws Exception
	 */
	void handleOff() throws Exception {
		try {
			this.stateHandler.setState(new StepByStepOff(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
