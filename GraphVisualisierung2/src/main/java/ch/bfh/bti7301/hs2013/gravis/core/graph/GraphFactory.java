package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.util.List;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.traversal.step.CommandTransformerFactory;
import ch.bfh.bti7301.hs2013.gravis.core.traversal.step.IStep;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
 * A graph factory.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GraphFactory {

	/**
	 * A main (no-)constructor.
	 */
	private GraphFactory() {
	}

	/**
	 * Returns a JUNG <code>SparseGraph</code>.
	 * 
	 * @return the graph
	 */
	public static Graph<IVertex, IEdge> createGraph() {
		return new SparseGraph<IVertex, IEdge>();
	}

	/**
	 * Creates a <code>GravisGraph</code> based on an already existing graph.
	 * 
	 * @param graph
	 *            the graph to extend
	 * @return the extended graph
	 */
	public static IGravisGraph createIGravisGraph(Graph<IVertex, IEdge> graph) {
		return new GravisGraph(graph);
	}

	/**
	 * Creates a <code>GravisGraph</code> based on a JUNG
	 * <code>SparseGraph</code>.
	 * 
	 * @return the graph
	 */
	public static IGravisGraph createIGravisGraph() {
		return new GravisGraph(createGraph());
	}

	/**
	 * Creates an <code>IObservableGravisGraph</code> based on a JUNG
	 * <code>SparseGraph</code>.
	 * 
	 * @return the observable graph
	 */
	public static IObservableGravisGraph createObservableGraph() {
		return new ObservableGravisGraph(new GravisGraph(createGraph()));
	}

	/**
	 * Creates an <code>IObservableGravisGraph</code> based on an already
	 * existing <code>IGravisGraph</code>.
	 * 
	 * @param graph
	 *            the graph to make observable
	 * @return the observable graph
	 */
	public static IObservableGravisGraph createObservableGraph(
			IGravisGraph graph) {
		return new ObservableGravisGraph(graph);
	}

	/**
	 * Creates an <code>IRestrictedGraph</code> based on an already existing
	 * <code>IObservableGravisGraph</code>.
	 * 
	 * @param graph
	 *            the graph to restrict
	 * @return the restricted graph
	 */
	public static IRestrictedGraph createRestrictedGraph(
			IObservableGravisGraph graph) {
		return new RestrictedGraph(graph);
	}

	/**
	 * Creates a graph event.
	 * 
	 * @param graph
	 *            a graph the event is related to
	 * @param items
	 *            the graph items
	 * @return a new instance of type GraphEvent<IVertex, IEdge>
	 */
	public static GraphEvent<IVertex, IEdge> createGraphEvent(
			Graph<IVertex, IEdge> graph, IGraphItem[] items) {
		return new GravisGraphEvent(graph, items);
	}

	/**
	 * Creates a <code>GraphEventListener</code>.
	 * 
	 * @param commandList
	 *            a list of commands
	 * @return the graph event listener
	 */
	public static GraphEventListener<IVertex, IEdge> createGravisGraphEventListener(
			List<IStep> commandList) {
		Transformer<IGraphItem, IStep> commandTransformer = CommandTransformerFactory
				.createCommandTransformer();
		return new GravisGraphEventListener(commandList, commandTransformer);
	}

}
