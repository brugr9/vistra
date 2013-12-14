package ch.bfh.bti7301.hs2013.gravis.core.traversal.step;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ColorCommand extends EmptyStep {

	private final IGraphItem item;

	private final Color newColor;
	private final Color oldColor;
	
	protected ColorCommand(IGraphItem item, Color oldColor, Color newColor) {
		super();
		
		this.item = item;
		this.oldColor = oldColor;
		this.newColor = newColor;
	}

	@Override
	public IStepResult execute() {
		this.item.setCurrentColor(this.newColor);
		return new StepResult();
	}

	@Override
	public IStepResult undo() {
		this.item.setCurrentColor(this.oldColor);
		return new StepResult();
	}
	
	
	
}
