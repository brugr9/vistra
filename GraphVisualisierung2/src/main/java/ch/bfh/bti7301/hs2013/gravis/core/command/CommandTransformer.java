package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.map.HashedMap;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class CommandTransformer implements Transformer<IGraphItem, IStep> {

	private final String V_SUFFIX = "_VERTEX";
	
	private final String E_SUFFIX = "_EDGE";
	
	private final Map<String, IVisualizationState> states;

	private IVisualizationState currentState;

	/**
	 * 
	 * @param graphItemHistory
	 */
	protected CommandTransformer(List<IGraphItem> graphItemHistory) {
		this.states = new HashedMap<>();
		this.states.put(State.INITIAL.toString() + V_SUFFIX, new InitialState(GravisColor.RED,
				graphItemHistory));
		this.states.put(State.INITIAL.toString() + E_SUFFIX, new InitialState(GravisColor.BLACK,
				graphItemHistory));
		this.states.put(State.ACTIVATION.toString(), new ActivationState(
				graphItemHistory));
		this.states.put(State.VISIT.toString(), new VisitState(
				graphItemHistory));
		this.states.put(State.SOLUTION.toString(), new SolutionState(
				graphItemHistory));

		this.currentState = this.states.get(State.INITIAL.toString() + V_SUFFIX);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public IStep transform(IGraphItem currentItem) {
		IVisualizationState nextState = this.states.get(this.getKeyString(currentItem));
		IStep currentCommand = nextState.createCommand(this.currentState,
				currentItem);
		
		this.currentState = nextState;
		return currentCommand;
	}

	/**
	 * @param currentItem
	 * @return String
	 */
	private String getKeyString(IGraphItem currentItem) {
		if (currentItem.getState() == State.INITIAL) {
			if (currentItem instanceof IVertex) {
				return currentItem.getState().toString() + V_SUFFIX;
			} else {
				return currentItem.getState().toString() + E_SUFFIX;
			}
		} 
		return currentItem.getState().toString();
	}

}
