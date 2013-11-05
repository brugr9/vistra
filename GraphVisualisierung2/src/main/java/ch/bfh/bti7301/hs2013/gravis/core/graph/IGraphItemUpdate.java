package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IGraphItemUpdate<I extends IGraphItem> {

	/**
	 * 
	 * @param graphItem
	 */
	public abstract void updateState(I graphItem);

}
