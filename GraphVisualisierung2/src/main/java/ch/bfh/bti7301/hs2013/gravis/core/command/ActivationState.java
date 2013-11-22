package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ActivationState extends AbstractVisualizationState {

	/**
	 * 
	 * @param graphItemHistory
	 * @param changeListener
	 */
	protected ActivationState(List<IGraphItem> graphItemHistory, 
			TraversalChangeListener changeListener) {
		super(GravisColor.BLUE, graphItemHistory, changeListener);
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
		
		this.addVisualizationCommands(currentItem, complexCommand);

		ComplexCommand predecessorComplexCommand = new ComplexCommand(
				new StrokeWidthCommand(currentItem, this.getItemStrokeWidth(currentItem),
						currentItem.getStrokeWidth()));
		predecessorComplexCommand.add(new ColorCommand(currentItem,
				this.stateColor, currentItem.getColor()));
		this.predecessorCommand = predecessorComplexCommand;

		return complexCommand;
	}

}
