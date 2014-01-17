package vistra.framework.graph.item;

import java.awt.Stroke;

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

	/**
	 * Sets a visited.
	 * 
	 * @param visited
	 *            the visited to set
	 */
	public void setVisited(boolean visited);

	/**
	 * Sets the arrow stroke.
	 * 
	 * @param stroke
	 *            the arrow stroke
	 */
	void setArrowStroke(Stroke stroke);

	/**
	 * Retruns the arrow stroke.
	 * 
	 * @return the arrow stroke
	 */
	Stroke getArrowStroke();

}
