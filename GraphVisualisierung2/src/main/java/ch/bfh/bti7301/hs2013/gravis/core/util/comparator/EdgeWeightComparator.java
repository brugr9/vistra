package ch.bfh.bti7301.hs2013.gravis.core.util.comparator;

import java.util.Comparator;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class EdgeWeightComparator implements Comparator<IRestrictedEdge> {

	public EdgeWeightComparator() {
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.IRestrictedEdge, java.lang.IRestrictedEdge)
	 */
	@Override
	public int compare(IRestrictedEdge e1, IRestrictedEdge e2) {
		return Double.compare(e1.getWeight(), e2.getWeight());
	}

}
