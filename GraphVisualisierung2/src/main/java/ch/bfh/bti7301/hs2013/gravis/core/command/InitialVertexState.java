package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class InitialVertexState extends AbstractCommonVisualizationState {

	private State state;
	
	/**
	 * @param color
	 */
	protected InitialVertexState(Color color) {
		super(color);
		
		this.state = State.INITIAL;
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

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IVisualizationState#getState()
	 */
	@Override
	public State getState() {
		return this.state;
	}

}
