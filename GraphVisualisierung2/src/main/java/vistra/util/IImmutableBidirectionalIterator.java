package vistra.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An immutable bidirectional iterator interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @param <E>
 */
public interface IImmutableBidirectionalIterator<E> extends Iterable<E>,
		Iterator<E> {

	/**
	 * Returns the size of the iteration.
	 * 
	 * @return the size
	 */
	abstract int size();

	/**
	 * Returns {@code true} if the iteration has no elements. (In other words,
	 * returns {@code true} if {@link #previous} or {@link #next} would throwing
	 * an exception.)
	 * 
	 * @return {@code true} if the iteration has no elements
	 */
	abstract boolean isEmpty();

	/**
	 * Returns {@code true} if the iteration has more elements. (In other words,
	 * returns {@code true} if {@link #previous} would return an element rather
	 * than throwing an exception.)
	 * 
	 * @return {@code true} if the iteration has more elements
	 */
	abstract boolean hasPrevious();

	/**
	 * Returns the previous element in the iteration.
	 * 
	 * @return the previous element in the iteration
	 * @throws NoSuchElementException
	 */
	abstract E previous() throws NoSuchElementException;

}
