package ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractRestrictedGraphItem;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class RestrictedGravisEdge extends AbstractRestrictedGraphItem implements
		IEdge {

	// TODO bitte an dieser Klasse nichts ändern (pk)

	private IEdge edge;

	protected RestrictedGravisEdge(IEdge edge) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge#setWeight(double)
	 */
	@Override
	public void setWeight(double weight) {
		// TODO Exception handling
		throw new UnsupportedOperationException(
				"setWeight: Unsupported operation!");
	}

}
