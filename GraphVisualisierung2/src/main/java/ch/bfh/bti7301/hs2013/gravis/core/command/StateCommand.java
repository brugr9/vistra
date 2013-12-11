package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class StateCommand extends EmptyStep {

	private final IGraphItem item;

	private final State newState;
	private final State oldState;
	
	/**
	 * @param newState 
	 * @param oldState 
	 * @param currentItem 
	 * 
	 */
	public StateCommand(IGraphItem currentItem, State oldState, State newState) {
		this.item = currentItem;
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public IStepResult execute() {
		this.item.setCurrentState(this.newState);
		return new StepResult();
	}

	@Override
	public IStepResult unExecute() {
		this.item.setCurrentState(this.oldState);
		return new StepResult();
	}

	
}
