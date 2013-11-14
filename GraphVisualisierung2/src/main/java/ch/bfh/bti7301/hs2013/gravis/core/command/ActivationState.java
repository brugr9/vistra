package ch.bfh.bti7301.hs2013.gravis.core.command;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ActivationState extends AbstractAnimationState {

	protected ActivationState() {
		super(GravisColor.BLUE);
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

		this.addVisualizationCommands(currentItem, complexCommand);
		
		this.predecessorCommand = new ColorCommand(currentItem,
				this.stateColor, currentItem.getColor());
		return complexCommand;
	}

}
