package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.geom.Point2D;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.PointTransformer;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;

/**
 * A factory class able to create GUI components and views.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GuiFactory {

	/**
	 * A field for a i18n base name.
	 */
	private static final String I18N_BASE_NAME = "META-INF/i18n/MessagesBundle";

	/**
	 * A main (no-)constructor.
	 */
	private GuiFactory() {
	}

	/**
	 * Creates a view as in MVC.
	 * 
	 * @param core
	 * @param width
	 * @param height
	 * @return a view as in MVC
	 * @throws Exception
	 */
	public static IView createGui(ICore core, int width, int height)
			throws Exception {
		try {
			return createGui(core, width, height, ViewType.DEFAULT);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Creates a view as in MVC.
	 * 
	 * @param core
	 * @param width
	 * @param height
	 * @param type
	 * @return a view as in MVC
	 * @throws Exception
	 */
	public static IView createGui(ICore core, int width, int height,
			ViewType type) throws Exception {
		try {
			Model model = new Model(I18N_BASE_NAME);
			Control control = new Control(core, model);
			IView view;
			switch (type) {
			case FULL:
				view = new ViewFull(model, control, width, height);
			case MINIMAL:
				view = new ViewMinimal(model, control, width, height);
			default:
				view = new ViewFull(model, control, width, height);
			}
			return view;
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * @param graph
	 * @param pointTransformer
	 * @return a new instance of type Layout<IVertex, IEdge>
	 */
	public static Layout<IVertex, IEdge> createLayout(
			Graph<IVertex, IEdge> graph,
			Transformer<IVertex, Point2D> pointTransformer) {
		return new StaticLayout<>(graph, pointTransformer);
	}

	/**
	 * @param forest
	 * @return a tree layout
	 */
	public static Layout<IVertex, IEdge> createTreeLayout(
			Forest<IVertex, IEdge> forest) {
		return new TreeLayout<IVertex, IEdge>(forest);
	}

	/**
	 * Creates a menu bar.
	 * 
	 * @param model
	 * @param control
	 * @return a menu bar
	 */
	static MenuBar createMenuBar(Model model, Control control) {
		MenuBar menuBar = new MenuBar(control);
		model.addObserver(menuBar);
		return menuBar;
	}

	/**
	 * @param graph
	 * @return a circle layout
	 */
	static Layout<IVertex, IEdge> createCircleLayout(Graph<IVertex, IEdge> graph) {
		return new CircleLayout<>(graph);
	}

	/**
	 * Creates a parameter controller.
	 * 
	 * @param model
	 * @param control
	 * @return a parameter controller
	 */
	static ParameterPanel createParameterController(Model model, Control control) {
		ParameterPanel parameterPanel = new ParameterPanel(control);
		model.addObserver(parameterPanel);
		return parameterPanel;
	}

	/**
	 * Creates a visualization panel with a circle layout.
	 * 
	 * @param model
	 * @return a visualization panel
	 */
	static VisualizationPanel createVisualizer(Model model) {
		Graph<IVertex, IEdge> graph = GraphFactory.createGraph();
		Layout<IVertex, IEdge> layout = createLayout(graph, new PointTransformer());
		GravisVisualizationViewer visualizationViewer = new
		GravisVisualizationViewer(layout);
		VisualizationPanel visualizationPanel = new VisualizationPanel(
		visualizationViewer);
		 
		model.addObserver(visualizationPanel);
		return visualizationPanel;
	}

	/**
	 * Creates a traversal controller.
	 * 
	 * @param model
	 * @param control
	 * @return a traversal controller
	 */
	static TraversalPanel createTraversalController(Model model, Control control) {
		TraversalPanel traversalPanel = new TraversalPanel(control);
		model.addObserver(traversalPanel);
		return traversalPanel;
	}

	/**
	 * Creates a protocol panel.
	 * 
	 * @param model
	 * @param width
	 * @param height
	 * @return a protocol panel
	 */
	static ProtocolPanel createProtocolPanel(Model model, int width, int height) {
		ProtocolPanel protocolPanel = new ProtocolPanel();
		model.addObserver(protocolPanel);
		return protocolPanel;
	}

	/**
	 * View types.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ViewType {
		DEFAULT, FULL, MINIMAL,
	}

}
