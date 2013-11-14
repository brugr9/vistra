package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractAnimationState implements IAnimationState {

	protected final Color stateColor;

	protected ICommand predecessorCommand;

	/**
	 * 
	 * @param color
	 */
	protected AbstractAnimationState(Color color) {
		this.stateColor = color;

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
		complexCommand.add(new ColorCommand(currentItem,
				currentItem.getColor(), this.stateColor));
		
		if (!currentItem.hasNoResult()) {
			complexCommand.add(new ResultCommand(currentItem, currentItem
					.getPaintedResult(), currentItem.getResult()));
		}
		
		if (!currentItem.hasNoComment()) {
			complexCommand.add(new CommentCommand(currentItem, currentItem
					.getInfo(), currentItem.getComment()));
		}
		
		currentItem.resetVisualizationValues();
	}

}