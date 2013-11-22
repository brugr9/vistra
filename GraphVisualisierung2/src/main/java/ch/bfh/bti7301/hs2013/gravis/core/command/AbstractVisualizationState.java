package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractVisualizationState implements IVisualizationState {

	private final static float VERTEX_STROKE_WIDTH = 3.0f;

	private final static float EDGE_STROKE_WIDTH = 4.0f;
	
	protected final static float DEFAULT_STROKE_WIDTH = 1.0f;
	
	protected final Color stateColor;

	protected final TraversalChangeListener changeListener;

	protected final List<IGraphItem> graphItemHistory;

	protected ICommand predecessorCommand;

	/**
	 * 
	 * @param color
	 * @param graphItemHistory
	 * @param changeListener
	 */
	protected AbstractVisualizationState(Color color,
			List<IGraphItem> graphItemHistory,
			TraversalChangeListener changeListener) {
		this.stateColor = color;
		this.graphItemHistory = graphItemHistory;
		this.changeListener = changeListener;

		// Null Object
		this.predecessorCommand = new EmptyCommand();
	}

	@Override
	public ICommand getPredecessorCommand() {
		return this.predecessorCommand;
	}

	/**
	 * @param currentItem
	 * @param complexCommand
	 */
	protected void addVisualizationCommands(IGraphItem currentItem,
			ComplexCommand complexCommand) {

		if (!currentItem.hasNoResult()) {
			complexCommand.add(new ResultCommand(currentItem, currentItem
					.getPaintedResult(), currentItem.getResult()));
		}
		if (!currentItem.hasNoComment()) {
			complexCommand.add(new CommentCommand(currentItem, currentItem
					.getInfo(), currentItem.getComment(), this.changeListener));
		}

		complexCommand.add(new ColorCommand(currentItem,
				currentItem.getColor(), this.stateColor));
		complexCommand.add(new StrokeWidthCommand(currentItem, DEFAULT_STROKE_WIDTH, 
				this.getItemStrokeWidth(currentItem)));
		
		currentItem.resetVisualizationValues();
	}

	/**
	 * @param currentItem
	 * @return float
	 */
	protected float getItemStrokeWidth(IGraphItem currentItem) {
		return currentItem instanceof IVertex ? VERTEX_STROKE_WIDTH
				: EDGE_STROKE_WIDTH;
	}
}