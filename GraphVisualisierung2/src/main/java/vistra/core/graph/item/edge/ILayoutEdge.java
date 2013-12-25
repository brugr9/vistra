package vistra.core.graph.item.edge;

import vistra.core.graph.item.ILayoutItem;

/**
 * An edge layout interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ILayoutEdge extends IEdge, ILayoutItem {

	/**
	 * Sets a weight.
	 * 
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight);

}
