package ch.bfh.bti7301.hs2013.gravis.core.step;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisConstants;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ActivationState extends AbstractVisualizationState {

	private final static String V_DO_MSG = "Der Knoten %s wurde aktiviert.";
	private final static String E_DO_MSG = "Die Kante %s wurde aktiviert.";
	private final static String V_UNDO_MSG = "Der Knoten %s ist nicht mehr aktiviert.";
	private final static String E_UNDO_MSG = "Die Kante %s ist nicht mehr aktiviert.";
	
	protected ActivationState() {
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
	 * ch.bfh.bti7301.hs2013.gravis.core.step.IVisualizationState#getState()
	 */
	@Override
	public State getState() {
		return State.ACTIVATION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.step.AbstractVisualizationState#
	 * getStateColor()
	 */
	@Override
	protected Color getStateColor() {
		return GravisConstants.ACTIVATION_COLOR;
	}
}
