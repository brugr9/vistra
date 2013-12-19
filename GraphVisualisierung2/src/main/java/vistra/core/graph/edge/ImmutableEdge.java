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
	public void handleInitialise() throws Exception {
		try {
			this.edge.handleInitialise();
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
			this.edge.handleBack();
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
			this.edge.handleVisit();
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
			this.edge.handleDiscard();
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
			this.edge.handleSolve();
		} catch (Exception e) {
			throw e;
		}
	}

}
