package vistra.core.zobsolete.graph.util;

import java.util.Comparator;

import vistra.core.zobsolete.graph.item.edge.IRestrictedEdge;


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
