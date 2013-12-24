package vistra.core.graph.item;

import java.awt.Color;
import java.awt.Font;

/**
 * An item layout interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IItemLayout {

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
	 * Returns the font color.
	 * 
	 * @return the color
	 */
	abstract Color getFontColor();

	/**
	 * Sets the font color.
	 * 
	 * @param color
	 *            the color to set
	 */
	abstract void setFontColor(Color color);

	/**
	 * Returns the font style.
	 * 
	 * @return the style
	 * @see Font
	 */
	abstract int getFontStyle();

	/**
	 * Sets the font style.
	 * 
	 * @param color
	 *            the style to set
	 * @see Font
	 */
	abstract void setFontSyle(int style);

}
