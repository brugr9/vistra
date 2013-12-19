package vistra.core.graph.vertex;

import java.awt.geom.Point2D;

import vistra.core.graph.vertex.state.VertexStateHandler;

/**
 * A vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class Vertex extends VertexStateHandler implements IVertex {

	/**
	 * A field for the start.
	 */
	private boolean start;

	/**
	 * A field for the end.
	 */
	private boolean end;

	/**
	 * A field for the distance.
	 */
	private double distance;

	/**
	 * A field for the location.
	 */
	private Point2D location;

	/**
	 * Main constructor.
	 */
	Vertex() {
		super();
		this.start = false;
		this.end = false;
		this.distance = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStart(boolean start) {
		this.start = start;
		if (start)
			this.end = !start;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnd(boolean end) {
		this.end = end;
		if (end)
			this.start = !end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLocation(Point2D location) {
		this.location = location;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isStart() {
		return start;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnd() {
		return end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getDistance() {
		return this.distance;
	};

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Point2D getLocation() {
		return this.location;
	}

}
