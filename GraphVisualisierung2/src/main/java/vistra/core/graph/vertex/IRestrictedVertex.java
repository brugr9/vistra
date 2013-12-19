package vistra.core.graph.vertex;

import java.awt.geom.Point2D;

import vistra.core.graph.vertex.state.IVertexStateHandler;

/**
 * An restricted vertex interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
interface IRestrictedVertex extends IVertexStateHandler {

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

}