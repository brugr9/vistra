/**
 * 
 */
package vistra.gui.control.animation;

import vistra.util.IState;

/**
 * An animation state: stopped.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AnimationStopped extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param animationStateHandler
	 *            an animation handler
	 */
	AnimationStopped(IAnimationStateHandler animationStateHandler) {
		super(animationStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewStopped();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void startDo() {
		super.context.stopAnimation();
	}

}