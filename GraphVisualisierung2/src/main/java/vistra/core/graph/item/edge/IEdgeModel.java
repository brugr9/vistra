package vistra.core.graph.item.edge;

import vistra.core.graph.item.IGraphItemModel;

/**
 * An edge interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
interface IEdgeModel extends IGraphItemModel {

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