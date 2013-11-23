package ch.bfh.bti7301.hs2013.gravis.old;

import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;

import ch.bfh.bti7301.hs2013.gravis.core.CoreFactory;
import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.PointTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.GravisVisualizationViewer;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.VisualizationPanel;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;

/**
 * This factory class creates and composes all necessary objects used in this
 * application. The construction of objects is centralized in this class. All
 * necessary dependencies are passed through the constructors and methods to the
 * objects (dependency injection). An object speaks only through an interface to
 * other dependant objects.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @deprecated
 */
public final class OldApplicationFactory {

	// TODO set correct path of imported graphs ( in application file structure)
	/*
	 * project > properties > java build path > source > add folder >
	 * GraphVisualisierung2/data
	 */
	// String path = "data/templates";
	// String filename = "GraphMLBspTree";
	// this.graphService.importGraph(path + "/" + filename +
	// ".graphml");
	public final static String IMPORTED_GRAPHS_PATH = "src/main/resources/META-INF/templates/";

	/**
	 * The default name of the property file name relative to the CLASSPATH.
	 */
	public final static String APPLICATION_PROPERTIES_FILENAME = "ch/bfh/bti7301/hs2013/gravis/Application.properties";

	/**
	 * A main (no-)constructor.
	 */
	private OldApplicationFactory() {
	}

	/**
	 * A new instance of type JFrame is created.
	 * 
	 * @return a new instance of type JFrame
	 */
	public static JFrame createMainWindow() {
		// Graph<IVertex, IEdge> graph = GraphFactory.createGraph();
		// IGravisGraph<IVertex, IEdge> gravisGraph =
		// GraphFactory.createIGravisGraph(graph);
		// IGraphService graphService = createGraphService(gravisGraph,
		// IMPORTED_GRAPHS_PATH);
		//
		// IAlgorithmLoader algorithmLoader = createAlgorithmLoader();
		// IAlgorithmFactory algorithmFactory =
		// createAlgorithmFactory(algorithmLoader);
		//
		// IDataProcessor dataProcessor = createDataProcessor(gravisGraph,
		// algorithmFactory.selectDefaultAlgorithm());
		// ITraverserCollection traverserCollection =
		// createTraverserCollection();
		// IGraphTraverser graphTraverser =
		// createGraphTraverser(traverserCollection);

		ICore gravisCore = null;
		try {
			gravisCore = CoreFactory.createCore(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Graph<IVertex, IEdge> graph = GraphFactory.createGraph();
		Layout<IVertex, IEdge> layout = GuiFactory.createLayout(graph, new PointTransformer());
		GravisVisualizationViewer visualizationViewer = new
		GravisVisualizationViewer(layout);
		VisualizationPanel visualizationPanel = new VisualizationPanel(
		visualizationViewer);
		
		OldIGravisMainListener mainWindowListener = new OldMainWindowListener(
				gravisCore);
		JFrame mainWindow = new OldGravisMainWindow("Test", visualizationPanel,
				mainWindowListener);
		// new OldGravisMainWindow(title, graphPanel, mainWindowListener);

		mainWindowListener.addObserver(visualizationPanel);

		return mainWindow;
	}

	/**
	 * @param graph
	 * @return a new instance of type Layout<IVertex, IEdge>
	 */
	public static Layout<IVertex, IEdge> createLayout(
			Graph<IVertex, IEdge> graph) {
		return new CircleLayout<>(graph);
	}

	/**
	 * Creates an application property.
	 * 
	 * @return the application property
	 * @throws Exception
	 */
	private static Properties loadApplicationProperties() throws Exception {

		Properties properties = null;
		properties = new Properties();

		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		InputStream is = classLoader
				.getResourceAsStream(APPLICATION_PROPERTIES_FILENAME);
		try {
			properties.load(is);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Cannot load properties file for sheet: "
							+ APPLICATION_PROPERTIES_FILENAME);
		}
		return properties;

	}

	// /**
	// * @param gravisCore
	// * @return a new instance of type OldMainWindowListener
	// */
	// private static OldMainWindowListener createMainWindowListener(ICore
	// gravisCore) {
	// return
	// }

	// /**
	// * @param title
	// * @param graphPanel
	// * @param mainWindowListener
	// * @return a new instance of type OldGravisMainWindow
	// */
	// private static OldGravisMainWindow createGraphVisualizerMainWindow(
	// String title, VisualizationPanel graphPanel,
	// OldIGravisMainListener mainWindowListener) {
	// return
	// }

	// /**
	// * @param layout
	// * @return a new instance of type VisualizationPanel
	// */
	// private static VisualizationPanel createGraphVisualizationPanel(
	// Layout<IVertex, IEdge> layout) {
	// return new VisualizationPanel(null, null);
	// }

	// /**
	// * @return a new instance of type Factory<IVertex>
	// */
	// public static Factory<IVertex> createVertexFactory() {
	// return new VertexFactory();
	// }
	//
	// /**
	// * @return a new instance of type Factory<IEdge>
	// */
	// public static Factory<IEdge> createEdgeFactory() {
	// return new EdgeFactory();
	// }
	//
	// /**
	// * @return a new instance of type PriorityQueue<? extends IBasicGraphItem>
	// */
	// public static PriorityQueue<? extends IBasicGraphItem>
	// createPriorityQueue() {
	// return new PriorityQueue<IGraphItem>();
	// }
	//
	// /**
	// *
	// * @param graph
	// * @param eventType
	// * @param graphItem
	// * @return a new instance of type GraphEvent<IVertex, IEdge>
	// */
	// public static GraphEvent<IVertex, IEdge> createGraphEvent(
	// Graph<IVertex, IEdge> graph, GraphEvent.Type
	// eventType, IGraphItem graphItem) {
	// return new GravisGraphEvent(graph, eventType, graphItem);
	// }
	//
	// /**
	// * @param graphItem
	// * @returna new instance of type IStep
	// */
	// public static IStep createCommand(IGraphItem graphItem) {
	// return new GravisCommand(graphItem);
	// }
	//
	// /**
	// * @param traverserList
	// * @return a new instance of type GraphEventListener<IVertex, IEdge>
	// */
	// public static GraphEventListener<IVertex, IEdge> createCommandCreator(
	// List<IStep> traverserList) {
	// return new CommandCreator(traverserList);
	// }
	//
	// /**
	// *
	// * @param list
	// * @return a new instance of type ITraverserCollection
	// */
	// public static ITraverserCollection
	// createTraverserCollection(List<IStep> list) {
	// return new TraverserCollection(list);
	// }

	// /**
	// * @return a new instance of type IAlgorithmLoader
	// */
	// private static IAlgorithmLoader createAlgorithmLoader() {
	// return new AlgorithmLoader();
	// }
	//
	// /**
	// *
	// * @param algorithmLoader
	// * @return a new instance of type IAlgorithmFactory
	// */
	// private static IAlgorithmFactory createAlgorithmFactory(IAlgorithmLoader
	// algorithmLoader) {
	// return new AlgorithmFactory(algorithmLoader);
	// }
	//
	// /**
	// * @return a new instance of type ITraverserCollection
	// */
	// private static ITraverserCollection createTraverserCollection() {
	// return new TraverserCollection();
	// }
	//
	// /**
	// * @param traverserCollection
	// * @return a new instance of type IGraphTraverser
	// */
	// private static IGraphTraverser createGraphTraverser(
	// ITraverserCollection traverserCollection) {
	// return new GraphTraverser(traverserCollection);
	// }
	//
	// /**
	// * @param algorithmContext
	// * @return a new instance of type IDataProcessor
	// */
	// private static IDataProcessor createDataProcessor(IGravisGraph<IVertex,
	// IEdge>
	// gravisGraph, IAlgorithm algorithm) {
	// return new DataProcessor(gravisGraph, algorithm);
	// }
	//
	// /**
	// * @param graphDecorator
	// * @param path
	// * @return a new instance of type IGraphService
	// */
	// private static IGraphService createGraphService(
	// IGravisGraph<IVertex, IEdge> graphDecorator, String path) {
	// return new GraphService(graphDecorator, path);
	// }

}
