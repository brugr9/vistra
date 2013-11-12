package ch.bfh.bti7301.hs2013.gravis.core.util;

import java.util.Comparator;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class ItemResultComparator implements Comparator<IRestrictedGraphItem> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(IRestrictedGraphItem i1, IRestrictedGraphItem i2) {
		return new Double(i1.getPaintedResult()).intValue()
				- new Double(i2.getPaintedResult()).intValue();
	}

}
