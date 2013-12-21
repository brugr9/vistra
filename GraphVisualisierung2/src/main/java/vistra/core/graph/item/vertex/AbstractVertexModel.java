package vistra.core.graph.item.vertex;

import java.awt.Color;
import java.awt.geom.Point2D;

import vistra.core.graph.item.AbstractGraphItem;

/**
 * A vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractVertexModel extends AbstractGraphItem implements IVertexModel {

	/**
	 * A field for the start.
	 */
	private boolean start;

	/**
	 * A field for the end.
	 */
	private boolean end;

	/**
	 * A field for the value.
	 */
	private double value;

	/**
	 * A field for the location.
	 */
	private Point2D location;

	/**
	 * A field for the background color.
	 */
	private Color bgColor;

	/**
	 * Main constructor.
	 */
	AbstractVertexModel() {
		super();
		this.start = false;
		this.end = false;
		this.value = 0;
		this.bgColor = null;
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
	public double getValue() {
		return value;
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
	public Color getBgColor() {
		return bgColor;
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
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLocation(Point2D point) {
		this.location = point;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBgColor(Color color) {
		this.bgColor = color;
	}

}
