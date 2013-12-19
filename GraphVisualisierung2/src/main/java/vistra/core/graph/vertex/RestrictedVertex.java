package vistra.core.graph.vertex;

import vistra.core.graph.vertex.state.VertexStateHandler;

/**
 * A restricted vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class RestrictedVertex extends VertexStateHandler implements IRestrictedVertex {

	/**
	 * A field for a vertex.
	 */
	private IVertex vertex;

	/**
	 * Main constructor.
	 */
	RestrictedVertex(IVertex vertex) {
		super();
		this.vertex = vertex;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isStart() {
		return this.vertex.isStart();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnd() {
		return this.vertex.isEnd();
	}

	@Override
	public void setDistance(double distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleInitialise() throws Exception {
		try {
			this.vertex.handleInitialise();
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
			this.vertex.handleActivate();
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
			this.vertex.handleVisit();
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
			this.vertex.handleSolve();
		} catch (Exception e) {
			throw e;
		}
	}

}
