package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

import javax.swing.event.ChangeListener;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class InitialState extends AbstractGenericAnimationState {

	/**
	 * @param graphItemHistory
	 * @param changeListener 
	 */
	protected InitialState(List<IGraphItem> graphItemHistory, ChangeListener changeListener) {
		super(GravisColor.RED, graphItemHistory, changeListener);
	}

}
