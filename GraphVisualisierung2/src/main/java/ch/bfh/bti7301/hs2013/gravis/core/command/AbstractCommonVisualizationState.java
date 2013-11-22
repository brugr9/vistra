package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractCommonVisualizationState extends
		AbstractVisualizationState {

	/**
	 * @param stateColor
	 * @param changeListener
	 */
	protected AbstractCommonVisualizationState(Color stateColor,
			List<IGraphItem> graphItemHistory,
			TraversalChangeListener changeListener) {
		super(stateColor, graphItemHistory, changeListener);
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
	public ICommand createCommand(IVisualizationState oldState,
			IGraphItem currentItem) {

		ComplexCommand complexCommand = new ComplexCommand(
				oldState.getPredecessorCommand());
		IGraphItem graphReference = this.checkOldObject(oldState.getOldGraphItemClone(), 
				currentItem);
		
		complexCommand.add(new StrokeWidthCommand(currentItem, graphReference
				.getStrokeWidth(), this.getItemStrokeWidth(graphReference)));
		
		complexCommand.add(new ColorCommand(currentItem,
				currentItem.getColor(), this.stateColor));
		
		this.addVisualizationCommands(currentItem, complexCommand);
		
		this.setPredecessorCommand(new ComplexCommand(new StrokeWidthCommand(
				currentItem, this.getItemStrokeWidth(graphReference),
				graphReference.getStrokeWidth())));
		
		try {
			this.setOldGraphItemClone(this.isSameObject(currentItem) ? 
					oldState.getOldGraphItemClone() : currentItem.clone());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		currentItem.resetVisualizationValues();
		
		return complexCommand;
	}

}
