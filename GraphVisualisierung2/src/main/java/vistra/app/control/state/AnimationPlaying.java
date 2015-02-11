package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * An animation state: playing.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see AnimationStateHandler
 * 
 */
class AnimationPlaying extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            s stateHandler
	 */
	AnimationPlaying(IAnimation stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setPlaying();
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
			super.handler.startAnimation();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void stopDo() throws Exception {
		try {
			super.handler.stopAnimation();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
