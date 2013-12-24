package vistra.core.graph.item.edge;

import vistra.core.graph.item.IItemLayout;

/**
 * An edge layout interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IEdgeLayout extends IEdge, IItemLayout {

	/**
	 * Sets a value.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value);

}
