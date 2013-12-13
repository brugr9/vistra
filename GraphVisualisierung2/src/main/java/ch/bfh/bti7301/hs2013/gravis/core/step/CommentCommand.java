package ch.bfh.bti7301.hs2013.gravis.core.step;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class CommentCommand extends EmptyStep {

	private final String newComment;
	private final String oldComment;

	/**
	 * 
	 * @param oldComment
	 * @param newComment
	 */
	protected CommentCommand(String oldComment,	String newComment) {
		super();

		this.oldComment = oldComment.trim();
		this.newComment = newComment.trim();
	}

	@Override
	public IStepResult execute() {
		return new StepResult(this.newComment);
	}

	@Override
	public IStepResult unExecute() {
		return new StepResult(this.oldComment);
	}

}
