package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
class StrokeWidthCommand extends TaggedStrokeCommand {

	/**
	 * 
	 * @param currentItem
	 * @param oldStrokeWidth
	 * @param newStrokeWidth
	 */
	protected StrokeWidthCommand(IGraphItem currentItem, float oldStrokeWidth, 
			float newStrokeWidth) {
		super(currentItem, oldStrokeWidth, newStrokeWidth);
		
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#isLocked()
	 */
	@Override
	public boolean isLocked() {
		return this.item.isTagged();
	}

	
}
