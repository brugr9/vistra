package vistra.core.graph.item.state;

import vistra.util.IState;

/**
 * A vertex state: unexplored.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 *  @see VertexStateHandler
 */
class VertexStateUnexplored extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	VertexStateUnexplored(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setViewUnexplored();
		} catch (Exception e) {
			throw e;
		}
	}

}
