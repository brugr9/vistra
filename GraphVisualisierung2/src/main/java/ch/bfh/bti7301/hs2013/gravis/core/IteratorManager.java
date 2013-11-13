package ch.bfh.bti7301.hs2013.gravis.core;

import ch.bfh.bti7301.hs2013.gravis.core.command.ICommand;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class IteratorManager implements IIteratorManager {

	/**
	 * A field for a graph iterator.
	 */
	private IGravisListIterator<ICommand> graphIterator;

	/**
	 * A field for a current command.
	 */
	private ICommand currentCommand;

	/**
	 * Main constructor.
	 * 
	 * @param graphIterator
	 * 
	 */
	protected IteratorManager(IGravisListIterator<ICommand> graphIterator) {
		this.graphIterator = graphIterator;
		this.currentCommand = null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.traversing.IGraphTraverser#
	 * goToBeginning ()
	 */
	@Override
	public void goToBeginning() throws Exception {
		try {
			while (this.goBackward())
				;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.traversing.IGraphTraverser#goToEnd
	 * ()
	 */
	@Override
	public void goToEnd() throws Exception {
		try {
			while (this.goForward())
				;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.traversing.IGraphTraverser#goForward
	 * ()
	 */
	@Override
	public boolean goForward() throws Exception {
		try {
			if (this.graphIterator.hasNext()) {
				this.currentCommand = this.graphIterator.next();
				this.currentCommand.execute();
				return true;
			}
			return false;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.traversing.IGraphTraverser#goBackward
	 * ()
	 */
	@Override
	public boolean goBackward() throws Exception {
		try {
			if (this.graphIterator.hasPrevious()) {
				this.currentCommand = this.graphIterator.previous();
				this.currentCommand.unExecute();
				return true;
			}
			return false;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.IIteratorManager#setListIterator(ch
	 * .bfh.bti7301.hs2013.gravis.core.IImmutListIterator)
	 */
	@Override
	public void setListIterator(IGravisListIterator<ICommand> listIterator)
			throws Exception {
		try {
			this.graphIterator = listIterator;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.IIteratorManager#getGraphIteratorSize()
	 */
	@Override
	public int getGraphIteratorSize() {
		return this.graphIterator.size();
	}

}
