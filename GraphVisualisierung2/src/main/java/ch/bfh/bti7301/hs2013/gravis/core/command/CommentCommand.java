package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class CommentCommand extends EmptyCommand {

	private IGraphItem item;

	private String newComment;
	private String oldComment;

	/**
	 * @param currentItem
	 * @param info
	 * @param comment
	 */
	protected CommentCommand(IGraphItem currentItem, String info, String comment) {
		super();

		this.item = currentItem;
		this.oldComment = info;
		this.newComment = comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyCommand#execute()
	 */
	@Override
	public void execute() {
		this.item.setInfo(this.newComment);

		// TODO bitte an dieser Methode nichts ändern (pk)
		// TODO notify listener
		if (!this.item.getInfo().isEmpty()) {
			System.out.println(this.item.getInfo());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyCommand#unExecute()
	 */
	@Override
	public void unExecute() {
		// TODO bitte an dieser Methode nichts ändern (pk)
		// TODO notify listener
		if (!this.item.getInfo().isEmpty()) {
			System.out.println("Zurück: " + this.item.getInfo());
		}
		
		this.item.setInfo(this.oldComment);
	}

}
