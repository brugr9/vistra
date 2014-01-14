package vistra.framework.graph.item;

/**
 * An layout edge interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see Layout<V, E>
 */
public interface ILayoutEdge extends IEdge, ILayoutItem {

	/**
	 * Sets a weight.
	 * 
	 * @param weight
	 *            the weight to set
	 */
	void setWeight(int weight);

}
