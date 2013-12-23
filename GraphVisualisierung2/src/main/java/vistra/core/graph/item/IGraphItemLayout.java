package vistra.core.graph.item;

import java.awt.Color;

/**
 * A graph item layout inteface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGraphItemLayout {

	/**
	 * Returns the line width.
	 * 
	 * @return the width
	 */
	abstract float getLineWidth();

	/**
	 * Sets the line width.
	 * 
	 * @param width
	 *            the width to set
	 */
	abstract void setLineWidth(float width);

	/**
	 * Returns the line color.
	 * 
	 * @return the color
	 */
	abstract Color getLineColor();

	/**
	 * Sets the line color.
	 * 
	 * @param color
	 *            the color to set
	 */
	abstract void setLineColor(Color color);

	/**
	 * Returns the line color.
	 * 
	 * @return the color
	 */
	abstract Color getFontColor();

	/**
	 * Sets the line color.
	 * 
	 * @param color
	 *            the color to set
	 */
	abstract void setFontColor(Color color);
}
