package vistra.core.zobsolete.graph.item.vertex;

import java.awt.geom.Point2D;

import vistra.core.zobsolete.graph.item.IRestrictedGraphItem;



/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public interface IRestrictedVertex extends IRestrictedGraphItem {

	/**
	 * Returns <code>true</code> if this is a start.
	 * 
	 * @return <code>true</code> if this is a start
	 */
	public abstract boolean isStart();

	/**
	 * Returns <code>true</code> if this is an end.
	 * 
	 * @return Returns <code>true</code> if this is an end.
	 */
	public abstract boolean isEnd();

	/**
	 * 
	 * @return double
	 */
	public abstract double getWidth();
	
	/**
	 * 
	 * @return double
	 */
	public abstract double getHeight();
	
	/**
	 * @return Point2D
	 */
	public abstract Point2D getLocation();

	
}
