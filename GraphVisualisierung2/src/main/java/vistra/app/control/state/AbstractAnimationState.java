package vistra.app.control.state;

import vistra.framework.util.AbstractState;
import vistra.framework.util.IState;

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
			this.stateHandler.setState(new AnimationStateStopped(
					this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles play.
	 * 
	 * @throws Exception
	 */
	void handlePlay() throws Exception {
		try {
			this.stateHandler.startAnimation();
			this.stateHandler.setState(new AnimationStatePlaying(
					this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles pause.
	 * 
	 * @throws Exception
	 */
	void handlePause() throws Exception {
		try {
			this.stateHandler.pauseAnimation();
			this.stateHandler.setState(new AnimationStatePaused(
					this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles stop.
	 * 
	 * @throws Exception
	 */
	void handleStop() throws Exception {
		try {
			this.stateHandler.stopAnimation();
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
