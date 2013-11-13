package ch.bfh.bti7301.hs2013.gravis.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * An implementation of an immutable list iterator.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisListIterator<E> implements IGravisListIterator<E> {

	private final ListIterator<E> listIterator;

	private int size;

	/**
	 * 
	 */
	protected GravisListIterator() {
		this(new ArrayList<E>());
	}

	/**
	 * 
	 * @param list
	 */
	protected GravisListIterator(List<E> list) {
		this.listIterator = list.listIterator();
		this.size = list.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.traversing.ITraverserCollection
	 * #isEmpty ()
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return this.listIterator.hasNext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public E next() {
		return this.listIterator.next();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException(
				"remove: Unsupported operation!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.traversing.ITraverserCollection
	 * #before ()
	 */
	@Override
	public E previous() {
		return this.listIterator.previous();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.traversing.ITraverserCollection
	 * #hasBefore ()
	 */
	@Override
	public boolean hasPrevious() {
		return this.listIterator.hasPrevious();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.traversing.ITraverserCollection
	 * #size()
	 */
	@Override
	public int size() {
		return this.size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#nextIndex()
	 */
	@Override
	public int nextIndex() {
		return this.listIterator.nextIndex();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#previousIndex()
	 */
	@Override
	public int previousIndex() {
		return this.listIterator.previousIndex();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#first()
	 */
	@Override
	public E first() {
		E element = null;

		while (this.listIterator.hasPrevious()) {
			element = this.listIterator.previous();
		}

		return element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#last()
	 */
	@Override
	public E last() {
		E element = null;

		while (this.listIterator.hasNext()) {
			element = this.listIterator.next();
		}

		return element;
	}

}
