package vistra.core.traversal.step;

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
	public IStepResult undo() {
		return new StepResult(this.oldComment);
	}

}
