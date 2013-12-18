package travis.core.graph;

import java.util.List;

import org.apache.commons.collections15.Transformer;

import travis.core.graph.item.IGraphItem;
import travis.core.graph.item.edge.IEdge;
import travis.core.graph.item.vertex.IVertex;
import travis.core.traversal.step.IStep;
import travis.core.traversal.step.Step;

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
