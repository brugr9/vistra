package vistra.core.graph.item;

import java.awt.Color;

/**
 * A graph item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGraphItem {

	/**
	 * Sets an identifier.
	 * 
	 * @param id
	 *            the identifier to set
	 */
	abstract void setId(String id);

	/**
	 * Returns an identifier.
	 * 
	 * @return the identifier
	 */
	abstract String getId();

	// both
	abstract float getLineWidth();

	abstract void setLineWidth(float width);

	abstract Color getLineColor();

	abstract void setLineColor(Color color);

	abstract double getFontSize();

	abstract void getFontSize(double size);

	// abstract FontStyle getFontStyle(); // bold, normal
	// abstract void setFontStyle(FontStyle style); // bold, normal
	abstract Color getFontColor();

	abstract void setFontColor(Color color);

	abstract double getValue();

	// vertex
	abstract Color getBGColor();

	abstract void setBGColor(Color color);

	abstract void setValue(double value); // auch zeichen 8

}
