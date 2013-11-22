package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class InitialState extends AbstractCommonVisualizationState {

	/**
	 * @param graphItemHistory
	 * @param changeListener
	 * @param color
	 */
	protected InitialState(Color color, List<IGraphItem> graphItemHistory,
			TraversalChangeListener changeListener) {
		super(color, graphItemHistory, changeListener);
	}

}
