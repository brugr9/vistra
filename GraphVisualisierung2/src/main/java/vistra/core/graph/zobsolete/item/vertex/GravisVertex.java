package vistra.core.graph.zobsolete.item.vertex;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

import vistra.core.graph.zobsolete.item.AbstractGraphItem;
import vistra.core.util.GraphPropertyConstants;


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

	private Color tempColor;

	/**
	 * Main constructor setting start and end to false both by default.
	 */
	protected GravisVertex() {
		super();

		this.tempColor = this.getCurrentColor();
		this.setStart(GraphPropertyConstants.V_START_DEFAULT);
		this.setEnd(GraphPropertyConstants.V_END_DEFAULT);
		this.width = GraphPropertyConstants.V_WIDTH_DEFAULT;
		this.height = GraphPropertyConstants.V_HEIGHT_DEFAULT;
		this.location = new Point(GraphPropertyConstants.V_LOC_X_DEFAULT,
				GraphPropertyConstants.V_LOC_Y_DEFAULT);
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
		super.setCurrentColor(start ? GraphPropertyConstants.V_START_COLOR : (this
				.isEnd() ? GraphPropertyConstants.V_END_COLOR : this.tempColor));
		this.start = start;
	}

	@Override
	public void setEnd(boolean end) {
		super.setCurrentColor(end ? (this.isStart() ? GraphPropertyConstants.V_START_COLOR
				: GraphPropertyConstants.V_END_COLOR)
				: (this.isStart() ? GraphPropertyConstants.V_START_COLOR
						: this.tempColor));
		this.end = end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem#setColor
	 * (java.awt.Color)
	 */
	@Override
	public void setCurrentColor(Color color) {
		super.setCurrentColor(color);
		this.tempColor = color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IVertex#getLocation()
	 */
	@Override
	public Point2D getLocation() {
		return this.location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.common.IVertex#setLocation(java.awt.geom
	 * .Point2D)
	 */
	@Override
	public void setLocation(Point2D location) {
		this.location = (Point2D) location.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#getWidth()
	 */
	@Override
	public double getWidth() {
		return this.width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#setWidth(
	 * double)
	 */
	@Override
	public void setWidth(double width) {
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#getHeight()
	 */
	@Override
	public double getHeight() {
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#setHeight
	 * (double)
	 */
	@Override
	public void setHeight(double height) {
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem#clone()
	 */
	@Override
	public GravisVertex clone() throws CloneNotSupportedException {
		GravisVertex vertexClone = (GravisVertex) super.clone();
		vertexClone.setLocation((Point2D) this.location.clone());
		return vertexClone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem#
	 * getItemStrokeWidth()
	 */
	@Override
	protected float getDefaultStrokeWidth() {
		return GraphPropertyConstants.V_TAGGED_STROKE;
	}

}
