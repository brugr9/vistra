package vistra.framework.graph.item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.util.Observable;

/**
 * A layout item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see Layout<V, E>
 */
class LayoutItem extends Observable implements ILayoutItem {

	/**
	 * A field for an identifier.
	 */
	private String id;
	/**
	 * A field for a stroke.
	 */
	private Stroke stroke;
	/**
	 * A field for a line colour.
	 */
	private Color strokeColor;
	/**
	 * A field for a font.
	 */
	private Font font;
	/**
	 * A field for a font colour.
	 */
	private Color fontColor;

	/**
	 * Main constructor.
	 */
	LayoutItem() {
		super();
		this.id = "";
		this.stroke = null;
		this.strokeColor = null;
		this.font = null;
		this.fontColor = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stroke getStroke() {
		return stroke;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getStrokeColor() {
		return strokeColor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Font getFont() {
		return font;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getFontColor() {
		return fontColor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String id) {
		this.id = id;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStrokeColor(Color color) {
		this.strokeColor = color;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFont(Font font) {
		this.font = font;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFontColor(Color color) {
		this.fontColor = color;
		this.setChanged();
	}

}
