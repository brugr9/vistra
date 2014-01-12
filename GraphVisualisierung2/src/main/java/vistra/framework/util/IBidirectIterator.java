package vistra.framework.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A bidirectional iterator interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @param <E>
 */
public interface IBidirectIterator<E> extends Iterator<E> {

	/**
	 * Returns the size of the iterator.
	 * 
	 * @return the size
	 */
	int size();

	/**
	 * Returns {@code true} if the iteration has no elements. (In other words,
	 * returns {@code true} if {@link #previous} or {@link #next} would throw an
	 * exception.)
	 * 
	 * @return {@code true} if the iteration has no elements
	 */
	boolean isEmpty();

	/**
	 * Returns {@code true} if the iteration has more elements. (In other words,
	 * returns {@code true} if {@link #previous} would return an element rather
	 * than throwing an exception.)
	 * 
	 * @return {@code true} if the iteration has more elements
	 */
	boolean hasPrevious();

	/**
	 * Returns the previous element in the iteration.
	 * 
	 * @return the previous element in the iteration
	 * @throws NoSuchElementException
	 */
	E previous() throws NoSuchElementException;

}
