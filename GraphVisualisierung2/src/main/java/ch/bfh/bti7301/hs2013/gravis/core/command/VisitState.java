package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisConstants;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class VisitState extends AbstractVisualizationState {

	private final static String V_DO_MSG = "Der Knoten %s wurde besucht.";
	private final static String E_DO_MSG = "Die Kante %s wurde besucht.";
	private final static String V_UNDO_MSG = "Der Knoten %s wird nicht mehr besucht.";
	private final static String E_UNDO_MSG = "Die Kante %s wird nicht mehr besucht.";

	protected VisitState() {
		super();
	}

	@Override
	public String getStateDoMessage(IGraphItem currentItem) {
		if (currentItem instanceof IVertex) {
			return String.format(V_DO_MSG, currentItem.getId());
		}

		return String.format(E_DO_MSG, currentItem.getId());
	}

	@Override
	public String getStateUndoMessage(IGraphItem currentItem) {
		if (currentItem instanceof IVertex) {
			return String.format(V_UNDO_MSG, currentItem.getId());
		}
		return String.format(E_UNDO_MSG, currentItem.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.command.IVisualizationState#getState()
	 */
	@Override
	public State getState() {
		return State.VISIT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.command.AbstractVisualizationState#
	 * getStateColor()
	 */
	@Override
	protected Color getStateColor() {
		return GravisConstants.VISIT_COLOR;
	}
}
