package vistra.gui.control.state;

import vistra.util.IState;

/**
 * An animation state: paused.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see AnimationStateHandler
 * 
 */
class AnimationStatePaused extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	AnimationStatePaused(IAnimationStateHandler stateHandler) {
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
	void handlePause() throws Exception {
		try {
			this.stateHandler.resumeAnimation();
			this.stateHandler.setState(new AnimationStatePlaying(
					this.stateHandler));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
