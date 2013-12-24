package vistra.gui.view.component.viewer;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.VertexFactory;
import vistra.core.graph.transformer.edge.EdgeFont;
import vistra.core.graph.transformer.edge.EdgeLabel;
import vistra.core.graph.transformer.edge.EdgeLineColor;
import vistra.core.graph.transformer.edge.EdgeStroke;
import vistra.core.graph.transformer.vertex.VertexFillColor;
import vistra.core.graph.transformer.vertex.VertexFont;
import vistra.core.graph.transformer.vertex.VertexLabelValue;
import vistra.core.graph.transformer.vertex.VertexLineColor;
import vistra.core.graph.transformer.vertex.VertexShape;
import vistra.core.graph.transformer.vertex.VertexStroke;
import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.view.component.viewer.popup.EdgePopup;
import vistra.gui.view.component.viewer.popup.SwitchModePopup;
import vistra.gui.view.component.viewer.popup.VertexPopup;
import vistra.util.ColorPalette;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;
import edu.uci.ics.jung.visualization.decorators.ConstantDirectionalEdgeValueTransformer;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * An adapted JUNG visualization viewer.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Viewer extends VisualizationViewer<IVertex, IEdge> implements
		Observer {

	private static final long serialVersionUID = 1145648259547595925L;

	/**
	 * A field for a vertex menu.
	 */
	private VertexPopup vertexMenu;
	/**
	 * A field for an edge menu.
	 */
	private EdgePopup edgeMenu;
	/**
	 * A field for an editing modal-graph mouse.
	 */
	private EditingModalGraphMouse<IVertex, IEdge> mouse;

	/**
	 * Main constructor.
	 * 
	 * @param top
	 *            the top frame
	 * @param model
	 *            the gui model
	 * @param layout
	 *            the JUNG layout
	 * @param dimension
	 *            the dimension
	 */
	public Viewer(JFrame top, IGuiModel model, Layout<IVertex, IEdge> layout,
			Dimension dimension) {
		super(layout, dimension);
		super.setBackground(ColorPalette.WHITE);

		/* Context */
		RenderContext<IVertex, IEdge> rc = this.getRenderContext();
		/* Vertex */
		this.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		rc.setVertexShapeTransformer(new VertexShape());
		rc.setVertexStrokeTransformer(new VertexStroke());
		rc.setVertexDrawPaintTransformer(new VertexLineColor());
		rc.setVertexFillPaintTransformer(new VertexFillColor());
		rc.setVertexLabelTransformer(new VertexLabelValue());
		rc.setVertexFontTransformer(new VertexFont());

		/* Edge */
		rc.setEdgeLabelClosenessTransformer(new ConstantDirectionalEdgeValueTransformer<IVertex, IEdge>(
				GraphFactory.E_LABEL_CLOSENESS, GraphFactory.E_LABEL_CLOSENESS));
		rc.setEdgeShapeTransformer(new EdgeShape.Line<IVertex, IEdge>());
		rc.setEdgeDrawPaintTransformer(new EdgeLineColor());
		rc.setEdgeLabelTransformer(new EdgeLabel());
		rc.setEdgeFontTransformer(new EdgeFont());
		rc.setEdgeStrokeTransformer(new EdgeStroke());
		rc.setEdgeArrowStrokeTransformer(new EdgeStroke());
		rc.setArrowDrawPaintTransformer(new EdgeLineColor());

		/* popup menu */
		this.vertexMenu = new VertexPopup(top, this);
		this.edgeMenu = new EdgePopup(top, this);

		/* mouse */
		this.mouse = new Mouse(rc, new VertexFactory(), new EdgeFactory(),
				this.edgeMenu, this.vertexMenu, new SwitchModePopup(this));
		this.setGraphMouse(this.mouse);
		this.addKeyListener(this.mouse.getModeKeyListener());

	}

	/**
	 * Updates the visualization viewer.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IGuiModel m = (IGuiModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == EventSource.I18N) {
				this.vertexMenu.setLabel(b.getString("vertex.label"));
				this.edgeMenu.setLabel(b.getString("edge.label"));
			} else if (arg == EventSource.EDIT_GRAPH) {
				if (m.isEditGraphEnabled())
					this.mouse.setMode(Mode.EDITING);
				else
					this.mouse.setMode(Mode.PICKING);
			}

			this.repaint();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}
}
