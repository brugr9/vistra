package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
class StrokeWidthCommand extends EmptyStep {

	private final IGraphItem item;

	private final float oldStrokeWidth;
	private final float newStrokeWidth;
	
	protected StrokeWidthCommand(IGraphItem currentItem, float oldStrokeWidth, 
			float newStrokeWidth) {
		super();
		
		this.item = currentItem;
		this.oldStrokeWidth = oldStrokeWidth;
		this.newStrokeWidth = newStrokeWidth;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#execute()
	 */
	@Override
	public String execute() {
		this.item.setStrokeWidth(this.newStrokeWidth);
		return "";
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.EmptyStep#unExecute()
	 */
	@Override
	public String unExecute() {
		this.item.setStrokeWidth(this.oldStrokeWidth);
		return "";
	}

}
