package vistra.gui.control.state;

import vistra.util.AbstractState;
import vistra.util.IState;

/**
 * An abstract animation state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see AnimationStateHandler
 * 
 */
abstract class AbstractAnimationState extends AbstractState implements IState {

	/**
	 * A field for a state handler.
	 */
	protected AnimationStateHandler stateHandler;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	protected AbstractAnimationState(IAnimationStateHandler stateHandler) {
		this.stateHandler = (AnimationStateHandler) stateHandler;
	}

	/**
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			this.stateHandler
					.setState(new AnimationStateIdle(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles playing.
	 * 
	 * @throws Exception
	 */
	void handlePlaying() throws Exception {
		try {
			this.stateHandler.setState(new AnimationStatePlaying(
					this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles paused.
	 * 
	 * @throws Exception
	 */
	void handlePaused() throws Exception {
		try {
			this.stateHandler.setState(new AnimationStatePaused(
					this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles stopped.
	 * 
	 * @throws Exception
	 */
	void handleStopped() throws Exception {
		try {
			this.stateHandler.setState(new AnimationStateStopped(
					this.stateHandler));
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
			this.stateHandler
					.setState(new AnimationStateOff(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
