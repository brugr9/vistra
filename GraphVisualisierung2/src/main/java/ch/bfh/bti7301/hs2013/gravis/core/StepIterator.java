package ch.bfh.bti7301.hs2013.gravis.core;

import java.util.Iterator;

import ch.bfh.bti7301.hs2013.gravis.core.command.IStep;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class StepIterator implements IGravisListIterator<String> {

	/**
	 * A field for a graph iterator.
	 */
	private IGravisListIterator<IStep> graphIterator;

	/**
	 * A field for a current command.
	 */
	private IStep currentCommand;

	/**
	 * Main constructor.
	 * 
	 * @param graphIterator
	 * 
	 */
	protected StepIterator(IGravisListIterator<IStep> graphIterator) {
		this.graphIterator = graphIterator;
		this.currentCommand = null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<String> iterator() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return this.graphIterator.hasNext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public String next() {
		if (this.graphIterator.hasNext()) {
			this.currentCommand = this.graphIterator.next();
			return this.currentCommand.execute().getComment();
		}
		return "";
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
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.graphIterator.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#previous()
	 */
	@Override
	public String previous() {
		if (this.graphIterator.hasPrevious()) {
			this.currentCommand = this.graphIterator.previous();
			return this.currentCommand.unExecute().getComment();
		}
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#hasPrevious()
	 */
	@Override
	public boolean hasPrevious() {
		return this.graphIterator.hasPrevious();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#size()
	 */
	@Override
	public int size() {
		return this.graphIterator.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#nextIndex()
	 */
	@Override
	public int nextIndex() {
		return this.graphIterator.nextIndex();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#previousIndex()
	 */
	@Override
	public int previousIndex() {
		return this.graphIterator.previousIndex();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#first()
	 */
	@Override
	public String first() {
		String stepString = "";

		while (this.graphIterator.hasPrevious()) {
			stepString = this.previous();
		}

		return stepString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.IGravisListIterator#last()
	 */
	@Override
	public String last() {
		String stepString = "";

		while (this.graphIterator.hasNext()) {
			stepString = this.next();
		}

		return stepString;
	}

}
