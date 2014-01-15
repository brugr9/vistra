package vistra.app.view.component.mouse;

import java.awt.geom.Point2D;
import java.util.Observer;

import vistra.framework.graph.item.ILayoutItem;

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
	void setItem(ILayoutItem item);

	/**
	 * Sets the location.
	 * 
	 * @param location
	 *            the location to set
	 */
	void setPopupLocation(Point2D location);

}
