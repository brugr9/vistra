package vistra.core.graph.edge.state;

/**
 * An edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class EdgeStateHandler implements IEdgeStateHandler {

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
		this.setState(new InitialEdge(this));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleInitialise() {
		this.state.exit();
		this.state.handleInitialise();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleBack() {
		this.state.exit();
		this.state.handleBack();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleVisit() {
		this.state.exit();
		this.state.handleVisit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleDiscard() {
		this.state.exit();
		this.state.handleDiscard();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSolve() {
		this.state.exit();
		this.state.handleSolve();
	}

	/**
	 * Sets a state.
	 * 
	 * @param state
	 *            the state to set
	 */
	void setState(AbstractEdgeState state) {
		this.state = state;
		this.state.entry();
	}

	/**
	 * Doing:
	 */
	void initialise() {
		// TODO
	}

	/**
	 * Doing:
	 */
	void back() {
		// TODO
	}

	/**
	 * Doing:
	 */
	void visit() {
		// TODO
	}

	/**
	 * Doing:
	 */
	void discard() {
		// TODO
	}

	/**
	 * Doing:
	 */
	void solve() {
		// TODO
	}

}
