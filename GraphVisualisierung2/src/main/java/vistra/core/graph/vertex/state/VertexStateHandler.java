package vistra.core.graph.vertex.state;

/**
 * A vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class VertexStateHandler implements IVertexStateHandler {

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
		this.setState(new InitialVertex(this));
		this.wasActivated = 0;
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
	public void handleActivate() {
		this.state.exit();
		this.state.handleActivate();
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
	void setState(AbstractVertexState state) {
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
	void activate() {
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
	void solve() {
		// TODO
	}

}
