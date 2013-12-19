package vistra.core.traversal;

import java.util.Iterator;

/**
 * An immutable bidirectional iterator interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @param <E>
 * 
 */
public interface IImmutableBidirectionalIterator<E> extends Iterable<E>,
		Iterator<E> {

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

}
