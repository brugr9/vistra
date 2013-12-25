package vistra.core.graph.item.vertex;

import java.awt.Color;
import java.awt.geom.Point2D;

import vistra.core.graph.item.ILayoutItem;

/**
 * A vertex layout interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ILayoutVertex extends IVertex, ILayoutItem {

	/**
	 * Sets the location.
	 * 
	 * @param point
	 *            the point to set
	 */
	abstract void setLocation(Point2D point);

	/**
	 * Sets the fill color.
	 * 
	 * @param color
	 *            the color to set
	 */
	abstract void setFillColor(Color color);

	/**
	 * Sets the start.
	 * 
	 * @param start
	 *            the start to set
	 */
	abstract void setStart(boolean start);

	/**
	 * Sets the end.
	 * 
	 * @param end
	 *            the end to set
	 */
	abstract void setEnd(boolean end);

	/**
	 * Sets a value.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value);

	/**
	 * Returns the location.
	 * 
	 * @return the location
	 */
	abstract Point2D getLocation();

	/**
	 * Returns the fill color.
	 * 
	 * @return the color
	 */
	abstract Color getFillColor();

}
