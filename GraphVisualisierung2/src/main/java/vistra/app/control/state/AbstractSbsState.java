package vistra.app.control.state;

import vistra.framework.util.AbstractState;
import vistra.framework.util.IState;

/**
 * An abstract step-by-step state.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see StepByStep
 * 
 */
abstract class AbstractSbsState extends AbstractState implements IState {

	/**
	 * A field for a handler.
	 */
	protected StepByStep handler;

	/**
	 * Main constructor.
	 * 
	 * @param handler
	 *            a handler
	 */
	protected AbstractSbsState(IStepByStep handler) {
		this.handler = (StepByStep) handler;
	}

	/**
	 * Handles idle.
	 * 
	 * @throws Exception
	 */
	void handleIdle() throws Exception {
		try {
			switch (this.handler.idle()) {
			case -1:
				this.handler.setState(new SbsAtBeginning(this.handler));
				break;
			case 1:
				this.handler.setState(new SbsAtEnd(this.handler));
				break;
			default:
				this.handler.setState(new SbsInter(this.handler));
				break;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles beginning.
	 * 
	 * @throws Exception
	 */
	void handleBeginning() throws Exception {
		try {
			this.handler.toBeginning();
			this.handler.setState(new SbsAtBeginning(this.handler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles backward.
	 * 
	 * @throws Exception
	 */
	void handleBackward() throws Exception {
		try {
			boolean hasPrevious = this.handler.backward();
			if (hasPrevious)
				this.handler.setState(new SbsInter(this.handler));
			else
				this.handler.setState(new SbsAtBeginning(this.handler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles forward.
	 * 
	 * @throws Exception
	 */
	void handleForward() throws Exception {
		try {
			boolean hasNext = this.handler.forward();
			if (hasNext)
				this.handler.setState(new SbsInter(this.handler));
			else
				this.handler.setState(new SbsAtEnd(this.handler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles end.
	 * 
	 * @throws Exception
	 */
	void handleEnd() throws Exception {
		try {
			this.handler.toEnd();
			this.handler.setState(new SbsAtEnd(this.handler));
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Handles off.
	 * 
	 * @throws Exception
	 */
	void handleOff() throws Exception {
		try {
			this.handler.setState(new SbsOff(this.handler));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
