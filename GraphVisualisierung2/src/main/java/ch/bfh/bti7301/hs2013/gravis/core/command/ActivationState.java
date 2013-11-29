package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisConstants;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ActivationState extends AbstractVisualizationState {

	private State state;

	/**
	 * 
	 * @param graphItemHistory
	 */
	protected ActivationState(List<IGraphItem> graphItemHistory) {
		super(GravisConstants.ACTIVATION_COLOR, graphItemHistory);

		this.state = State.ACTIVATION;
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
					currentItem.getStrokeWidth(),
					this.getItemStrokeWidth(currentItem));
			command.execute();
			complexCommand.add(command);
		}

		if (currentItem.isVisible()) {
			command = new ColorCommand(currentItem, currentItem
					.getColor(), this.stateColor);
			command.execute();
			complexCommand.add(command);
		}
		
		command = new StateCommand(currentItem,
				currentItem.getState(), this.getState());
		command.execute();
		complexCommand.add(command);

		this.addVisualizationCommands(currentItem, complexCommand);

		Step predCommand = new Step();
		if (!currentItem.isTagged()) {
			predCommand.add(new StrokeWidthCommand(
					currentItem, this.getItemStrokeWidth(currentItem),
					currentItem.getStrokeWidth()));
		}
		
		if (currentItem.isVisible()) {
			predCommand.add(new ColorCommand(currentItem,
					this.stateColor, currentItem.getColor()));
		}
		
		predCommand.add(new StateCommand(currentItem, this
				.getState(), currentItem.getState()));
		this.setPredecessorCommand(predCommand);
		
		currentItem.resetVisualizationValues();

		return complexCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.command.AbstractVisualizationState#
	 * stateDoMessage(ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem)
	 */
	@Override
	public String stateDoMessage(IGraphItem currentItem) {
		if (currentItem instanceof IVertex) {
			return "Der Knoten " + currentItem.getId() + " wurde aktiviert.";
		}

		return "Die Kante " + currentItem.getId() + " wurde aktiviert.";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.command.AbstractVisualizationState#
	 * stateUndoMessage(ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem)
	 */
	@Override
	public String stateUndoMessage(IGraphItem currentItem) {
		if (currentItem instanceof IVertex) {
			return "Der Knoten " + currentItem.getId()
					+ " ist nicht mehr aktiviert.";
		}
		return "Die Kante " + currentItem.getId()
				+ " ist nicht mehr aktiviert.";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.command.IVisualizationState#getState()
	 */
	@Override
	public State getState() {
		return this.state;
	}
}
