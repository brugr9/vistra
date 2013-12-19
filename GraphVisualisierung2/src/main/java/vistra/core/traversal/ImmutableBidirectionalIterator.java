package vistra.core.traversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
	public boolean isEmpty() {
		return this.size == 0;
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
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E next() {
		return this.iterator.next();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException(
				"remove: Unsupported operation!");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E previous() {
		return this.iterator.previous();
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
	public int size() {
		return this.size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int nextIndex() {
		return this.iterator.nextIndex();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int previousIndex() {
		return this.iterator.previousIndex();
	}

}
