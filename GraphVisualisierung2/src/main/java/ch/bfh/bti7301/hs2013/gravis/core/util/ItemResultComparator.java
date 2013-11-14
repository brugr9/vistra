package ch.bfh.bti7301.hs2013.gravis.core.util;

import java.util.Comparator;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class ItemResultComparator implements Comparator<IRestrictedGraphItem> {

	private final double EPSILON = 0.001;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(IRestrictedGraphItem i1, IRestrictedGraphItem i2) {
		// result = r1 - r2
		double result = i1.getPaintedResult() - i2.getPaintedResult();
		
		// |r1 - r2| < EPSILON => r1 - r2 = 0
		if (Math.abs(result) < EPSILON) {
			return 0;
		}
		
		// r1 - r2 > 0
		if (result > 0) {
			return 1;
		}
		
		// r1 - r2 < 0
		return -1;
	}

}
