package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.map.HashedMap;

import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem.State;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class CommandTransformer implements Transformer<IGraphItem, ICommand> {

	private Map<State, IAnimationState> states;

	private IAnimationState currentState;

	/**
	 * @param graphItemHistory
	 * 
	 */
	protected CommandTransformer(List<IGraphItem> graphItemHistory) {
		this.states = new HashedMap<>();
		this.states.put(State.INITIAL, new InitialState(graphItemHistory));
		this.states.put(State.ACTIVATION, new ActivationState());
		this.states.put(State.VISIT, new VisitState(graphItemHistory));
		this.states.put(State.SOLUTION, new SolutionState(graphItemHistory));
		
		this.currentState = this.states.get(State.INITIAL);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public ICommand transform(IGraphItem currentItem) {
		IAnimationState nextState = this.states.get(currentItem.getState());
		ICommand command = nextState.createCommand(this.currentState,
				currentItem);
		this.currentState = nextState;
		return command;
	}

}
