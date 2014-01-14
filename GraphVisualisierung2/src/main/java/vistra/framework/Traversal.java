package vistra.framework;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.TraversableGraph;
import vistra.framework.step.IStep;
import vistra.framework.util.IBidirectIterator;

/**
 * A traversal as an immutable, bidirectional iterator over steps.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ListIterator
 * @see IAlgorithm
 * @see TraversableGraph
 * 
 */
class Traversal implements ITraversal {

	/**
	 * A field for an iterator over steps.
	 */
	private IBidirectIterator<IStep> steps;
	/**
	 * A field for a description.
	 */
	private String description;

	/**
	 * Main constructor.
	 * 
	 * @param steps
	 *            an iterator over steps
	 */
	Traversal(IBidirectIterator<IStep> steps) {
		this.steps = steps;
		this.description = "";
	}

	/**
	 * Another constructor.
	 * 
	 * @param steps
	 *            an iterator over steps
	 * @param description
	 *            a description
	 */
	public Traversal(IBidirectIterator<IStep> steps, String description) {
		this.steps = steps;
		this.description = description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		return this.steps.hasNext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStep next() {
		return this.steps.next();
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
		return this.steps.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return this.steps.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasPrevious() {
		return this.steps.hasPrevious();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStep previous() throws NoSuchElementException {
		return this.steps.previous();
	}

}
