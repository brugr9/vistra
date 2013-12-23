package vistra.core.graph.item.vertex;

import java.awt.Color;

import vistra.core.graph.item.AbstractItem;

/**
 * An abstract vertex layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractVertexLayout extends AbstractItem implements
		IVertexLayout {

	/**
	 * A field for the fill color.
	 */
	private Color fillColor;

	/**
	 * Main constructor.
	 * 
	 * @param value
	 *            a value
	 */
	AbstractVertexLayout(double value) {
		super(value);
		this.fillColor = null;
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
	public void setFillColor(Color color) {
		this.fillColor = color;
		this.setChanged();
	}

}
