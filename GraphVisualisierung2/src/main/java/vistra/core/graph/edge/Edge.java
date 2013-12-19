package vistra.core.graph.edge;

import vistra.core.graph.edge.state.EdgeStateHandler;

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
		this.weight = 1.0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.core.graph.edge.IEdge#getWeight()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getWeight() {
		return weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vistra.core.graph.edge.IEdge#setWeight(double)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
