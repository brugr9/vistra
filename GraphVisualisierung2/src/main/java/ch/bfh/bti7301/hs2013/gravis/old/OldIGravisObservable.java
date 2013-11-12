package ch.bfh.bti7301.hs2013.gravis.old;

import java.util.Observer;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @deprecated
 */
public interface OldIGravisObservable {

	/**
	 * 
	 * @param arg
	 */
	public abstract void notifyObservers(Object arg);

	public abstract void notifyObservers();

	/**
	 * 
	 * @return boolean
	 */
	public abstract boolean hasChanged();

	public abstract void deleteObservers();

	/**
	 * 
	 * @param o
	 */
	public abstract void deleteObserver(Observer o);

	/**
	 * 
	 * @return int
	 */
	public abstract int countObservers();

	/**
	 * 
	 * @param o
	 */
	public abstract void addObserver(Observer o);

}