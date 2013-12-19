package vistra.core.zobsolete.graph.util;

import java.util.Comparator;

import vistra.core.zobsolete.graph.item.IRestrictedGraphItem;


/**
 * This comparator compares graph items in lexicographical id order.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class ItemComparator implements Comparator<IRestrictedGraphItem> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(IRestrictedGraphItem i1, IRestrictedGraphItem i2) {
		return i1.getId().compareTo(i2.getId());
	}

}
