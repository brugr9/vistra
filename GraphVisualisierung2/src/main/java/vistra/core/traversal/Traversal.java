package vistra.core.traversal;

import java.util.Iterator;
import java.util.NoSuchElementException;

import vistra.util.IBidirectIterator;

/**
 * A traversal as an immutable, bidirectional iterator over steps.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Traversal implements IBidirectIterator<IStep> {

	/**
	 * A field for an iterator over steps.
	 */
	private IBidirectIterator<IStep> stepIterator;

	/**
	 * Main constructor.
	 * 
	 * @param stepIterator
	 *            an iterator over steps
	 * 
	 */
	public Traversal(IBidirectIterator<IStep> stepIterator) {
		this.stepIterator = stepIterator;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<IStep> iterator() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		return this.stepIterator.hasNext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStep next() {
		return this.stepIterator.next();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return this.stepIterator.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return this.stepIterator.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasPrevious() {
		return this.stepIterator.hasPrevious();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStep previous() throws NoSuchElementException {
		return this.stepIterator.previous();
	}

}
