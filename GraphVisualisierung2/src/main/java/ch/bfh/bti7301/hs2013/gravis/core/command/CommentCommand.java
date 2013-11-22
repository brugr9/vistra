package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class CommentCommand extends EmptyStep {

	private final IGraphItem item;

	private final String newComment;
	private final String oldComment;

	/**
	 * @param currentItem
	 * @param info
	 * @param changeListener
	 */
	protected CommentCommand(IGraphItem currentItem, String info,
			String comment) {
		super();

		this.item = currentItem;
		this.oldComment = info;
		this.newComment = comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#execute()
	 */
	@Override
	public String execute() {
		if (!this.newComment.trim().isEmpty()) {
			this.item.setInfo(this.newComment.trim());
			return this.item.getInfo();
		} else {
			return "";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#unExecute()
	 */
	@Override
	public String unExecute() {
		if (!this.oldComment.trim().isEmpty()) {
			this.item.setInfo(this.oldComment.trim());
			return this.item.getInfo();
		} else {
			return "";
		}
	}

}
