package vistra.gui.view.mouse.popup;

import java.awt.geom.Point2D;

import vistra.core.graph.item.IItemLayout;

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
	void setGraphItemAndView(IItemLayout item);

	/**
	 * Sets the graph item location.
	 * 
	 * @param location
	 *            the location to set
	 */
	void setGraphItemLocation(Point2D location);
}
