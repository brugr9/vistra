package vistra.core.zobsolete.graph.item.vertex;

import java.awt.geom.Point2D;

import vistra.core.zobsolete.graph.item.IGraphItem;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertex extends IGraphItem, IRestrictedVertex {

	/**
	 * 
	 * @param width
	 */
	public abstract void setWidth(double width);
	
	/**
	 * 
	 * @param height
	 */
	public abstract void setHeight(double height);

	/**
	 * Sets the start.
	 * 
	 * @param start
	 *            the start to set
	 */
	public abstract void setStart(boolean start);

	/**
	 * Sets the end.
	 * 
	 * @param end
	 *            the end to set
	 */
	public abstract void setEnd(boolean end);

	/**
	 * 
	 * @param location
	 */
	public abstract void setLocation(Point2D location);

}
