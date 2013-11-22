package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractVisualizationState implements IVisualizationState {

	private final static float VERTEX_STROKE_WIDTH = 3.0f;

	private final static float EDGE_STROKE_WIDTH = 4.0f;

	protected final Color stateColor;

	protected final List<IGraphItem> graphItemHistory;

	private IStep predecessorCommand;

	private IGraphItem oldGraphItemClone;

	/**
	 * 
	 * @param color
	 * @param graphItemHistory
	 */
	protected AbstractVisualizationState(Color color,
			List<IGraphItem> graphItemHistory) {

		this.stateColor = color;
		this.graphItemHistory = graphItemHistory;

		// Null Object
		this.predecessorCommand = new EmptyStep();
		// default graph item
		this.oldGraphItemClone = new VertexFactory().create();
	}

	@Override
	public IStep getPredecessorCommand() {
		return this.predecessorCommand;
	}

	/**
	 * @param predecessorCommand
	 *            the predecessorCommand to set
	 */
	protected void setPredecessorCommand(IStep predecessorCommand) {
		this.predecessorCommand = predecessorCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IVisualizationState#
	 * getOldGraphItemClone()
	 */
	@Override
	public IGraphItem getOldGraphItemClone() {
		return this.oldGraphItemClone;
	}

	/**
	 * @param oldGraphItemClone
	 *            the oldGraphItemClone to set
	 */
	protected void setOldGraphItemClone(IGraphItem oldGraphItemClone) {
		this.oldGraphItemClone = oldGraphItemClone;
	}

	/**
	 * @param currentItem
	 * @param complexCommand
	 */
	protected void addVisualizationCommands(IGraphItem currentItem,
			Step complexCommand) {

		if (!currentItem.hasNoResult()) {
			complexCommand.add(new ResultCommand(currentItem, currentItem
					.getPaintedResult(), currentItem.getResult()));
		}

		if (!currentItem.hasNoComment()) {
			complexCommand.add(new CommentCommand(currentItem, currentItem
					.getInfo(), currentItem.getComment()));
		}
	}

	/**
	 * @param currentItem
	 * @return float
	 */
	protected float getItemStrokeWidth(IGraphItem currentItem) {
		return currentItem instanceof IVertex ? VERTEX_STROKE_WIDTH
				: EDGE_STROKE_WIDTH;
	}

	/**
	 * @param oldGraphItemClone
	 * @param currentItem
	 * @return IGraphItem
	 */
	protected IGraphItem checkOldObject(IGraphItem oldGraphItemClone,
			IGraphItem currentItem) {
		return this.isSameObject(currentItem) ? oldGraphItemClone : currentItem;
	}

	/**
	 * @param currentItem
	 * @return boolean
	 */
	protected boolean isSameObject(IGraphItem currentItem) {
		return !this.graphItemHistory.isEmpty()
				&& currentItem == this.graphItemHistory
						.get(this.graphItemHistory.size() - 1);
	}
}