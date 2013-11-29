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
class SolutionState extends AbstractCommonVisualizationState {

	private State state;
	
	/**
	 * @param graphItemHistory
	 * @param changeListener
	 */
	protected SolutionState(List<IGraphItem> graphItemHistory) {
		super(GravisConstants.SOLUTION_COLOR, graphItemHistory);
		
		this.state = State.SOLUTION;
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
					+ " wurde zur Lösung hinzugefügt.";
		}
		
		return "Die Kante " + currentItem.getId()
				+ " wurde zur Lösung hinzugefügt.";
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
					+ " gehört nicht mehr zur Lösung.";
		}
		return "Die Kante " + currentItem.getId()
				+ " gehört nicht mehr zur Lösung.";
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IVisualizationState#getState()
	 */
	@Override
	public State getState() {
		return this.state;
	}
}
