package vistra.core.graph.item.edge;

import vistra.core.graph.item.IGraphItem;
import vistra.core.graph.item.edge.state.IEdgeStateHandler;

/**
 * An edge interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IEdge extends IGraphItem, IEdgeStateHandler {

	/**
	 * Sets the weight.
	 * 
	 * @param weight
	 *            the weight to set
	 */
	abstract void setWeight(double weight);

	/**
	 * Returns the weight.
	 * 
	 * @return the weight
	 */
	abstract double getWeight();

}