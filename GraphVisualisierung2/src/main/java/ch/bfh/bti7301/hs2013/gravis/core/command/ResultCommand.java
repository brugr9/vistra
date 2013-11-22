package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ResultCommand extends EmptyStep {

	private final IGraphItem item;

	private final double newResult;
	private final double oldResult;

	/**
	 * @param currentItem
	 * @param paintedResult
	 * @param result
	 */
	protected ResultCommand(IGraphItem currentItem, double paintedResult,
			double result) {
		super();

		this.item = currentItem;
		this.oldResult = paintedResult;
		this.newResult = result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#execute()
	 */
	@Override
	public String execute() {
		this.item.setPaintedResult(this.newResult);
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#unExecute()
	 */
	@Override
	public String unExecute() {
		this.item.setPaintedResult(this.oldResult);
		return "";
	}

}
