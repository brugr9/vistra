package vistra.core.graph.item.vertex;

import java.awt.Color;
import java.awt.geom.Point2D;

import vistra.core.graph.GraphMeta;
import vistra.core.graph.item.AbstractItemLayout;
import vistra.util.ColorPalette;
import vistra.util.Convert;

/**
 * An abstract vertex layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLayout extends AbstractItemLayout implements IVertexLayout {

	/**
	 * A field for a vertex to work with.
	 */
	private Vertex vertex;
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
	 * 
	 * @param vertex
	 *            a vertex
	 */
	protected VertexLayout(IVertex vertex) {
		super();
		this.vertex = (Vertex) vertex;
		this.location = Convert.toPoint2D(
				Integer.toString(GraphMeta.V_LOC_X_DEFAULT),
				Integer.toString(GraphMeta.V_LOC_Y_DEFAULT));
		this.fillColor = ColorPalette.orange;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(int value) {
		this.vertex.value = value;
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
	public void setStart(boolean start) {
		this.vertex.start = start;
		// TODO this.handleFocussed();
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnd(boolean end) {
		this.vertex.end = end;
		// TODO this.handleSolved();
		this.setChanged();
	}

	@Override
	public int getValue() {
		return this.vertex.getValue();
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
	public boolean isStart() {
		return this.vertex.isStart();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnd() {
		return this.vertex.isEnd();
	}

}
