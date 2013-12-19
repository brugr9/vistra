package vistra.core.traversal.step;

import java.awt.Color;

import vistra.core.graph.zobsolete.item.IGraphItem;


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
