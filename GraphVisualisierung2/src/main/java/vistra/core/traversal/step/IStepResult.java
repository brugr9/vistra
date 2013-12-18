package vistra.core.traversal.step;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public interface IStepResult {

	/**
	 * 
	 * @return boolean
	 */
	public abstract boolean hasComment();

	/**
	 * 
	 * @return String
	 */
	public abstract String getComment();
}
