/**
 * 
 */
package vistra.gui.control.animation;

import vistra.util.IState;

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
	 * @param stateHandler
	 *            s stateHandler
	 */
	AnimationPlaying(IAnimationStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewPlaying();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void startDo() throws Exception {
		try {
			super.stateHandler.startAnimation();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
