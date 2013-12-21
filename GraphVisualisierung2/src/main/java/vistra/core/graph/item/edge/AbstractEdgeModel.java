package vistra.core.graph.item.edge;

import vistra.core.graph.item.AbstractGraphItem;
import vistra.util.GraphPropertyConstants;

/**
 * An edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractEdgeModel extends AbstractGraphItem implements
		IEdgeModel {

	/**
	 * A field for the weight.
	 */
	private double weight;

	/**
	 * Main constructor.
	 */
	AbstractEdgeModel() {
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
