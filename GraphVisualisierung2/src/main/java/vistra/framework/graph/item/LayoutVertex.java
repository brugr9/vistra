package vistra.framework.graph.item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 * A layout vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see Layout<V, E>
 */
public class LayoutVertex extends Vertex implements ILayoutVertex {

	/**
	 * A field for a layout item to work with.
	 */
	private LayoutItem layout;
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
	protected LayoutVertex() {
		super();
		this.layout = new LayoutItem();
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
	public void setVisited(boolean visited) {
		this.visited = visited;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(String value) {
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
	public void setStroke(Stroke stroke) {
		this.layout.setStroke(stroke);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStrokeColor(Color color) {
		this.layout.setStrokeColor(color);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFont(Font font) {
		this.layout.setFont(font);
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
	public Stroke getStroke() {
		return this.layout.getStroke();
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
	public Font getFont() {
		return this.layout.getFont();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getFontColor() {
		return this.layout.getFontColor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getValue() {
		return this.value;
	}
}
