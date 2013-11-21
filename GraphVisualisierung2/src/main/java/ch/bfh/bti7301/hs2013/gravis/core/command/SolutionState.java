package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class SolutionState extends AbstractGenericAnimationState {

	/**
	 * @param graphItemHistory
	 * @param changeListener
	 */
	protected SolutionState(List<IGraphItem> graphItemHistory,
			TraversalChangeListener changeListener) {
		super(GravisColor.GREEN, graphItemHistory, changeListener);
	}

}
