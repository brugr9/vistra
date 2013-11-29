package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;
import java.util.List;

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
	protected AbstractCommonVisualizationState(Color stateColor,
			List<IGraphItem> graphItemHistory) {
		super(stateColor, graphItemHistory);
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

		IStep command = this.getPredecessorCommand();
		command.execute();
		Step complexCommand = new Step(command);

		if (!currentItem.isTagged()) {
			command = new StrokeWidthCommand(currentItem,
					currentItem.getStrokeWidth(), this
							.getItemStrokeWidth(currentItem));
			command.execute();
			complexCommand.add(command);
		}
		
		command = new ColorCommand(currentItem,
				currentItem.getColor(), this.stateColor);
		command.execute();
		complexCommand.add(command);
		
		command = (new StateCommand(currentItem,
				currentItem.getState(), this.getState()));
		command.execute();
		complexCommand.add(command);

		this.addVisualizationCommands(currentItem, complexCommand);

		if (!currentItem.isTagged()) {
			this.setPredecessorCommand(new StrokeWidthCommand(
					currentItem, this.getItemStrokeWidth(currentItem),
					currentItem.getStrokeWidth()));
		}

		currentItem.resetVisualizationValues();

		return complexCommand;
	}

}
