package vistra.core.graph.vertex;

import java.awt.geom.Point2D;

/**
 * A vertex interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
interface IVertex extends IRestrictedVertex {

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
	 * @param location
	 *            the location to set
	 */
	abstract void setLocation(Point2D location);

}