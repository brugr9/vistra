package ch.bfh.bti7301.hs2013.gravis.core.traversal.step;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.GraphPropertyConstants;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class InitialVertexState extends AbstractVisualizationState {

	private final static String V_DO_MSG = "Der Knoten %s wurde in den Anfangszustand versetzt.";
	private final static String V_UNDO_MSG = "Der Knoten %s befindet sich nicht mehr im  Anfangszustand.";

	protected InitialVertexState() {
		super();
	}

	@Override
	public String getStateDoMessage(IGraphItem currentItem) {
		return String.format(V_DO_MSG, currentItem.getId());
	}

	@Override
	public String getStateUndoMessage(IGraphItem currentItem) {
		return String.format(V_UNDO_MSG, currentItem.getId());
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
		return GraphPropertyConstants.V_INITIAL_COLOR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.step.AbstractVisualizationState#
	 * setNewColor(ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem)
	 */
	@Override
	protected void setNewColor(IGraphItem currentItem) {
		if (currentItem instanceof IVertex) {
			IVertex vertex = (IVertex) currentItem;
			
			if (vertex.isStart()) {
				currentItem.setNewColor(GraphPropertyConstants.V_START_COLOR);
			} else if(vertex.isEnd()) {
				currentItem.setNewColor(GraphPropertyConstants.V_END_COLOR);
			} else {
				currentItem.setNewColor(this.getStateColor());
			}
		}
	}

}
