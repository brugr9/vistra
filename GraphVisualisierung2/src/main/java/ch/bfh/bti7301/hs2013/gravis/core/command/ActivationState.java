package ch.bfh.bti7301.hs2013.gravis.core.command;


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

	protected ActivationState() {
		super(GravisConstants.ACTIVATION_COLOR);

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
			this.getQueuedCommands().offer(new ColorCommand(currentItem, this.stateColor,
					currentItem.getColor()));
			command.execute();
			complexCommand.add(command);
		}

		command = new StateCommand(currentItem, currentItem.getState(),
				this.getState());
		this.getQueuedCommands().offer(new StateCommand(currentItem, this.getState(),
				currentItem.getState()));
		command.execute();
		complexCommand.add(command);

		this.addVisualizationCommands(currentItem, complexCommand);
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
