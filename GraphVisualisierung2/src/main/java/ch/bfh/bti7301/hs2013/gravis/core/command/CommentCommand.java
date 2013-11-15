package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.CoreFactory;
import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeEvent;
import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class CommentCommand extends EmptyCommand {

	private final IGraphItem item;

	private final String newComment;
	private final String oldComment;

	private final TraversalChangeListener changeListener;

	private final TraversalChangeEvent changeEvent;

	/**
	 * @param currentItem
	 * @param info
	 * @param comment
	 * @param changeListener
	 */
	protected CommentCommand(IGraphItem currentItem, String info,
			String comment, TraversalChangeListener changeListener) {
		super();

		this.item = currentItem;
		this.oldComment = info;
		this.newComment = comment;
		this.changeListener = changeListener;
		this.changeEvent = CoreFactory.createTraversalChangeEvent(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyCommand#execute()
	 */
	@Override
	public void execute() {
		this.item.setInfo(this.newComment);

		if (!this.item.getInfo().isEmpty()) {
			this.changeEvent.setMessage(this.item.getInfo());
			this.changeListener.stateChanged(this.changeEvent);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyCommand#unExecute()
	 */
	@Override
	public void unExecute() {
		if (!this.item.getInfo().isEmpty()) {
			// TODO bitte an dieser Methode nichts ändern (pk)
			// TODO set message for undo
			this.changeEvent.setMessage("Zurücksetzen: " + this.item.getInfo());
			this.changeListener.stateChanged(this.changeEvent);
		}

		this.item.setInfo(this.oldComment);
	}

}
