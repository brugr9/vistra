package vistra.gui.control.state.stepbystep;

import vistra.util.AbstractState;
import vistra.util.IState;

/**
 * An abstract step-by-step state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractSbsState extends AbstractState implements IState {

	/**
	 * A field for a state handler.
	 */
	protected SbsStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	protected AbstractSbsState(ISbsStateHandler stateHandler) {
		this.stateHandler = (SbsStateHandler) stateHandler;
	}

	/**
	 * Handles an interaction: idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			this.stateHandler.setState(new SbsStateIdle(this.stateHandler));
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
			this.stateHandler.setState(new SbsStateAtBeginning(
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
				this.stateHandler.setState(new SbsStateIntermediate(
						this.stateHandler));
			else
				this.stateHandler.setState(new SbsStateAtBeginning(
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
				this.stateHandler.setState(new SbsStateIntermediate(
						this.stateHandler));
			else
				this.stateHandler.setState(new SbsStateAtEnd(
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
			this.stateHandler.setState(new SbsStateAtEnd(this.stateHandler));
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
			this.stateHandler.setState(new SbsStateOff(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
