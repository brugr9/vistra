package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IVisualizationState {

	/**
	 * @param oldState
	 * @param currentItem
	 * @return ICommand
	 */
	public abstract ICommand createCommand(IVisualizationState oldState,
			IGraphItem currentItem);

	/**
	 * @return ICommand
	 */
	public abstract ICommand getPredecessorCommand();
	
	/**
	 * @return old graph item clone
	 */
	public abstract IGraphItem getOldGraphItemClone();

}
