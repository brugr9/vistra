package vistra.core.zobsolete.traversal.step;

import vistra.core.zobsolete.graph.item.IGraphItem;
import vistra.core.zobsolete.graph.item.IRestrictedGraphItem.State;

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
