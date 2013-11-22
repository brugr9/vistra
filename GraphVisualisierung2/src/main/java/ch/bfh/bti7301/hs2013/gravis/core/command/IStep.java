package ch.bfh.bti7301.hs2013.gravis.core.command;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IStep {

	/**
	 * 
	 * @return message
	 */
	public abstract String execute();

	/**
	 * 
	 * @return message
	 */
	public abstract String unExecute();

}
