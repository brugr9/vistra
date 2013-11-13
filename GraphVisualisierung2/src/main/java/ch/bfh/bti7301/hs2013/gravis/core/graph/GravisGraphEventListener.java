package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.util.List;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.command.ICommand;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
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
	 * @param graphItemHistory
	 * @param commandTransformer
	 * @param edgesEnabled
	 */
	protected GravisGraphEventListener(List<ICommand> commandList, 
			List<IGraphItem> graphItemHistory, 
			Transformer<IGraphItem, ICommand> commandTransformer,
			boolean edgesEnabled) {
		
		this.commandList = commandList;
		this.graphItemHistory = graphItemHistory;
		this.commandTransformer = commandTransformer;
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
