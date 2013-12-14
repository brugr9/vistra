package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.traversal.step.CommandTransformerFactory;
import ch.bfh.bti7301.hs2013.gravis.core.traversal.step.IStep;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.event.GraphEventListener;

/**
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
	 * 
	 * @return a new instance of type Graph<IVertex, IEdge>
	 */
	public static Graph<IVertex, IEdge> createGraph() {
		return new SparseGraph<IVertex, IEdge>();
	}

	/**
	 * @param graph
	 * @return a new instance of type IGravisGraph
	 */
	public static IGravisGraph createIGravisGraph(Graph<IVertex, IEdge> graph) {
		return new GravisGraph(graph);
	}

	/**
	 * @return a new instance of type IGravisGraph
	 */
	public static IGravisGraph createIGravisGraph() {
		return new GravisGraph(createGraph());
	}

	/**
	 * 
	 * @param graph
	 * @return a new instance of type IObservableGravisGraph
	 */
	public static IObservableGravisGraph createObservableGraph(
			IGravisGraph graph) {
		return new ObservableGravisGraph(graph);
	}

	/**
	 * @param graph
	 * @return a new instance of type IRestrictedGraph
	 */
	public static IRestrictedGraph createRestrictedGraph(
			IObservableGravisGraph graph) {
		return new RestrictedGraph(graph);
	}

	/**
	 * 
	 * @param graph
	 * @param items
	 * @return a new instance of type GraphEvent<IVertex, IEdge>
	 */
	public static GraphEvent<IVertex, IEdge> createGraphEvent(
			Graph<IVertex, IEdge> graph, IGraphItem[] items) {
		return new GravisGraphEvent(graph, items);
	}

	/**
	 * Creates a graph manager.
	 * 
	 * @param p
	 *            the core properties
	 * @return the graph manager
	 */
	public static IGraphManager createGraphManager(Properties p)
			throws Exception {

		try {
			return new GraphManager(p);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * 
	 * @param commandList
	 * @return a new instance of type GraphEventListener<IVertex, IEdge>
	 */
	public static GraphEventListener<IVertex, IEdge> createGravisGraphEventListener(
			List<IStep> commandList) {
		Transformer<IGraphItem, IStep> commandTransformer = CommandTransformerFactory
				.createCommandTransformer();

		return new GravisGraphEventListener(commandList, commandTransformer);
	}

}
