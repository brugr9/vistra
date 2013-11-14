package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ColorCommand extends EmptyCommand {

	private IGraphItem item;

	private Color newColor;
	private Color oldColor;

	/**
	 * 
	 * @param item
	 * @param oldColor
	 * @param newColor
	 */
	protected ColorCommand(IGraphItem item, Color oldColor, Color newColor) {
		super();

		this.item = item;
		this.oldColor = oldColor;
		this.newColor = newColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.ICommand#execute()
	 */
	@Override
	public void execute() {
		this.item.setColor(this.newColor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.ICommand#unExecute()
	 */
	@Override
	public void unExecute() {
		this.item.setColor(this.oldColor);
	}

}
