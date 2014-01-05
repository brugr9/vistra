package vistra.app.view.popup;

import java.awt.geom.Point2D;
import java.util.Observer;

import javax.swing.JFrame;

import vistra.framework.graph.item.IItemLayout;

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
	void setPopupLocation(Point2D location);

	void addPropertyItemListener(JFrame top);

}
