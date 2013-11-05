package ch.bfh.bti7301.hs2013.gravis.core.command;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface ICommand {

	public abstract void execute();

	public abstract void unExecute();

}
