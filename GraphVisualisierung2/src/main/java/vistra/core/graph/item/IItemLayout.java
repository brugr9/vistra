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
	 * Sets an identifier.
	 * 
	 * @param id
	 *            the identifier to set
	 */
	abstract void setId(String id);

	/**
	 * Sets the line width.
	 * 
	 * @param width
	 *            the width to set
	 */
	abstract void setLineWidth(float width);

	/**
	 * Sets an array of float representing a dash pattern (null means solid).
	 * 
	 * @param dash
	 *            the dash pattern
	 */
	abstract void setDash(float[] dash);

	/**
	 * Sets the line colour.
	 * 
	 * @param color
	 *            the colour to set
	 */
	abstract void setLineColor(Color color);

	/**
	 * Sets the font style.
	 * 
	 * @param color
	 *            the style to set
	 * @see Font
	 */
	abstract void setFontStyle(int style);

	/**
	 * Sets the font colour.
	 * 
	 * @param color
	 *            the colour to set
	 */
	abstract void setFontColor(Color color);

	/**
	 * Returns an identifier.
	 * 
	 * @return the identifier
	 */
	abstract String getId();

	/**
	 * Returns the line width.
	 * 
	 * @return the width
	 */
	abstract float getLineWidth();

	/**
	 * Returns an array of float representing a dash pattern (null means solid).
	 * 
	 * @return the dash pattern
	 */
	abstract float[] getDash();

	/**
	 * Returns the stroke colour.
	 * 
	 * @return the colour
	 */
	abstract Color getStrokeColor();

	/**
	 * Returns the font style.
	 * 
	 * @return the style
	 * @see Font
	 */
	abstract int getFontStyle();

	/**
	 * Returns the font colour.
	 * 
	 * @return the colour
	 */
	abstract Color getFontColor();

}
