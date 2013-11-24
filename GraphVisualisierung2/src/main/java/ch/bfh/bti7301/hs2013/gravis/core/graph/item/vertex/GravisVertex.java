package ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * A vertex.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class GravisVertex extends AbstractGraphItem implements IVertex {

	private final static Color START_COLOR = GravisColor.GRAY;
	
	private final static Color END_COLOR = GravisColor.ORANGE;
	
	private final static  double DEFAULT_WIDTH = 60.0;
	
	private final static double DEFAULT_HEIGHT = 40.0;
	
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
	
	private Color tempColor;
	
	/**
	 * Main constructor setting start and end to false both by default.
	 */
	protected GravisVertex() {
		super();
		
		this.tempColor = this.getColor();
		this.setStart(false);
		this.setEnd(false);
		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;
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
		super.setColor(start ? START_COLOR : (this.isEnd() ? END_COLOR : this.tempColor));
		this.start = start;
	}

	@Override
	public void setEnd(boolean end) {
		super.setColor(end ? (this.isStart() ? START_COLOR : END_COLOR) : 
			(this.isStart() ? START_COLOR : this.tempColor));
		this.end = end;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem#setColor(java.awt.Color)
	 */
	@Override
	public void setColor(Color color) {
		super.setColor(color);
		this.tempColor = color;
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

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem#clone()
	 */
	@Override
	public GravisVertex clone() throws CloneNotSupportedException {
		GravisVertex vertexClone = (GravisVertex) super.clone();
		vertexClone.setLocation((Point2D) this.location.clone());
		return vertexClone;
	}

	
}
