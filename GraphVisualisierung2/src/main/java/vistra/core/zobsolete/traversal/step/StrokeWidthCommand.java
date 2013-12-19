package vistra.core.zobsolete.traversal.step;

import vistra.core.zobsolete.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
class StrokeWidthCommand extends EmptyStep {

	private final IGraphItem item;

	private final float oldStrokeWidth;
	private final float newStrokeWidth;
	
	/**
	 * 
	 * @param currentItem
	 * @param oldStrokeWidth
	 * @param newStrokeWidth
	 */
	protected StrokeWidthCommand(IGraphItem currentItem, float oldStrokeWidth, 
			float newStrokeWidth) {
		super();
		
		this.item = currentItem;
		this.oldStrokeWidth = oldStrokeWidth;
		this.newStrokeWidth = newStrokeWidth;
	}

	@Override
	public IStepResult execute() {
		this.item.setCurrentStrokeWidth(this.newStrokeWidth);
		return new StepResult();
	}

	@Override
	public IStepResult undo() {
		this.item.setCurrentStrokeWidth(this.oldStrokeWidth);
		return new StepResult();
	}

	
}
