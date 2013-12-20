package vistra.core.graph.item.edge.state;

import vistra.core.graph.item.AbstractGraphItem;

/**
 * An edge state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class EdgeStateHandler extends AbstractGraphItem implements
		IEdgeStateHandler {

	/**
	 * A field for an edge state.
	 */
	private AbstractEdgeState state;
	/**
	 * A field for counting the # of times the edge was visited.
	 */
	private int wasVisited;

	/**
	 * Main constructor.
	 * 
	 */
	public EdgeStateHandler() {
		super();
		try {
			this.setState(new InitialEdge(this));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleInitialise() throws Exception {
		try {
			this.state.exit();
			this.state.handleInitialise();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleBack() throws Exception {
		try {
			this.state.exit();
			this.state.handleBack();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleVisit() throws Exception {
		try {
			this.state.exit();
			this.state.handleVisit();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleDiscard() throws Exception {
		try {
			this.state.exit();
			this.state.handleDiscard();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSolve() throws Exception {
		try {
			this.state.exit();
			this.state.handleSolve();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sets a state.
	 * 
	 * @param state
	 *            the state to set
	 * @throws Exception
	 */
	void setState(AbstractEdgeState state) throws Exception {
		try {
			this.state = state;
			this.state.entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void initialise() throws Exception {
		try {
			// TODO
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void back() throws Exception {
		try {
			// TODO
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void visit() throws Exception {
		try {
			// TODO
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void discard() throws Exception {
		try {
			// TODO
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
	 * 
	 * @throws Exception
	 */
	void solve() throws Exception {
		try {
			// TODO
		} catch (Exception e) {
			throw e;
		}
	}

}
