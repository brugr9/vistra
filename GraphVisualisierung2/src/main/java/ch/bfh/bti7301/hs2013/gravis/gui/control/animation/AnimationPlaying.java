/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.animation;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

/**
 * An animation state: playing.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AnimationPlaying extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param animationStateHandler
	 *            an animation handler
	 */
	AnimationPlaying(IAnimationStateHandler animationStateHandler) {
		super(animationStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewPlaying();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void startDo() {
		super.context.startAnimation();
	}

}
