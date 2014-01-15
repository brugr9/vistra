package vistra.framework.graph.item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

/**
 * A layout edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see Layout<V, E>
 */
public class LayoutEdge extends Edge implements ILayoutEdge {

	/**
	 * A field for an item layout to work with.
	 */
	private LayoutItem layout;
	/**
	 * A field for an arrow stroke.
	 */
	private Stroke arrowStroke;

	/**
	 * Main constructor.
	 */
	public LayoutEdge() {
		super();
		this.layout = new LayoutItem();
		this.arrowStroke = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
		this.setChanged();
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
	public void setStroke(Stroke storke) {
		this.layout.setStroke(storke);
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
	public void setArrowStroke(Stroke stroke) {
		this.arrowStroke = stroke;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stroke getArrowStroke() {
		return this.arrowStroke;
	}

}
