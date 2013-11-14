package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;

import javax.swing.event.ChangeListener;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractAnimationState implements IAnimationState {

	protected final Color stateColor;

	protected final ChangeListener changeListener;
	
	protected ICommand predecessorCommand;
	
	/**
	 * 
	 * @param color
	 * @param changeListener 
	 */
	protected AbstractAnimationState(Color color, ChangeListener changeListener) {
		this.stateColor = color;
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
		complexCommand.add(new ColorCommand(currentItem,
				currentItem.getColor(), this.stateColor));
		
		if (!currentItem.hasNoResult()) {
			complexCommand.add(new ResultCommand(currentItem, currentItem
					.getPaintedResult(), currentItem.getResult()));
		}
		
		if (!currentItem.hasNoComment()) {
			complexCommand.add(new CommentCommand(currentItem, currentItem
					.getInfo(), currentItem.getComment(), this.changeListener));
		}
		
		currentItem.resetVisualizationValues();
	}

}