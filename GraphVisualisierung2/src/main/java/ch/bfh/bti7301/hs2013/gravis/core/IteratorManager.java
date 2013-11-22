package ch.bfh.bti7301.hs2013.gravis.core;

import ch.bfh.bti7301.hs2013.gravis.core.command.IStep;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class IteratorManager implements IIteratorManager {

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
	protected IteratorManager(IGravisListIterator<IStep> graphIterator) {
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
	public String goToBeginning() throws Exception {
		try {
			StringBuilder stringBuilder = new StringBuilder();
			String stepString = "";

			while (this.graphIterator.hasPrevious()) {
				stepString = this.goBackward();
				stringBuilder.append(stepString + System.lineSeparator());
			}

			return stringBuilder.toString().trim();
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
	public String goToEnd() throws Exception {
		try {
			StringBuilder stringBuilder = new StringBuilder();
			String stepString = "";

			while (this.graphIterator.hasNext()) {
				stepString = this.goForward();
				stringBuilder.append(stepString + System.lineSeparator());
			}

			return stringBuilder.toString().trim();
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
	public String goForward() throws Exception {
		try {
			if (this.graphIterator.hasNext()) {
				this.currentCommand = this.graphIterator.next();
				return this.currentCommand.execute();
			}
			return "";
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
	public String goBackward() throws Exception {
		try {
			if (this.graphIterator.hasPrevious()) {
				this.currentCommand = this.graphIterator.previous();
				return this.currentCommand.unExecute();
			}
			return "";
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
	public void setListIterator(IGravisListIterator<IStep> listIterator)
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
