package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class SolutionState extends AbstractCommonVisualizationState {

	/**
	 * @param graphItemHistory
	 * @param changeListener
	 */
	protected SolutionState(List<IGraphItem> graphItemHistory) {
		super(GravisColor.GREEN, graphItemHistory);
	}

}
