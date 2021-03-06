package vistra.framework.graph.item.state;

import vistra.framework.util.IState;

/**
 * A vertex state: unexplored.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 *  @see VertexStateHandler
 */
class UnexploredVertexState extends AbstractVertexState implements IState {

	/**
	 * Main constructor.
	 * 
	 * @param stateHandler
	 *            a state handler
	 */
	UnexploredVertexState(IVertexStateHandler stateHandler) {
		super(stateHandler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doEntry() throws Exception {
		try {
			super.stateHandler.setPropertyUnexplored();
		} catch (Exception e) {
			throw e;
		}
	}

}
