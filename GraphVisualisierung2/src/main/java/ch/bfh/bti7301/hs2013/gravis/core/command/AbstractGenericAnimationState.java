package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractGenericAnimationState extends AbstractAnimationState {

	/**
	 * @param stateColor
	 * @param changeListener 
	 */
	protected AbstractGenericAnimationState(Color stateColor,
			List<IGraphItem> graphItemHistory, TraversalChangeListener changeListener) {
		super(stateColor, graphItemHistory, changeListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.command.IAnimationState#createCommand
	 * (ch.bfh.bti7301.hs2013.gravis.core.command.IAnimationState,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem)
	 */
	@Override
	public ICommand createCommand(IAnimationState oldState,
			IGraphItem currentItem) {
		ComplexCommand complexCommand = new ComplexCommand(
				oldState.getPredecessorCommand());

		if (!this.graphItemHistory.isEmpty()) {
			IGraphItem previousItem = this.graphItemHistory
					.get(this.graphItemHistory.size() - 1);

			if (previousItem instanceof IEdge) {
				complexCommand.add(new ColorCommand(previousItem, previousItem
						.getColor(), this.stateColor));
			}
		}

		this.addVisualizationCommands(currentItem, complexCommand);
		
		this.predecessorCommand = new ComplexCommand(
				new StrokeWidthCommand(currentItem, this.getItemStrokeWidth(currentItem),
						DEFAULT_STROKE_WIDTH));
		
		return complexCommand;
	}

}
