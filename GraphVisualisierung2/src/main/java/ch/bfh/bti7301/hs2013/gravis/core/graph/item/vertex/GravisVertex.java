package ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex;

import java.awt.Point;
import java.awt.geom.Point2D;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem;

/**
 * A vertex.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class GravisVertex extends AbstractGraphItem implements IVertex {

	/**
	 * A field for the start position.
	 */
	private boolean start;
	
	/**
	 * A field for the end position.
	 */
	private boolean end;
	
	private double width;
	
	private double height;
	
	private Point2D location;
	
	/**
	 * Main constructor setting start and end to false both by default.
	 */
	protected GravisVertex() {
		super();
		
		this.start = false;
		this.end = false;
		this.width = 60.0;
		this.height = 40.0;
		this.location = new Point();
	}

	@Override
	public boolean isStart() {
		return this.start;
	}

	@Override
	public boolean isEnd() {
		return this.end;
	}

	@Override
	public void setStart(boolean start) {
		this.start = start;
	}

	@Override
	public void setEnd(boolean end) {
		this.end = end;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IVertex#getLocation()
	 */
	@Override
	public Point2D getLocation() {
		return this.location;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IVertex#setLocation(java.awt.geom.Point2D)
	 */
	@Override
	public void setLocation(Point2D location) {
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#getWidth()
	 */
	@Override
	public double getWidth() {
		return this.width;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#setWidth(double)
	 */
	@Override
	public void setWidth(double width) {
		this.width = width;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#getHeight()
	 */
	@Override
	public double getHeight() {
		return this.height;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#setHeight(double)
	 */
	@Override
	public void setHeight(double height) {
		this.height = height;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	
}
