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
public class Traversal implements IBidirectIterator<IStep> {

	/**
	 * A field for an iterator over steps.
	 */
	private IBidirectIterator<IStep> stepIterator;
	/**
	 * A field for a string builder.
	 */
	private StringBuilder statistics;

	/**
	 * Main constructor.
	 * 
	 * @param stepIterator
	 *            an iterator over steps
	 * 
	 */
	public Traversal(IBidirectIterator<IStep> stepIterator) {
		this.stepIterator = stepIterator;
		this.statistics = null;
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

	/**
	 * Sets the statistic information.
	 * 
	 * @param statistics
	 *            the statistics
	 */
	public void setStatistics(StringBuilder statistics) {
		this.statistics = statistics;
	}

	/**
	 * Returns some statistic information.
	 * 
	 * @return the statistics
	 */
	public StringBuilder getStatistics() {
		return this.statistics;
	}

}
