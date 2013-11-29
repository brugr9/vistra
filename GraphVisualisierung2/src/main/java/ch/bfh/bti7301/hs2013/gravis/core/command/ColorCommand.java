package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ColorCommand extends VisibleCommand {

	/**
	 * 
	 * @param item
	 * @param oldColor
	 * @param newColor
	 */
	protected ColorCommand(IGraphItem item, Color oldColor, Color newColor) {
		super(item, oldColor, newColor);
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#isLocked()
	 */
	@Override
	public boolean isLocked() {
		return !this.item.isVisible();
	}
	
	
	
}
