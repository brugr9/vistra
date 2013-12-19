package vistra.core.traversal.step;

import java.awt.Color;

import vistra.core.graph.zobsolete.item.IGraphItem;
import vistra.core.graph.zobsolete.item.IRestrictedGraphItem.State;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import vistra.core.util.GraphPropertyConstants;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class SolutionState extends AbstractVisualizationState {

	private final static String V_DO_MSG = "Der Knoten %s wurde zur Lösung hinzugefügt.";
	private final static String E_DO_MSG = "Die Kante %s wurde zur Lösung hinzugefügt.";
	private final static String V_UNDO_MSG = "Der Knoten %s gehört nicht mehr zur Lösung.";
	private final static String E_UNDO_MSG = "Die Kante %s gehört nicht mehr zur Lösung.";
	
	protected SolutionState() {
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
		return State.SOLUTION;
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
		return GraphPropertyConstants.SOLUTION_COLOR;
	}
}
