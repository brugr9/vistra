package vistra.gui.view.mouse.popup;

import java.awt.geom.Point2D;
import java.util.Observer;

import vistra.core.graph.item.IItemLayout;

/**
 * An item pop-up menu interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IItemPopup extends Observer {

	/**
	 * Sets the item.
	 * 
	 * @param item
	 *            the item to set
	 */
	void setItem(IItemLayout item);

	/**
	 * Sets the location.
	 * 
	 * @param location
	 *            the location to set
	 */
	void setItemLocation(Point2D location);
}