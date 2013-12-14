/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.animation;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

/**
 * An animation state: paused.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AnimationPaused extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param animationStateHandler
	 *            an animation handler
	 */
	AnimationPaused(IAnimationStateHandler animationStateHandler) {
		super(animationStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewPaused();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void startDo() {
		super.context.pauseAnimation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	void handlePause() {
		super.context.setState(new AnimationPlaying(super.context));
	}

}
