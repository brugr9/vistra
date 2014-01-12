package vistra.app.control.state;

import vistra.framework.util.IState;

/**
 * An animation state: off.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see Animation
 * 
 */
class AnimationOff extends AbstractAnimationState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	AnimationOff(IAnimation stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.handler.setOff();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
