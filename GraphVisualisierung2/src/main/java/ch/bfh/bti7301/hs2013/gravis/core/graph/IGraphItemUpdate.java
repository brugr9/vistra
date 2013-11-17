package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IGraphItemUpdate<I extends IRestrictedGraphItem> {

	/**
	 * @param graphItem
	 * @param state
	 */
	public abstract void updateState(I graphItem, State state);

}
