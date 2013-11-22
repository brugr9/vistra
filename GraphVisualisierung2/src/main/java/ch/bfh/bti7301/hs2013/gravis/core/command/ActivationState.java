package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ActivationState extends AbstractVisualizationState {

	/**
	 * 
	 * @param graphItemHistory
	 */
	protected ActivationState(List<IGraphItem> graphItemHistory) {
		super(GravisColor.BLUE, graphItemHistory);
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

		Step complexCommand = new Step(
				oldState.getPredecessorCommand());
		IGraphItem graphReference = this.checkOldObject(oldState.getOldGraphItemClone(), 
				currentItem);

		complexCommand.add(new StrokeWidthCommand(currentItem, graphReference
				.getStrokeWidth(), this.getItemStrokeWidth(graphReference)));
		complexCommand.add(new ColorCommand(currentItem, graphReference
				.getColor(), this.stateColor));

		this.addVisualizationCommands(currentItem, complexCommand);

		Step predecessorComplexCommand = new Step(
				new StrokeWidthCommand(currentItem,
						this.getItemStrokeWidth(graphReference),
						graphReference.getStrokeWidth()));
		predecessorComplexCommand.add(new ColorCommand(currentItem,
				this.stateColor, graphReference.getColor()));
		this.setPredecessorCommand(predecessorComplexCommand);

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
			return "Der Knoten " + currentItem.getId()
					+ " wurde aktiviert.";
		}
		
		return "Die Kante " + currentItem.getId()
				+ " wurde aktiviert.";
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
}
