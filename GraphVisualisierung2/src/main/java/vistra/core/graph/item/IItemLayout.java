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
	void setId(String id);

	/**
	 * Sets the stroke.
	 * 
	 * @param stroke
	 *            the stroke
	 */
	void setStroke(Stroke stroke);

	/**
	 * Sets the stroke colour.
	 * 
	 * @param color
	 *            the colour to set
	 */
	void setStrokeColor(Color color);

	/**
	 * Sets the font.
	 * 
	 * @param font
	 *            the font to set
	 * @see Font
	 */
	void setFont(Font font);

	/**
	 * Sets the font colour.
	 * 
	 * @param color
	 *            the colour to set
	 */
	void setFontColor(Color color);

	/**
	 * Returns an identifier.
	 * 
	 * @return the identifier
	 */
	String getId();

	/**
	 * Sets the stroke.
	 * 
	 * @return the stroke
	 */
	Stroke getStroke();

	/**
	 * Returns the stroke colour.
	 * 
	 * @return the colour
	 */
	Color getStrokeColor();

	/**
	 * Returns the font.
	 * 
	 * @return the font
	 * @see Font
	 */
	Font getFont();

	/**
	 * Returns the font colour.
	 * 
	 * @return the colour
	 */
	Color getFontColor();

}
