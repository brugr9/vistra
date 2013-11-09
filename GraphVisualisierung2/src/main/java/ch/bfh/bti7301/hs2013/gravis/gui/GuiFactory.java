package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.geom.Point2D;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
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
	private static final String I18N_BASE = "META-INF/i18n/MessagesBundle";

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
	 */
	public static IView createGui(ICore core, int width, int height) {
		return createGui(core, width, height, ViewType.DEFAULT);
	}

	/**
	 * Creates a view as in MVC.
	 * 
	 * @param core
	 * @param width
	 * @param height
	 * @param type
	 * @return a view as in MVC
	 */
	public static IView createGui(ICore core, int width, int height,
			ViewType type) {
		Model model = new Model();
		Control control = new Control(core, model, I18N_BASE);
		switch (type) {
		case FULL:
			return new ViewFull(model, control, width, height);
		case MINIMAL:
			return new ViewMinimal(model, control, width, height);
		default:
			return new ViewFull(model, control, width, height);
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
	 * Creates a render panel.
	 * 
	 * @param model
	 * @param control
	 * @return a settings panel
	 */
	static ParameterPanel createRenderPanel(Model model, Control control) {
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
	static VisualizationPanel createVisualizationPanel(Model model) {
		Graph<IVertex, IEdge> graph = GraphFactory.createGraph();
		Layout<IVertex, IEdge> layout = createCircleLayout(graph);
		VisualizationPanel visualizationPanel = new VisualizationPanel(layout);
		model.addObserver(visualizationPanel);
		return visualizationPanel;
	}

	/**
	 * Creates a player panel.
	 * 
	 * @param model
	 * @param control
	 * @return a player panel
	 */
	static PlayerPanel createPlayerPanel(Model model, Control control) {
		PlayerPanel playerPanel = new PlayerPanel(control);
		model.addObserver(playerPanel);
		return playerPanel;
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
