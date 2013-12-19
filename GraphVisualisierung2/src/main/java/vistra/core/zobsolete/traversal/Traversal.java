package vistra.core.zobsolete.traversal;

import java.util.Iterator;

import vistra.core.zobsolete.traversal.step.IStep;
import vistra.core.zobsolete.traversal.step.IStepResult;

/**
 * A traversal.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Traversal implements IImmutableBidirectionalIterator<IStepResult> {

	/**
	 * A field for an iterator over steps.
	 */
	private IImmutableBidirectionalIterator<IStep> steps;

	/**
	 * Main constructor.
	 * 
	 * @param steps
	 *            an iterator over steps
	 * 
	 */
	public Traversal(IImmutableBidirectionalIterator<IStep> steps) {
		this.steps = steps;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<IStepResult> iterator() {
		return this;
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
	public IStepResult next() {

		IStepResult summary = null;

		try {
			if (this.steps.hasNext()) {
				IStep step = this.steps.next();
				summary = step.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return summary;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException(
				"remove: unsupported operation.");
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
	public IStepResult previous() {
		IStepResult description = null;
		try {

			if (this.steps.hasPrevious()) {
				IStep step = this.steps.previous();
				step.undo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return description;
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
	public int size() {
		return this.steps.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int nextIndex() {
		return this.steps.nextIndex();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int previousIndex() {
		return this.steps.previousIndex();
	}

}
