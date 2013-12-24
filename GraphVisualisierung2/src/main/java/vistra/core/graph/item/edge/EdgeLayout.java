package vistra.core.graph.item.edge;

import vistra.core.graph.item.AbstractItemLayout;

/**
 * An abstract edge layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeLayout extends AbstractItemLayout implements IEdgeLayout {

	/**
	 * A field for a vertex to work with.
	 */
	private Edge edge;

	/**
	 * Main constructor.
	 * 
	 * @param edge
	 *            an edge
	 */
	EdgeLayout(IEdge edge) {
		super();
		this.edge = (Edge) edge;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getWeight() {
		return this.edge.getWeight();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setWeight(int weight) {
		this.edge.weight = weight;
		this.setChanged();
	}

}
