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
	 * A field for a handler.
	 */
	protected AnimationStateHandler handler;

	/**
	 * Main constructor.
	 * 
	 * @param handler
	 *            a handler
	 */
	protected AbstractAnimationState(IAnimation handler) {
		this.handler = (AnimationStateHandler) handler;
	}

	/**
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			this.handler.setState(new AnimationStopped(this.handler));
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
			this.handler.setState(new AnimationPlaying(this.handler));
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
			this.handler.setState(new AnimationPaused(this.handler));
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
			this.handler.setState(new AnimationStopped(this.handler));
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
			this.handler.setState(new AnimationOff(this.handler));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
