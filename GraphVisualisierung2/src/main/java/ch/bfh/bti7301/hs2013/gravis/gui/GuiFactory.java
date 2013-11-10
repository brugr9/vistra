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
	private static final String i18nBaseName = "i18n.MessagesBundle";

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
	public static IGuiView createGui(ICore core, int width, int height) {
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
	public static IGuiView createGui(ICore core, int width, int height,
			ViewType type) {
		GuiModel guiModel = createGuiModel();
		GuiControl guiControl = createGuiControl(core, guiModel, i18nBaseName);
		switch (type) {
		case FULL:
			return createGuiViewFull(guiModel, guiControl, width, height);
		case MINIMAL:
			return createGuiViewMinimal(guiModel, guiControl, width, height);
		case DEFAULT:
			return createGuiViewDefault(guiModel, guiControl, width, height);
		default:
			return createGuiViewDefault(guiModel, guiControl, width, height);
		}
	}

	/**
	 * @param graph
	 * @param pointTransformer 
	 * @return a new instance of type Layout<IVertex, IEdge>
	 */
	public static Layout<IVertex, IEdge> createLayout(
			Graph<IVertex, IEdge> graph, Transformer<IVertex, Point2D> pointTransformer) {
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
	 * Creates a full view - view as in MVC.
	 * 
	 * @param guiModel
	 * @param guiControl
	 * @param width
	 * @param height
	 * @return a view as in MVC
	 */
	private static IGuiView createGuiViewFull(GuiModel guiModel,
			GuiControl guiControl, int width, int height) {
		return new GuiViewFull(guiModel, guiControl, width, height);
	}

	/**
	 * Creates a minimal view - view as in MVC.
	 * 
	 * @param guiModel
	 * @param guiControl
	 * @param width
	 * @param height
	 * @return a view as in MVC
	 */
	private static IGuiView createGuiViewMinimal(GuiModel guiModel,
			GuiControl guiControl, int width, int height) {
		return new GuiViewMinimal(guiModel, guiControl, width, height);
	}

	/**
	 * Creates a default view -- view as in MVC.
	 * 
	 * @param guiModel
	 * @param guiControl
	 * @param width
	 * @param height
	 * @return a view as in MVC
	 */
	private static IGuiView createGuiViewDefault(GuiModel guiModel,
			GuiControl guiControl, int width, int height) {
		// TODO: GuiViewDefault
		return new GuiViewFull(guiModel, guiControl, width, height);
	}

	/**
	 * Creates a gui model as in MVC.
	 * 
	 * @return a gui model
	 */
	private static GuiModel createGuiModel() {
		GuiModel guiModel = new GuiModel();
		return guiModel;
	}

	/**
	 * Creates a GUI control as in MVC.
	 * 
	 * @param core
	 * @param guiModel
	 * @param i18nBaseName
	 * @return a new instance of type <code>GuiControl</code>
	 */
	private static GuiControl createGuiControl(ICore core, GuiModel guiModel,
			String i18nBaseName) {
		GuiControl guiControl = new GuiControl(core, guiModel, i18nBaseName);
		return guiControl;
	}

	/**
	 * Creates a menu bar.
	 * 
	 * @param guiModel
	 * @param guiControl
	 * @return a menu bar
	 */
	static MenuBar createMenuBar(GuiModel guiModel, GuiControl guiControl) {
		MenuBar menuBar = new MenuBar(guiControl);
		guiModel.addObserver(menuBar);
		return menuBar;
	}

	/**
	 * @param graph
	 * @return a circle layout
	 */
	static Layout<IVertex, IEdge> createCircleLayout(
			Graph<IVertex, IEdge> graph) {
		return new CircleLayout<>(graph);
	}
	
	/**
	 * Creates a render panel.
	 * 
	 * @param guiModel
	 * @param guiControl
	 * @return a settings panel
	 */
	static ParameterPanel createRenderPanel(GuiModel guiModel,
			GuiControl guiControl) {
		ParameterPanel parameterPanel = new ParameterPanel(guiControl);
		guiModel.addObserver(parameterPanel);
		return parameterPanel;
	}

	/**
	 * Creates a visualization panel with a circle layout.
	 * 
	 * @param guiModel
	 * @return a visualization panel
	 */
	static VisualizationPanel createVisualizationPanel(GuiModel guiModel) {
		Graph<IVertex, IEdge> graph = GraphFactory.createGraph();
		Layout<IVertex, IEdge> layout = createCircleLayout(graph);
		GravisVisualizationViewer visualizationViewer = new GravisVisualizationViewer(layout);
		VisualizationPanel visualizationPanel = new VisualizationPanel(visualizationViewer);
		guiModel.addObserver(visualizationPanel);
		return visualizationPanel;
	}

	/**
	 * Creates a player panel.
	 * 
	 * @param guiModel
	 * @param guiControl
	 * @return a player panel
	 */
	static PlayerPanel createPlayerPanel(GuiModel guiModel,
			GuiControl guiControl) {
		PlayerPanel playerPanel = new PlayerPanel(guiControl);
		guiModel.addObserver(playerPanel);
		return playerPanel;
	}

	/**
	 * Creates a protocol panel.
	 * 
	 * @param guiModel
	 * @param width
	 * @param height
	 * @return a protocol panel
	 */
	static ProtocolPanel createProtocolPanel(GuiModel guiModel, int width,
			int height) {
		ProtocolPanel protocolPanel = new ProtocolPanel();
		guiModel.addObserver(protocolPanel);
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
