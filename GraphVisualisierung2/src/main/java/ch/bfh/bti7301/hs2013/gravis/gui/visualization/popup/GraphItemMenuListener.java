package ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup;

import java.awt.geom.Point2D;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public interface GraphItemMenuListener {

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
