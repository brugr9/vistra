package ch.bfh.bti7301.hs2013.gravis.core.traversal.step;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IStep {

	/**
	 * 
	 * @return message
	 */
	public abstract IStepResult execute();

	/**
	 * 
	 * @return message
	 */
	public abstract IStepResult undo();

}
