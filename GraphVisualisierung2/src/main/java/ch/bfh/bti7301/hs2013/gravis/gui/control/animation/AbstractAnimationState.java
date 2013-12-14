/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.animation;

import ch.bfh.bti7301.hs2013.gravis.util.IState;
import ch.bfh.bti7301.hs2013.gravis.util.State;

/**
 * An abstract animation state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractAnimationState extends State implements IState {

	/**
	 * A field for a context.
	 */
	protected AnimationStateHandler context;

	/**
	 * Main constructor.
	 * 
	 * @param animationStateHandler
	 *            an animation handler
	 */
	protected AbstractAnimationState(
			IAnimationStateHandler animationStateHandler) {
		this.context = (AnimationStateHandler) animationStateHandler;
	}

	/**
	 * Handles an interaction: idle.
	 */
	void handleIdle() {
		this.context.setState(new AnimationIdle(this.context));
	}

	/**
	 * Handles an interaction: play.
	 */
	void handlePlay() {
		this.context.setState(new AnimationPlaying(this.context));
	}

	/**
	 * Handles an interaction: pause.
	 */
	void handlePause() {
		this.context.setState(new AnimationPaused(this.context));
	}

	/**
	 * Handles an interaction: stop.
	 */
	void handleStop() {
		this.context.setState(new AnimationStopped(this.context));
	}

	/**
	 * Handles an interaction: off.
	 */
	void handleOff() {
		this.context.setState(new AnimationOff(this.context));
	}

}
