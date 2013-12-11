package ch.bfh.bti7301.hs2013.gravis.core.command;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class StepResult implements IStepResult {

	private String stepComment;
	
	/**
	 * 
	 * @param comment
	 */
	public StepResult(String comment) {
		this.stepComment = comment.trim();
	}

	public StepResult() {
		this("");
	}
	
	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IStepResult#hasComment()
	 */
	@Override
	public boolean hasComment() {
		return !this.stepComment.isEmpty();
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IStepResult#getComment()
	 */
	@Override
	public String getComment() {
		return this.stepComment;
	}

}
