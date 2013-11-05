package ch.bfh.bti7301.hs2013.gravis.core.util;

import java.util.Comparator;

import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;

/**
 * This comparator compares graph items in lexicographical id order.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class ItemComparator<T extends IGraphItem> implements
		Comparator<IGraphItem> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(IGraphItem i1, IGraphItem i2) {
		return i1.getId().compareTo(i2.getId());
	}

}
