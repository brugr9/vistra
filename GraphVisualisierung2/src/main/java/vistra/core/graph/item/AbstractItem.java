package vistra.core.graph.item;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;

import vistra.core.graph.GraphFactory;
import vistra.util.ColorPalette;

/**
 * An abstract item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AbstractItem extends Observable implements IItem {

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
	 * A field for a font style.
	 */
	private int fontStyle;
	/**
	 * A field for value.
	 */
	private double value;

	/**
	 * Main constructor.
	 */
	public AbstractItem(double value) {
		this.id = "";
		this.lineWidth = GraphFactory.STROKE_WIDTH_DEFAULT;
		this.lineColor = ColorPalette.darkblue;
		this.fontColor = ColorPalette.darkblue;
		this.fontStyle = Font.PLAIN;
		this.value = value;
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
	public void setId(String id) {
		this.id = id;
		this.setChanged();
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
	public void setValue(double value) {
		this.value = value;
		this.setChanged();
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
	public int getFontStyle() {
		return fontStyle;
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
	public void setLineColor(Color color) {
		this.lineColor = color;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFontSyle(int style) {
		this.fontStyle = style;
		this.setChanged();
	}
}
