package vistra.core.graph;

import java.util.List;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IGraphItem;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.traversal.step.IStep;
import vistra.core.traversal.step.Step;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisGraphEventListener implements GraphEventListener<IVertex, IEdge> {

	private final List<IStep> commandList;

	private final Transformer<IGraphItem, IStep> commandTransformer;

	/**
	 * 
	 * @param commandList
	 * @param commandTransformer
	 */
	protected GravisGraphEventListener(List<IStep> commandList,
			Transformer<IGraphItem, IStep> commandTransformer) {

		this.commandList = commandList;
		this.commandTransformer = commandTransformer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uci.ics.jung.graph.event.GraphEventListener#handleGraphEvent(edu.
	 * uci.ics.jung.graph.event.GraphEvent)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleGraphEvent(GraphEvent<IVertex, IEdge> evt) {
		if (evt instanceof GravisGraphEvent) {
			IGraphItem[] currentItems = ((GravisGraphEvent) evt)
					.getGraphItems();

			Step step = new Step();
			for (IGraphItem item : currentItems) {
				IStep command = this.commandTransformer.transform(item);
				step.add(command);
			}

			this.commandList.add(step);
		}

	}

}