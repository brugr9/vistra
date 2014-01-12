package vistra.framework.util;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A bidirectional iterator over a list, immutable.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ListIterator
 */
public class ImmutableBidirectIterator<E> implements IBidirectIterator<E> {

	/**
	 * A field for a list iterator.
	 */
	private final ListIterator<E> iterator;

	/**
	 * A field for the size.
	 */
	private int size;

	/**
	 * A constructor taking a list to iterate over.
	 * 
	 * @param list
	 *            the list
	 */
	public ImmutableBidirectIterator(List<E> list) {
		this.iterator = list.listIterator();
		this.size = list.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasPrevious() {
		return this.iterator.hasPrevious();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E previous() throws NoSuchElementException {
		try {
			return this.iterator.previous();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E next() throws NoSuchElementException {
		try {
			return this.iterator.next();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
