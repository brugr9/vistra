package vistra.core.graph.item.vertex;

import vistra.util.IState;

/**
 * A vertex state: unexplored.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VertexStateUnexplored extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a stateHandler
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
