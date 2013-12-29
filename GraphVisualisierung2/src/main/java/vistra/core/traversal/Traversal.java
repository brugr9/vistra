package vistra.core.traversal;

import java.util.Iterator;
import java.util.NoSuchElementException;

import vistra.core.algorithm.IAlgorithm;
import vistra.core.graph.TraversableGraph;
import vistra.core.traversal.step.IStep;
import vistra.util.IBidirectIterator;

/**
 * A traversal as an immutable, bidirectional iterator over steps.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IAlgorithm
 * @see TraversableGraph
 * 
 */
public class Traversal implements ITraversal {

	/**
	 * A field for an iterator over steps.
	 */
	private IBidirectIterator<IStep> iterator;
	/**
	 * A field for a description (e.g. statistics etc.).
	 */
	private StringBuilder description;

	/**
	 * Main constructor.
	 * 
	 * @param iterator
	 *            an iterator over steps
	 */
	public Traversal(IBidirectIterator<IStep> iterator) {
		this.iterator = iterator;
		this.description = new StringBuilder();
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
		return this.iterator.hasNext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStep next() {
		return this.iterator.next();
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return this.iterator.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return this.iterator.isEmpty();
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
	public IStep previous() throws NoSuchElementException {
		return this.iterator.previous();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDescription(StringBuilder statistics) {
		this.description = statistics;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringBuilder getStatistics() {
		return this.description;
	}

}
