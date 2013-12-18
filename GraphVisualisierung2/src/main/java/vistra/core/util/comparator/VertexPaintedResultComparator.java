package vistra.core.util.comparator;

import java.util.Comparator;

import vistra.core.graph.item.vertex.IRestrictedVertex;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class VertexPaintedResultComparator implements Comparator<IRestrictedVertex> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(IRestrictedVertex v1, IRestrictedVertex v2) {
		return Double.compare(v1.getCurrentResult(), v2.getCurrentResult());
	}

}
