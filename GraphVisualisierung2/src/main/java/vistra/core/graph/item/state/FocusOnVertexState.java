package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * A vertex state: focus on this vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see VertexStateHandler
 */
class FocusOnVertexState extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
	 */
	FocusOnVertexState(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setLayoutFocusOn();
		} catch (Exception e) {
			throw e;
		}
	}

}
