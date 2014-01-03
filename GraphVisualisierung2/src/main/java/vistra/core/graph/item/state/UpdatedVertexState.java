package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * A vertex state: updated.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see VertexStateHandler
 */
class UpdatedVertexState extends AbstractVertexState implements IState {

	/**
	 * A field for a value.
	 */
	String value;

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 * @param value
	 *            a value
	 */
	UpdatedVertexState(IVertexStateHandler stateHandler, String value) {
		super(stateHandler);
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setLayoutUpdated(this.value);
		} catch (Exception e) {
			throw e;
		}
	}

}
