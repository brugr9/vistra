package vistra.util;

/**
 * An abstract state with default empty implementation on 'do'-methods.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractState implements IState {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void entry() throws Exception {
		try {
			this.doEntry();
			this.startDo();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void exit() throws Exception {
		try {
			this.stopDo();
			this.doExit();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Does the entry.
	 * 
	 * @throws Exception
	 */
	protected void doEntry() throws Exception {
		// default empty implementation
	}

	/**
	 * Starts doing.
	 * 
	 * @throws Exception
	 */
	protected void startDo() throws Exception {
		// default empty implementation
	}

	/**
	 * Stops doing.
	 * 
	 * @throws Exception
	 */
	protected void stopDo() throws Exception {
		// default empty implementation
	}

	/**
	 * Does the exit.
	 * 
	 * @throws Exception
	 */
	protected void doExit() throws Exception {
		// default empty implementation
	}

}
