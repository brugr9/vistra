package vistra.core.graph.vertex;

import java.awt.geom.Point2D;

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Point2D getLocation() {
		return this.vertex.getLocation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleInitialise() {
		this.vertex.handleInitialise();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleActivate() {
		this.vertex.handleActivate();
	}

	@Override
	public void handleVisit() {
		this.vertex.handleVisit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleSolve() {
		this.vertex.handleSolve();
	};

}
