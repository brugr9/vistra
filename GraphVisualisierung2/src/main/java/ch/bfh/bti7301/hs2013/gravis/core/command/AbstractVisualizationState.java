package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisConstants;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractVisualizationState implements IVisualizationState {

	protected final Color stateColor;

	private final Queue<IStep> queuedCommands;

	private boolean taggedDone, visibleDone;

	private IStep reverseVisibleCommand, reverseTaggedCommand;

	/**
	 * 
	 * @param color
	 */
	protected AbstractVisualizationState(Color color) {
		super();

		this.stateColor = color;
		// null object
		this.queuedCommands = new LinkedList<>();
		this.taggedDone = this.visibleDone = false;
	}

	/**
	 * @param currentItem
	 * @param complexCommand
	 */
	protected void addVisibleTaggedCommands(IGraphItem currentItem,
			Step complexCommand) {
		IStep command = null;

		if (!currentItem.isVisible() && !this.visibleDone) {
			// execute only one time
			this.visibleDone = true;
			command = new VisibleCommand(currentItem, currentItem.getColor(),
					GravisColor.WHITE);
			this.reverseVisibleCommand = new VisibleCommand(currentItem,
					GravisColor.WHITE, currentItem.getColor());
			command.execute();
			complexCommand.add(command);
		}

		if (currentItem.isTagged() && !this.taggedDone) {
			// execute only one time
			this.taggedDone = true;
			command = new TaggedStrokeCommand(currentItem,
					currentItem.getStrokeWidth(),
					this.getItemStrokeWidth(currentItem));
			this.reverseTaggedCommand = new TaggedStrokeCommand(currentItem,
					this.getItemStrokeWidth(currentItem),
					currentItem.getStrokeWidth());
			command.execute();
			complexCommand.add(command);
		}

		if (!currentItem.isTagged()) {
			this.taggedDone = false;
			if (this.reverseTaggedCommand != null) {
				this.reverseTaggedCommand.execute();
			}
		}

		if (currentItem.isVisible()) {
			this.visibleDone = false;
			if (this.reverseVisibleCommand != null) {
				this.reverseVisibleCommand.execute();
			}
		}

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
	public Queue<IStep> getQueuedCommands() {
		return this.queuedCommands;
	}

	/**
	 * 
	 * @param oldState
	 */
	protected void processQueuedCommands(IVisualizationState oldState) {
		Queue<IStep> tempQueue = new LinkedList<>();

		while (!oldState.getQueuedCommands().isEmpty()) {
			IStep step = oldState.getQueuedCommands().poll();

			if (!step.isLocked()) {
				step.execute();
			} else if (oldState != this) {
				this.getQueuedCommands().offer(step);
			} else {
				tempQueue.offer(step);
			}
		}
		this.getQueuedCommands().addAll(tempQueue);
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