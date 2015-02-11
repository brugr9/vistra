package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * An animation state: stopped.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see AnimationStateHandler
 * 
 */
class AnimationStopped extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	AnimationStopped(IAnimation stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setStopped();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
