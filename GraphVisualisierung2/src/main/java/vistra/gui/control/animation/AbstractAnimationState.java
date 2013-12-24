package vistra.gui.control.animation;

import vistra.util.AbstractState;
import vistra.util.IState;

/**
 * An abstract animation state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
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
	 * Handles an interaction: idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			this.stateHandler.setState(new AnimationIdle(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles an interaction: play.
	 * 
	 * @throws Exception
	 */
	void handlePlay() throws Exception {
		try {
			this.stateHandler.setState(new AnimationPlaying(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles an interaction: pause.
	 * 
	 * @throws Exception
	 */
	void handlePause() throws Exception {
		try {
			this.stateHandler.setState(new AnimationPaused(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles an interaction: stop.
	 * 
	 * @throws Exception
	 */
	void handleStop() throws Exception {
		try {
			this.stateHandler.setState(new AnimationStopped(this.stateHandler));
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
			this.stateHandler.setState(new AnimationOff(this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
