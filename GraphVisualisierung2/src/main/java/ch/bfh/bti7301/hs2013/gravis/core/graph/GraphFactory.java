package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeEvent;
import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.command.CommandTransformerFactory;
import ch.bfh.bti7301.hs2013.gravis.core.command.IStep;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
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
	 * @param item
	 * @return a new instance of type GraphEvent<IVertex, IEdge>
	 */
	public static GraphEvent<IVertex, IEdge> createGraphEvent(
			Graph<IVertex, IEdge> graph, IGraphItem item) {
		return new GravisGraphEvent(graph, item);
	}

	/**
	 * Creates a graph manager.
	 * 
	 * @param p
	 *            the core properties
	 * @return a graph manager
	 */
	public static IGraphManager createGraphManager(Properties p)
			throws Exception {
		try {
			// TODO activate properties
//			File templatesDir = new File(p.getProperty("dir.templates.graph"));
//			templatesDir.setReadOnly();
//			File workbenchDir = new File(p.getProperty("dir.workbench.graph"));
//			FileNameExtensionFilter filter = new FileNameExtensionFilter(
//					p.getProperty("suffix.graph.description"),
//					p.getProperty("suffix.graph"));
			return new GraphManager(null, null, null);
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
		List<IGraphItem> graphItemHistory = new ArrayList<>();
		Transformer<IGraphItem, IStep> commandTransformer = CommandTransformerFactory
				.createCommandTransformer(graphItemHistory);
		
		return new GravisGraphEventListener(commandList, graphItemHistory,
				commandTransformer);
	}

}
