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

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#execute()
	 */
	@Override
	public String execute() {
		this.item.setState(this.newState);
		return "";
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#unExecute()
	 */
	@Override
	public String unExecute() {
		this.item.setState(this.oldState);
		return "";
	}

	
}
