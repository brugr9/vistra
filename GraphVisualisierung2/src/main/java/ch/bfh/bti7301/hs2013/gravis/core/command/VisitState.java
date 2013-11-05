package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class VisitState extends AbstractGenericAnimationState {

	/**
	 * @param graphItemHistory
	 */
	protected VisitState(List<IGraphItem> graphItemHistory) {
		super(GravisColor.YELLOW, graphItemHistory);
	}

}
