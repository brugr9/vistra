package ch.bfh.bti7301.hs2013.gravis.core.traversal.step;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractVisualizationState implements IVisualizationState {

	private final static String UNDO_MSG = "Folgender Schritt wurde rückgängig gemacht: %s";

	protected AbstractVisualizationState() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.step.IVisualizationState#createCommand
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem)
	 */
	@Override
	public IStep createCommand(IGraphItem currentItem) {
		Step complexCommand = new Step();

		this.createGeneralStateCommands(currentItem, complexCommand);
		this.createSpecialCommands(currentItem, complexCommand);

		currentItem.resetVisualizationValues();
		return complexCommand;
	}

	/**
	 * @param currentItem
	 * @param complexCommand
	 */
	private void createSpecialCommands(IGraphItem currentItem,
			Step complexCommand) {

		IStep command = new StrokeWidthCommand(currentItem,
				currentItem.getCurrentStrokeWidth(),
				currentItem.getNewStrokeWidth());
		command.execute();
		complexCommand.add(command);

		if (!currentItem.hasNoResult()) {
			command = new ResultCommand(currentItem,
					currentItem.getCurrentResult(), currentItem.getNewResult());
			command.execute();
			complexCommand.add(command);
		}

		if (!currentItem.getNewComment().isEmpty()) {
			command = new CommentCommand(String.format(UNDO_MSG,
					currentItem.getNewComment()), currentItem.getNewComment());
			command.execute();
			complexCommand.add(command);
		}
	}

	/**
	 * @param currentItem
	 * @param complexCommand
	 */
	private void createGeneralStateCommands(IGraphItem currentItem,
			Step complexCommand) {

		if (currentItem.isVisible()) {
			this.setNewColor(currentItem);
		}
		
		IStep command = new StateCommand(currentItem,
				currentItem.getCurrentState(), this.getState());
		command.execute();
		complexCommand.add(command);

		command = new ColorCommand(currentItem,
				currentItem.getCurrentColor(), currentItem.getNewColor());
		command.execute();
		complexCommand.add(command);
		
		if (currentItem.isStateCommentEnabled()) {
			command = new CommentCommand(this.getStateUndoMessage(currentItem),
					this.getStateDoMessage(currentItem));
			command.execute();
			complexCommand.add(command);
		}
	}

	/**
	 * @param currentItem
	 */
	protected void setNewColor(IGraphItem currentItem) {
		currentItem.setNewColor(this.getStateColor());
	}

	/**
	 * @return Color
	 */
	protected abstract Color getStateColor();

	/**
	 * 
	 * @param currentItem
	 * @return stateDoMessage
	 */
	protected abstract String getStateDoMessage(IGraphItem currentItem);

	/**
	 * 
	 * @param currentItem
	 * @return stateUndoMessage
	 */
	protected abstract String getStateUndoMessage(IGraphItem currentItem);
}