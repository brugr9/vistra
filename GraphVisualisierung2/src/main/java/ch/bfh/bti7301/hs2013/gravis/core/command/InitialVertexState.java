package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class InitialVertexState extends AbstractCommonVisualizationState {

	/**
	 * @param graphItemHistory
	 * @param color
	 */
	protected InitialVertexState(Color color, List<IGraphItem> graphItemHistory) {
		super(color, graphItemHistory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.command.AbstractVisualizationState#
	 * stateDoMessage(ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem)
	 */
	@Override
	public String stateDoMessage(IGraphItem currentItem) {
		return "Der Knoten " + currentItem.getId()
				+ " wurde in den Anfangszustand versetzt.";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.command.AbstractVisualizationState#
	 * stateUndoMessage(ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem)
	 */
	@Override
	public String stateUndoMessage(IGraphItem currentItem) {
		return "Der Knoten " + currentItem.getId()
				+ " befindet sich nicht mehr im  Anfangszustand.";
	}

}