package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisConstants;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractVisualizationState implements IVisualizationState {

	protected final Color stateColor;

	protected final List<IGraphItem> graphItemHistory;

	private IStep predecessorCommand;

	/**
	 * 
	 * @param color
	 * @param graphItemHistory
	 */
	protected AbstractVisualizationState(Color color,
			List<IGraphItem> graphItemHistory) {

		this.stateColor = color;
		this.graphItemHistory = graphItemHistory;
		// null object
		this.predecessorCommand = new EmptyStep();
	}

	/**
	 * @param currentItem
	 * @param complexCommand
	 */
	protected void addVisualizationCommands(IGraphItem currentItem,
			Step complexCommand) {

		IStep command = null;
		if (!currentItem.hasNoResult()) {
			command = new ResultCommand(currentItem,
					currentItem.getPaintedResult(), currentItem.getResult());
			command.execute();
			complexCommand.add(command);
		}

		if (!currentItem.isVisible()) {
			command = new ColorCommand(currentItem, currentItem.getColor(),
					GravisColor.WHITE);
			command.execute();
			complexCommand.add(command);
		}

		if (currentItem.isTagged()) {
			command = new StrokeWidthCommand(currentItem,
					currentItem.getStrokeWidth(),
					this.getItemStrokeWidth(currentItem));
			command.execute();
			complexCommand.add(command);
		}

		command = new CommentCommand(currentItem,
				this.stateUndoMessage(currentItem),
				this.stateDoMessage(currentItem));
		command.execute();
		complexCommand.add(command);

		if (!currentItem.getComment().isEmpty()) {
			command = new CommentCommand(currentItem, currentItem.getInfo(),
					currentItem.getComment());
			command.execute();
			complexCommand.add(command);
		}
	}

	/**
	 * @param currentItem
	 * @return float
	 */
	protected float getItemStrokeWidth(IGraphItem currentItem) {
		return currentItem instanceof IVertex ? GravisConstants.V_TAGGED_STROKE
				: GravisConstants.E_TAGGED_STROKE;
	}

	@Override
	public IStep getPredecessorCommand() {
		return this.predecessorCommand;
	}

	/**
	 * @param predecessorCommand
	 *            the predecessorCommand to set
	 */
	protected void setPredecessorCommand(IStep predecessorCommand) {
		this.predecessorCommand = predecessorCommand;
	}

	/**
	 * 
	 * @param currentItem
	 * @return stateDoMessage
	 */
	public abstract String stateDoMessage(IGraphItem currentItem);

	/**
	 * 
	 * @param currentItem
	 * @return stateUndoMessage
	 */
	public abstract String stateUndoMessage(IGraphItem currentItem);
}