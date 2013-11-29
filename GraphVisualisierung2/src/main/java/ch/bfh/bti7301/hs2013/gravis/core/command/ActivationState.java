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

		Step complexCommand = new Step(oldState.getPredecessorCommand());
		// graphItemRef used by commands from predecessor state
		IGraphItem graphItemRef = this.checkOldObject(
				oldState.getOldGraphItemClone(), currentItem);

		System.out.println("active: " + currentItem.getId() + ", " + currentItem.isTagged() + ", " +
					currentItem.getStrokeWidth() + ", old: " + oldState.getOldGraphItemClone().getId() + ", " + 
							oldState.getOldGraphItemClone().isTagged() + ", " + 
							oldState.getOldGraphItemClone().getStrokeWidth() + ", " +
							graphItemRef.getStrokeWidth());
		
		if (!currentItem.isTagged()) {
			complexCommand.add(new StrokeWidthCommand(currentItem, graphItemRef
					.getStrokeWidth(), this.getItemStrokeWidth(graphItemRef)));
		}
		if (currentItem.isVisible()) {
			complexCommand.add(new ColorCommand(currentItem, graphItemRef
					.getColor(), this.stateColor));
		}
		complexCommand.add(new StateCommand(currentItem, graphItemRef
				.getState(), this.getState()));

		this.addVisualizationCommands(currentItem, complexCommand);

		Step predecessorComplexCommand = new Step();
		if (!currentItem.isTagged()) {
			predecessorComplexCommand.add(new Step(new StrokeWidthCommand(
					currentItem, this.getItemStrokeWidth(graphItemRef),
					graphItemRef.getStrokeWidth())));
		}
		if (currentItem.isVisible()) {
			predecessorComplexCommand.add(new ColorCommand(currentItem,
					this.stateColor, graphItemRef.getColor()));
		}
		predecessorComplexCommand.add(new StateCommand(currentItem, this
				.getState(), graphItemRef.getState()));
		this.setPredecessorCommand(predecessorComplexCommand);

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
