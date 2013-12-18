package vistra.core.graph.item.edge;

import vistra.core.graph.item.AbstractRestrictedGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class RestrictedEdge extends AbstractRestrictedGraphItem implements IRestrictedEdge {

	private IEdge edge;

	protected RestrictedEdge(IEdge edge) {
		super(edge);
		this.edge = edge;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge#getWeight()
	 */
	@Override
	public double getWeight() {
		return this.edge.getWeight();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.edge.toString();
	}

	
}
