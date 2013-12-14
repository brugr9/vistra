package ch.bfh.bti7301.hs2013.gravis.core.traversal;

import java.util.Iterator;

import ch.bfh.bti7301.hs2013.gravis.core.traversal.step.IStep;
import ch.bfh.bti7301.hs2013.gravis.core.traversal.step.IStepResult;

/**
 * A traversal.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Traversal implements IGravisListIterator<IStepResult> {

	/**
	 * A field for an iterator over steps.
	 */
	private IGravisListIterator<IStep> steps;

	/**
	 * Main constructor.
	 * 
	 * @param steps
	 *            an iterator over steps
	 * 
	 */
	public Traversal(IGravisListIterator<IStep> steps) {
		this.steps = steps;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<IStepResult> iterator() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		return this.steps.hasNext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException(
				"remove: unsupported operation.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#isEmpty()
	 *//**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return this.steps.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#previous()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#hasPrevious()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasPrevious() {
		return this.steps.hasPrevious();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#size()
	 */
	@Override
	public int size() {
		return this.steps.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#nextIndex()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int nextIndex() {
		return this.steps.nextIndex();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#previousIndex()
	 *//**
	 * {@inheritDoc}
	 */
	@Override
	public int previousIndex() {
		return this.steps.previousIndex();
	}

}
