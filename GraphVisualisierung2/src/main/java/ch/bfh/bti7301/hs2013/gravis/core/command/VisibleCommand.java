package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
class VisibleCommand extends EmptyStep {

	protected final IGraphItem item;

	protected final Color newColor;
	
	protected final Color oldColor;
	
	
	protected VisibleCommand(IGraphItem item, Color oldColor, Color newColor) {
		super();
		
		this.item = item;
		this.oldColor = oldColor;
		this.newColor = newColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IStep#execute()
	 */
	@Override
	public String execute() {
		this.item.setColor(this.newColor);
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IStep#unExecute()
	 */
	@Override
	public String unExecute() {
		this.item.setColor(this.oldColor);
		return "";
	}
	
}
