package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ResultCommand extends EmptyCommand {

	private IGraphItem item;

	private double newResult;
	private double oldResult;

	/**
	 * @param currentItem
	 * @param paintedResult
	 * @param result
	 */
	protected ResultCommand(IGraphItem currentItem, double paintedResult,
			double result) {
		this.item = currentItem;
		this.oldResult = paintedResult;
		this.newResult = result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyCommand#execute()
	 */
	@Override
	public void execute() {
		this.item.setPaintedResult(this.newResult);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyCommand#unExecute()
	 */
	@Override
	public void unExecute() {
		this.item.setPaintedResult(this.oldResult);
	}

}
