package vistra.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * An immutable bidirectional iterator.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ImmutableBidirectionalIterator<E> implements
		IImmutableBidirectionalIterator<E> {

	/**
	 * A field for a list iterator.
	 */
	private final ListIterator<E> iterator;

	/**
	 * A field for the size.
	 */
	private int size;

	/**
	 * Constructor.
	 */
	public ImmutableBidirectionalIterator() {
		this(new ArrayList<E>());
	}

	/**
	 * Constructor.
	 * 
	 * @param list
	 *            a list
	 */
	public ImmutableBidirectionalIterator(List<E> list) {
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
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
