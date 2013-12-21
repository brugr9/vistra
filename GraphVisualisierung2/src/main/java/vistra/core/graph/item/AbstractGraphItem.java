package vistra.core.graph.item;

import java.awt.Color;

/**
 * An abstract graph item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AbstractGraphItem implements IGraphItem {

	/**
	 * A field for an identifier.
	 */
	private String id;
	/**
	 * A field for a line width.
	 */
	private float lineWidth;
	/**
	 * A field for a line color.
	 */
	private Color lineColor;
	/**
	 * A field for a font color.
	 */
	private Color fontColor;

	/**
	 * Main constructor.
	 */
	public AbstractGraphItem() {
		this.id = "";
		this.lineWidth = 0;
		this.lineColor = null;
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
	public float getLineWidth() {
		return lineWidth;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getLineColor() {
		return lineColor;
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
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLineWidth(float width) {
		this.lineWidth = width;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLineColor(Color color) {
		this.lineColor = color;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFontColor(Color color) {
		this.fontColor = color;
	}

}
