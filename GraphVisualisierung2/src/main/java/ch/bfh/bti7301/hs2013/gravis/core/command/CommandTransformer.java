package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;
import java.util.Map;

import javax.swing.event.ChangeListener;

import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.map.HashedMap;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class CommandTransformer implements Transformer<IGraphItem, ICommand> {

	private final Map<State, IAnimationState> states;
	
	private IAnimationState currentState;

	/**
	 * 
	 * @param graphItemHistory
	 * @param changeListener
	 */
	protected CommandTransformer(List<IGraphItem> graphItemHistory,
			ChangeListener changeListener) {
		this.states = new HashedMap<>();
		this.states.put(State.INITIAL, new InitialState(graphItemHistory, changeListener));
		this.states.put(State.ACTIVATION, new ActivationState(changeListener));
		this.states.put(State.VISIT, new VisitState(graphItemHistory, changeListener));
		this.states.put(State.SOLUTION, new SolutionState(graphItemHistory, changeListener));
		
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
