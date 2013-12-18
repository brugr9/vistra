package travis.core.traversal.step;

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
