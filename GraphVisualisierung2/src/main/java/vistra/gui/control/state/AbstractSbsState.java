package vistra.gui.control.state;

import vistra.util.AbstractState;
import vistra.util.IState;

/**
 * An abstract step-by-step state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see SbsStateHandler
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
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			switch (this.stateHandler.idle()) {
			case -1:
				this.stateHandler.setState(new SbsStateBeginning(
						this.stateHandler));
				break;
			case 1:
				this.stateHandler.setState(new SbsStateEnd(this.stateHandler));
				break;
			default:
				this.stateHandler
						.setState(new SbsStateInter(this.stateHandler));
				break;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles beginning.
	 * 
	 * @throws Exception
	 */
	void handleToBeginning() throws Exception {
		try {
			this.stateHandler.toBeginning();
			this.stateHandler
					.setState(new SbsStateBeginning(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles backward.
	 * 
	 * @throws Exception
	 */
	void handleBackward() throws Exception {
		try {
			boolean hasPrevious = this.stateHandler.backward();
			if (hasPrevious)
				this.stateHandler
						.setState(new SbsStateInter(this.stateHandler));
			else
				this.stateHandler.setState(new SbsStateBeginning(
						this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles forward.
	 * 
	 * @throws Exception
	 */
	void handleForward() throws Exception {
		try {
			boolean hasNext = this.stateHandler.forward();
			if (hasNext)
				this.stateHandler
						.setState(new SbsStateInter(this.stateHandler));
			else
				this.stateHandler.setState(new SbsStateEnd(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles end.
	 * 
	 * @throws Exception
	 */
	void handleToEnd() throws Exception {
		try {
			this.stateHandler.toEnd();
			this.stateHandler.setState(new SbsStateEnd(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles off.
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
