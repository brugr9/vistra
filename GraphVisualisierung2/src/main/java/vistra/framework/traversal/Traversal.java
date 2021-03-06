package vistra.framework.traversal;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.TraversableGraph;
import vistra.framework.traversal.step.IStep;
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
public class Traversal implements ITraversal {

	/**
	 * A field for an iterator over steps.
	 */
	private IBidirectIterator<IStep> steps;
	/**
	 * A field for a solution.
	 */
	private String solution;

	/**
	 * Main constructor.
	 * 
	 * @param steps
	 *            an iterator over steps
	 */
	public Traversal(IBidirectIterator<IStep> steps) {
		this.steps = steps;
		this.solution = "";
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

	@Override
	public void setSolution(String solution) {
		this.solution = solution;
	}

	@Override
	public String getSolution() {
		return this.solution;
	}

}
