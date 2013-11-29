package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractCommonVisualizationState extends
		AbstractVisualizationState {

	/**
	 * @param stateColor
	 */
	protected AbstractCommonVisualizationState(Color stateColor) {
		super(stateColor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.command.IVisualizationState#createCommand
	 * (ch.bfh.bti7301.hs2013.gravis.core.command.IVisualizationState,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem)
	 */
	@Override
	public IStep createCommand(IVisualizationState oldState,
			IGraphItem currentItem) {
		
		Step complexCommand = new Step();
		IStep command = null;
		
		this.addVisibleTaggedCommands(currentItem, complexCommand);
		this.processQueuedCommands(oldState);

		if (!currentItem.isTagged()) {
			command = new StrokeWidthCommand(currentItem,
					currentItem.getStrokeWidth(), this
							.getItemStrokeWidth(currentItem));
			this.getQueuedCommands().offer(new StrokeWidthCommand(
					currentItem, this.getItemStrokeWidth(currentItem),
					currentItem.getStrokeWidth()));
			command.execute();
			complexCommand.add(command);
		}
		
		if (currentItem.isVisible()) {
			command = new ColorCommand(currentItem, currentItem.getColor(),
					this.stateColor);
			command.execute();
			complexCommand.add(command);
		} else {
			this.getQueuedCommands().offer(new ColorCommand(currentItem, currentItem.getColor(),
					this.stateColor));
		}
		
		command = new StateCommand(currentItem,
				currentItem.getState(), this.getState());
		command.execute();
		complexCommand.add(command);

		this.addVisualizationCommands(currentItem, complexCommand);
		currentItem.resetVisualizationValues();

		return complexCommand;
	}

	

}
