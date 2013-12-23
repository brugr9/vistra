package vistra.core.graph.item.vertex;

import java.awt.geom.Point2D;

/**
 * A vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Vertex extends AbstractVertexLayout implements IVertex {

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
		super(0);
		this.start = false;
		this.end = false;
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
	public Point2D getLocation() {
		return location;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStart(boolean start) {
		this.start = start;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnd(boolean end) {
		this.end = end;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLocation(Point2D point) {
		this.location = point;
		this.setChanged();
	}

}
