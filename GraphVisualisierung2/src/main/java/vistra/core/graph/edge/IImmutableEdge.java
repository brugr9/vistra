package vistra.core.graph.edge;

import vistra.core.graph.edge.state.IEdgeStateHandler;

/**
 * An immutable edge interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
interface IImmutableEdge extends IEdgeStateHandler {

	/**
	 * Returns the weight.
	 * 
	 * @return the weight
	 */
	abstract double getWeight();

}