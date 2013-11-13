package ch.bfh.bti7301.hs2013.gravis.core;

import java.util.Iterator;

/**
 * A bidirectinal immutable iterator.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IGravisListIterator<E> extends Iterable<E>, Iterator<E> {

	/**
	 * @return boolean
	 */
	public abstract boolean isEmpty();

	/**
	 * @return E
	 */
	public abstract E previous();

	/**
	 * 
	 * @return boolean
	 */
	public abstract boolean hasPrevious();

	/**
	 * @return size
	 */
	public abstract int size();

	/**
	 * 
	 * @return int
	 */
	public abstract int nextIndex();

	/**
	 * 
	 * @return int
	 */
	public abstract int previousIndex();

	/**
	 * 
	 * @return E
	 */
	public abstract E first();

	/**
	 * 
	 * @return E
	 */
	public abstract E last();
}
