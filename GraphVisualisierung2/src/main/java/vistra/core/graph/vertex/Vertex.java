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
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.core.graph.vertex.IVertex#setStart(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStart(boolean start) {
		this.start = start;
		if (start)
			this.end = !start;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.core.graph.vertex.IVertex#setEnd(boolean)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnd(boolean end) {
		this.end = end;
		if (end)
			this.start = !end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.core.graph.vertex.IVertex#setLocation(java.awt.geom.Point2D)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLocation(Point2D location) {
		this.location = location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.core.graph.vertex.IVertex#isStart()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isStart() {
		return start;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.core.graph.vertex.IVertex#isEnd()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnd() {
		return end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.core.graph.vertex.IVertex#getLocation()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Point2D getLocation() {
		return this.location;
	};

}
