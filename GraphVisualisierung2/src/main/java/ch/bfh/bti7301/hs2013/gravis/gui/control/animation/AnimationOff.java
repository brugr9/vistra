/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control.animation;

import ch.bfh.bti7301.hs2013.gravis.util.IState;

/**
 * An animation state: off.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AnimationOff extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param animationStateHandler
	 *            an animation handler
	 */
	AnimationOff(IAnimationStateHandler animationStateHandler) {
		super(animationStateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() {
		super.context.setViewOff();
	}

}
