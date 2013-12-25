package vistra.gui.control.animation;

import vistra.util.IState;

/**
 * An animation state: playing.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AnimationStatePlaying extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            s stateHandler
	 */
	AnimationStatePlaying(IAnimationStateHandler stateHandler) {
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
