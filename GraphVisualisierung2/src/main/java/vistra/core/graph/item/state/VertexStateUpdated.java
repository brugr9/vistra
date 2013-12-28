package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * A vertex state: updated.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see VertexStateHandler
 */
class VertexStateUpdated extends AbstractVertexState implements IState {

	/**
	 * A field for a value.
	 */
	int value;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 * @param value
	 *            a value
	 */
	VertexStateUpdated(IVertexStateHandler stateHandler, int value) {
		super(stateHandler);
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setValueUpdated(this.value);
		} catch (Exception e) {
			throw e;
		}
	}

}