/**
 * 
 */
package vistra.gui.control.animation;

import vistra.util.IState;

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
	 * @param stateHandler
	 *            a stateHandler
	 */
	AnimationPaused(IAnimationStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewPaused();
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
			super.stateHandler.pauseAnimation();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	void handlePause() throws Exception {
		try {
			super.stateHandler
					.setState(new AnimationPlaying(super.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
