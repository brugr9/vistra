package vistra.core.graph.edge;

/**
 * An edge interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
interface IEdge extends IImmutableEdge {

	/**
	 * Sets the weight.
	 * 
	 * @param weight
	 *            the weight to set
	 */
	abstract void setWeight(double weight);

}