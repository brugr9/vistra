package vistra.core.graph.item.vertex;

import java.awt.Color;
import java.awt.geom.Point2D;

import vistra.core.graph.item.AbstractGraphItemModel;

/**
 * A vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Vertex extends AbstractGraphItemModel implements IVertex {

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
	 * A field for the fill color.
	 */
	private Color fillColor;

	/**
	 * Main constructor.
	 */
	Vertex() {
		super();
		this.start = false;
		this.end = false;
		this.value = 0;
		this.fillColor = null;
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
	public Color getFillColor() {
		return fillColor;
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
	public void setValue(double value) {
		this.value = value;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFillColor(Color color) {
		this.fillColor = color;
		this.setChanged();
	}

}
