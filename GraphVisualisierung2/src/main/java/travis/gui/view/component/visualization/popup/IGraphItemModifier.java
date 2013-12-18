package travis.gui.view.component.visualization.popup;

import java.awt.geom.Point2D;

import travis.core.graph.item.IGraphItem;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public interface IGraphItemModifier {

	/**
	 * 
	 * @param item
	 */
	public abstract void setGraphItemAndView(IGraphItem item);
	
	/**
	 * 
	 * @param point
	 */
	public abstract void setGraphItemLocation(Point2D point);
}
