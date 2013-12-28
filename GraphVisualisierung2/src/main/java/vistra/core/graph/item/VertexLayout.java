package vistra.core.graph.item;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * A vertex layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLayout extends Vertex implements IVertexLayout {

	/**
	 * A field for an item layout to work with.
	 */
	private ItemLayout layout;
	/**
	 * A field for the location.
	 */
	private Point2D location;
	/**
	 * A field for the fill colour.
	 */
	private Color fillColor;

	/**
	 * Main constructor.
	 */
	protected VertexLayout() {
		super();
		this.layout = new ItemLayout();
		this.location = null;
		this.fillColor = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStart(boolean start) {
		this.start = start;
		this.setChanged();
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
	public void setValue(int value) {
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
	public void setId(String id) {
		this.layout.setId(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLineWidth(float width) {
		this.layout.setLineWidth(width);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDash(float[] dash) {
		this.layout.setDash(dash);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLineColor(Color color) {
		this.layout.setLineColor(color);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFontStyle(int style) {
		this.layout.setFontStyle(style);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFontColor(Color color) {
		this.layout.setFontColor(color);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return this.layout.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public float getLineWidth() {
		return this.layout.getLineWidth();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public float[] getDash() {
		return this.layout.getDash();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getStrokeColor() {
		return this.layout.getStrokeColor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getFontStyle() {
		return this.layout.getFontStyle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getFontColor() {
		return this.layout.getFontColor();
	}

}
