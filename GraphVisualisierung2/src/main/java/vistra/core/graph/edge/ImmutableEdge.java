package vistra.core.graph.edge;

import vistra.core.graph.edge.state.EdgeStateHandler;

/**
 * An immutable edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ImmutableEdge extends EdgeStateHandler implements IImmutableEdge {

	/**
	 * A field for the edge.
	 */
	private IEdge edge;

	/**
	 * Main constructor.
	 */
	ImmutableEdge(IEdge edge) {
		super();
		this.edge = edge;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getWeight() {
		return this.edge.getWeight();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleInitialise() {
		this.edge.handleInitialise();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleBack() {
		this.edge.handleBack();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleVisit() {
		this.edge.handleVisit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleDiscard() {
		this.edge.handleDiscard();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSolve() {
		this.edge.handleSolve();
	}

}
