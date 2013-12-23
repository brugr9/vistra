package vistra.core.graph.item.vertex;

import java.awt.Color;

import vistra.core.graph.item.IItem;

/**
 * A vertex layout interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertexLayout extends IItem {

	/**
	 * Returns the fill color.
	 * 
	 * @return the color
	 */
	abstract Color getFillColor();

	/**
	 * Sets the fill color.
	 * 
	 * @param color
	 *            the color to set
	 */
	abstract void setFillColor(Color color);

}
