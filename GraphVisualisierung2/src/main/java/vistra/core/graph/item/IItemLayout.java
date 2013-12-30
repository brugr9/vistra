package vistra.core.graph.item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

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
	 * Sets the stroke.
	 * 
	 * @param stroke
	 *            the stroke
	 */
	abstract void setStroke(Stroke stroke);

	/**
	 * Sets the stroke colour.
	 * 
	 * @param color
	 *            the colour to set
	 */
	abstract void setStrokeColor(Color color);

	/**
	 * Sets the font.
	 * 
	 * @param font
	 *            the font to set
	 * @see Font
	 */
	abstract void setFont(Font font);

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
	 * Sets the stroke.
	 * 
	 * @return the stroke
	 */
	abstract Stroke getStroke();

	/**
	 * Returns the stroke colour.
	 * 
	 * @return the colour
	 */
	abstract Color getStrokeColor();

	/**
	 * Returns the font.
	 * 
	 * @return the font
	 * @see Font
	 */
	abstract Font getFont();

	/**
	 * Returns the font colour.
	 * 
	 * @return the colour
	 */
	abstract Color getFontColor();

}
