package ch.bfh.bti7301.hs2013.gravis.core;

import ch.bfh.bti7301.hs2013.gravis.core.command.ICommand;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IIteratorManager {

	/**
	 * 
	 * @throws Exception
	 */
	public abstract void goToBeginning() throws Exception;

	/**
	 * 
	 * @throws Exception
	 */
	public abstract void goToEnd() throws Exception;

	/**
	 * 
	 * @return <code>true</code> if there is one more element in minimum to
	 *         reach in direction forward after this operation
	 * @throws Exception
	 */
	public abstract boolean goForward() throws Exception;

	/**
	 * 
	 * @return <code>true</code> if there is one more element in minimum to
	 *         reach in direction backward after this operation
	 * @throws Exception
	 */
	public abstract boolean goBackward() throws Exception;

	/**
	 * 
	 * @param listIterator
	 * @throws Exception
	 */
	public abstract void setListIterator(
			IImmutListIterator<ICommand> listIterator) throws Exception;

	/**
	 * @return int
	 */
	public abstract int getGraphIteratorSize();
}
