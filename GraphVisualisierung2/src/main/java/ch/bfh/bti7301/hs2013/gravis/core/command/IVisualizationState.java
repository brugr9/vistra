package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IVisualizationState {

	/**
	 * @param currentItem
	 * @return IStep
	 */
	public abstract IStep createCommand(IGraphItem currentItem);

	/**
	 * @return State
	 */
	public abstract State getState();

}
