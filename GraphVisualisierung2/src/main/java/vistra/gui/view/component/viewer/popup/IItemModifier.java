package vistra.gui.view.component.viewer.popup;

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
	public abstract void setGraphItemAndView(IItemLayout item);

	/**
	 * Sets the graph item location.
	 * 
	 * @param location
	 *            the location to set
	 */
	public abstract void setGraphItemLocation(Point2D location);
}
