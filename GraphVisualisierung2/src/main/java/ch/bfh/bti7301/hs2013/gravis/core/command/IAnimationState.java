package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IAnimationState {

	/**
	 * @param oldState
	 * @param currentItem
	 * @return ICommand
	 */
	public abstract ICommand createCommand(IAnimationState oldState,
			IGraphItem currentItem);

	/**
	 * @return ICommand
	 */
	public abstract ICommand getPredecessorCommand();

}
