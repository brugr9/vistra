package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * An animation state: paused.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see Animation
 * 
 */
class AnimationPaused extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	AnimationPaused(IAnimation stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setPaused();
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
			super.handler.pauseAnimation();
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
			this.handler.resumeAnimation();
			this.handler.setState(new AnimationPlaying(
					this.handler));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
