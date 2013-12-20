package vistra.core.graph.item.vertex.state;

import vistra.core.graph.item.AbstractGraphItem;

/**
 * A vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class VertexStateHandler extends AbstractGraphItem implements
		IVertexStateHandler {

	/**
	 * A field for an vertex state.
	 */
	private AbstractVertexState state;
	/**
	 * A field for counting the # of times the vertex was activated.
	 */
	private int wasActivated;

	/**
	 * Main constructor.
	 * 
	 */
	public VertexStateHandler() {
		super();
		try {
			this.setState(new InitialVertex(this));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.wasActivated = 0;
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
	public void handleActivate() throws Exception {
		try {
			this.state.exit();
			this.state.handleActivate();
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
	 */
	void setState(AbstractVertexState state) throws Exception {
		try {
			this.state = state;
			this.state.entry();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
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
	 */
	void activate() throws Exception {
		try {
			// TODO
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing:
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
	 */
	void solve() throws Exception {
		try {
			// TODO
		} catch (Exception e) {
			throw e;
		}
	}

}
