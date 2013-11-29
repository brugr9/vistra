package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisConstants;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class VisitState extends AbstractCommonVisualizationState {

	private State state;
	
	/**
	 * @param graphItemHistory
	 * @param changeListener
	 */
	protected VisitState(List<IGraphItem> graphItemHistory) {
		super(GravisConstants.VISIT_COLOR, graphItemHistory);
		
		this.state = State.VISIT;
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
		if (currentItem instanceof IVertex) {
			return "Der Knoten " + currentItem.getId()
					+ " wurde besucht.";
		}
		
		return "Die Kante " + currentItem.getId()
				+ " wurde besucht.";
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
		if (currentItem instanceof IVertex) {
			return "Der Knoten " + currentItem.getId()
					+ " wird nicht mehr besucht.";
		}
		return "Die Kante " + currentItem.getId()
				+ " wird nicht mehr besucht.";
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IVisualizationState#getState()
	 */
	@Override
	public State getState() {
		return this.state;
	}
}
