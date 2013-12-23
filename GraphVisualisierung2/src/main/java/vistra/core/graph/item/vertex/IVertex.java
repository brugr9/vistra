package vistra.core.graph.item.vertex;

import java.awt.Color;
import java.awt.geom.Point2D;

import vistra.core.graph.item.IGraphItemModel;

/**
 * A vertex interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertex extends IGraphItemModel {

	/**
	 * Returns the start.
	 * 
	 * @return the start
	 */
	abstract boolean isStart();

	/**
	 * Returns the end.
	 * 
	 * @return the end
	 */
	abstract boolean isEnd();

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

	/**
	 * Returns the value.
	 * 
	 * @return the value
	 */
	abstract double getValue();

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
	 * Sets the value.
	 * 
	 * @param value
	 *            the value to set
	 */
	abstract void setValue(double value);

}