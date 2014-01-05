package vistra.framework.graph.item;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * A vertex layout interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertexLayout extends IVertex, IItemLayout {

	/**
	 * Sets the location.
	 * 
	 * @param point
	 *            the point to set
	 */
	void setLocation(Point2D point);

	/**
	 * Sets the fill colour.
	 * 
	 * @param color
	 *            the colour to set
	 */
	void setFillColor(Color color);

	/**
	 * Sets the start.
	 * 
	 * @param start
	 *            the start to set
	 */
	void setStart(boolean start);

	/**
	 * Sets the end.
	 * 
	 * @param end
	 *            the end to set
	 */
	void setEnd(boolean end);

	/**
	 * Sets a value.
	 * 
	 * @param value
	 *            the value to set
	 */
	void setValue(String value);

	/**
	 * Returns the location.
	 * 
	 * @return the location
	 */
	Point2D getLocation();

	/**
	 * Returns the fill colour.
	 * 
	 * @return the colour
	 */
	Color getFillColor();

}
