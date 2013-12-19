package vistra.core.zobsolete.traversal.step;

import java.awt.Color;

import vistra.core.zobsolete.graph.item.IGraphItem;
import vistra.core.zobsolete.graph.item.IRestrictedGraphItem.State;
import vistra.core.zobsolete.graph.util.GraphPropertyConstants;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class InitialEdgeState extends AbstractVisualizationState {

	private final static String E_DO_MSG = "Die Kante %s befindet sich im Anfangszustand.";
	private final static String E_UNDO_MSG = "Die Kante %s befindet sich nicht mehr im "
			+ "Anfangszustand.";

	public InitialEdgeState() {
		super();
	}

	@Override
	public String getStateDoMessage(IGraphItem currentItem) {
		return String.format(E_DO_MSG, currentItem.getId());
	}

	@Override
	public String getStateUndoMessage(IGraphItem currentItem) {
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
		return State.INITIAL;
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
		return GraphPropertyConstants.E_INITIAL_COLOR;
	}

}
