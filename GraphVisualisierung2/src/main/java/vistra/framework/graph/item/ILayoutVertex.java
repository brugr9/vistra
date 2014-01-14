package vistra.framework.graph.item;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * A layout vertex interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see Layout<V, E>
 */
public interface ILayoutVertex extends IVertex, ILayoutItem {

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
	 * Sets the visited.
	 * 
	 * @param visited
	 *            the visited to set
	 */
	void setVisited(boolean visited);

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

	/**
	 * Returns the value. If the vertex is initialized, the sign for infinity
	 * will be returned ( {@code SigmaPalette.infinity}). If the vertex is
	 * whether initialized nor holding a value, an empty string will be
	 * returned.
	 * 
	 * @return the value
	 */
	String getValue();

}
