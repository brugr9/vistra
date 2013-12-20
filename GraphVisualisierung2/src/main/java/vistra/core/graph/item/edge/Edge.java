package vistra.core.graph.item.edge;

import vistra.core.graph.GraphPropertyConstants;
import vistra.core.graph.item.edge.state.EdgeStateHandler;

/**
 * An edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class Edge extends EdgeStateHandler implements IEdge {

	/**
	 * A field for the weight.
	 */
	private double weight;

	/**
	 * Main constructor.
	 */
	Edge() {
		super();
		this.weight = GraphPropertyConstants.E_WEIGHT_DEFAULT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getWeight() {
		return weight;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
