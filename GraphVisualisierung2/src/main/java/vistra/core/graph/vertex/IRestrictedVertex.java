package vistra.core.graph.vertex;

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
	 * Sets the distance.
	 * 
	 * @param distance
	 */
	abstract void setDistance(double distance);

	/**
	 * Returns the distance.
	 * 
	 * @return the distance
	 */
	abstract double getDistance();

}