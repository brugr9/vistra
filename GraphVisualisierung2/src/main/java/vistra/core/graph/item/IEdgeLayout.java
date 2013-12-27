package vistra.core.graph.item;


/**
 * An edge layout interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IEdgeLayout extends IEdge, IItemLayout {

	/**
	 * Sets a weight.
	 * 
	 * @param weight
	 *            the weight to set
	 */
	abstract void setWeight(int weight);

}
