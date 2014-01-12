package vistra.framework.graph.item.state;

import vistra.framework.util.IState;

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
			super.stateHandler.setUpdated(this.value);
		} catch (Exception e) {
			throw e;
		}
	}

}
