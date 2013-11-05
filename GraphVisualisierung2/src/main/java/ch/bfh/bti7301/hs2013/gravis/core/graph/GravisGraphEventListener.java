package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.command.CommandTransformerFactory;
import ch.bfh.bti7301.hs2013.gravis.core.command.ICommand;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisGraphEventListener implements GraphEventListener<IVertex, IEdge> {

	private final List<ICommand> commandList;
	private final List<IGraphItem> graphItemHistory;

	private final Transformer<IGraphItem, ICommand> commandTransformer;

	private boolean edgesEnabled;

	/**
	 * 
	 * @param commandList
	 * @param edgesEnabled
	 */
	protected GravisGraphEventListener(List<ICommand> commandList,
			boolean edgesEnabled) {
		this.commandList = commandList;
		this.graphItemHistory = new ArrayList<>();

		// TODO bitte an dieser Klasse nichts ändern (pk)
		// TODO CommandTransformer as a constructor parameter

		this.commandTransformer = CommandTransformerFactory
				.createCommandTransformer(this.graphItemHistory);
		this.edgesEnabled = edgesEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uci.ics.jung.graph.event.GraphEventListener#handleGraphEvent(edu.
	 * uci.ics.jung.graph.event.GraphEvent)
	 */
	@Override
	public void handleGraphEvent(GraphEvent<IVertex, IEdge> evt) {
		if (evt instanceof GravisGraphEvent) {
			IGraphItem currentItem = ((GravisGraphEvent) evt).getIGraphItem();

			if (!this.edgesEnabled && currentItem instanceof IEdge) {
				return;
			}

			ICommand command = this.commandTransformer.transform(currentItem);
			command.execute();
			this.graphItemHistory.add(currentItem);
			this.commandList.add(command);
		}

	}

}
