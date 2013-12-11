package ch.bfh.bti7301.hs2013.gravis.core.command;

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
