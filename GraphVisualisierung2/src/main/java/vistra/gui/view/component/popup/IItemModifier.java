package vistra.gui.view.component.popup;

import java.awt.geom.Point2D;

import vistra.core.zobsolete.graph.item.IGraphItem;

/**
 * A graph item modifier interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IItemModifier {

	/**
	 * Sets the graph item and the view.
	 * 
	 * @param item
	 *            the item to set
	 */
	public abstract void setGraphItemAndView(IGraphItem item);

	/**
	 * Sets the graph item location.
	 * 
	 * @param location
	 *            the location to set
	 */
	public abstract void setGraphItemLocation(Point2D location);
}
