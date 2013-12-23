package vistra.core.graph.item.vertex;

import java.awt.geom.Point2D;

/**
 * A vertex interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertex extends IVertexLayout {

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

}