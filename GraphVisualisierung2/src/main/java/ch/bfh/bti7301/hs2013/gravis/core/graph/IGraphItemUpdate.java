package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IGraphItemUpdate<I extends IRestrictedGraphItem> {

	/**
	 * Traversal state will be set to the value of state argument for all
	 * graphItems.
	 * 
	 * @param array
	 *            of graphItems
	 * @param state
	 */
	@SuppressWarnings("unchecked")
	public abstract void updateState(State state, I... graphItems);

	/**
	 * Each graphItem has own traversal state.
	 * 
	 * @param array
	 *            of graphItems
	 */
	@SuppressWarnings("unchecked")
	public abstract void updateState(I... graphItems);

}
