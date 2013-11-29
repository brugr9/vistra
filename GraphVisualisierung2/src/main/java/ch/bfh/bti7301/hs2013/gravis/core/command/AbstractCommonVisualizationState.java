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

		Step complexCommand = new Step(oldState.getPredecessorCommand());
		// graphItemRef used by commands from predecessor state
		IGraphItem oldGraphItemRef = this.checkOldObject(
				oldState.getOldGraphItemClone(), currentItem);

		System.out.println("common: " + currentItem.getId() + ", " + currentItem.isTagged() + ", " +
				currentItem.getStrokeWidth() + ", old: " + oldState.getOldGraphItemClone().getId() + ", " + 
				oldState.getOldGraphItemClone().isTagged() + ", " + 
				oldState.getOldGraphItemClone().getStrokeWidth());
		
		if (!currentItem.isTagged()) {
			complexCommand.add(new StrokeWidthCommand(currentItem,
					oldGraphItemRef.getStrokeWidth(), this
							.getItemStrokeWidth(oldGraphItemRef)));
		}
		complexCommand.add(new ColorCommand(currentItem,
				currentItem.getColor(), this.stateColor));
		complexCommand.add(new StateCommand(currentItem,
				currentItem.getState(), this.getState()));

		this.addVisualizationCommands(currentItem, complexCommand);

		if (!currentItem.isTagged()) {
			this.setPredecessorCommand(new Step(new StrokeWidthCommand(
					currentItem, this.getItemStrokeWidth(oldGraphItemRef),
					oldGraphItemRef.getStrokeWidth())));
		}
		
		try {
			this.setOldGraphItemClone(this.isSameObject(currentItem) ? oldState
					.getOldGraphItemClone() : currentItem.clone());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		currentItem.resetVisualizationValues();

		return complexCommand;
	}

}
