package vistra.framework.graph.item;

import java.util.Observable;

import vistra.framework.graph.ml.GraphWriter;

/**
 * An edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class Edge extends Observable implements IEdge {

	/**
	 * A field for the weight.
	 */
	int weight;

	/**
	 * Main constructor.
	 */
	Edge() {
		this.weight = GraphWriter.E_WEIGHT_DEFAULT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getWeight() {
		return weight;
	}

}
