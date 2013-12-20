package vistra.core.graph.item.vertex;

import java.awt.geom.Point2D;

import vistra.core.graph.item.IGraphItem;
import vistra.core.graph.item.vertex.state.IVertexStateHandler;

/**
 * A vertex interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertex extends IGraphItem, IVertexStateHandler {

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
	 * Returns the distance.
	 * 
	 * @return the distance
	 */
	abstract double getDistance();

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

	/**
	 * Sets the distance.
	 * 
	 */
	abstract void setDistance(double distance);

}