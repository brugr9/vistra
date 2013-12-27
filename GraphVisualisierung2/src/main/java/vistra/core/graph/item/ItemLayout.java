package vistra.core.graph.item;

import java.awt.Color;
import java.util.Observable;

/**
 * An item layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ItemLayout extends Observable implements IItemLayout {

	/**
	 * A field for an identifier.
	 */
	private String id;
	/**
	 * A field for a line width.
	 */
	private float lineWidth;
	/**
	 * A field for a dash.
	 */
	private float[] dash;
	/**
	 * A field for a line colour.
	 */
	private Color lineColor;
	/**
	 * A field for a font style.
	 */
	private int fontStyle;
	/**
	 * A field for a font colour.
	 */
	private Color fontColor;

	/**
	 * Main constructor.
	 */
	ItemLayout() {
		super();
		this.id = "";
		this.lineWidth = 0;
		this.dash = null;
		this.lineColor = null;
		this.fontStyle = 0;
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
	public float[] getDash() {
		return dash;
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
	public int getFontStyle() {
		return fontStyle;
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
	public void setLineWidth(float width) {
		this.lineWidth = width;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDash(float[] dash) {
		this.dash = dash;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLineColor(Color color) {
		this.lineColor = color;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFontStyle(int style) {
		this.fontStyle = style;
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
