package vistra.gui.view.component.viewer;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.EdgeFactory;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.item.VertexFactory;
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
public class Viewer extends VisualizationViewer<IVertexLayout, IEdgeLayout>
		implements Observer {

	private static final long serialVersionUID = 1145648259547595925L;

	/**
	 * A field for a vertex menu.
	 */
	private VertexPopup vertexPopup;
	/**
	 * A field for an edge menu.
	 */
	private EdgePopup edgePopup;
	/**
	 * A field for an editing modal-graph mouse.
	 */
	private EditingModalGraphMouse<IVertexLayout, IEdgeLayout> mouse;

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
	public Viewer(JFrame top, IGuiModel model,
			Layout<IVertexLayout, IEdgeLayout> layout, Dimension dimension) {
		super(layout, dimension);
		super.setBackground(ColorPalette.WHITE);

		/* Context */
		RenderContext<IVertexLayout, IEdgeLayout> rc = this.getRenderContext();
		/* Vertex */
		this.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		rc.setVertexShapeTransformer(new VertexShape());
		rc.setVertexStrokeTransformer(new VertexStroke());
		rc.setVertexDrawPaintTransformer(new VertexLineColor());
		rc.setVertexFillPaintTransformer(new VertexFillColor());
		rc.setVertexLabelTransformer(new VertexLabelValue());
		rc.setVertexFontTransformer(new VertexFont());

		/* Edge */
		rc.setEdgeLabelClosenessTransformer(new ConstantDirectionalEdgeValueTransformer<IVertexLayout, IEdgeLayout>(
				GraphFactory.E_LABEL_CLOSENESS, GraphFactory.E_LABEL_CLOSENESS));
		rc.setEdgeShapeTransformer(new EdgeShape.Line<IVertexLayout, IEdgeLayout>());
		rc.setEdgeDrawPaintTransformer(new EdgeLineColor());
		rc.setEdgeLabelTransformer(new EdgeLabel());
		rc.setEdgeFontTransformer(new EdgeFont());
		rc.setEdgeStrokeTransformer(new EdgeStroke());
		rc.setEdgeArrowStrokeTransformer(new EdgeStroke());
		rc.setArrowDrawPaintTransformer(new EdgeLineColor());

		/* popup menu */
		this.vertexPopup = new VertexPopup(top, this);
		this.edgePopup = new EdgePopup(top, this);

		/* mouse */
		this.mouse = new Mouse(rc, new VertexFactory(), new EdgeFactory(),
				this.edgePopup, this.vertexPopup, new SwitchModePopup(this));
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
				this.vertexPopup.setLabel(b.getString("vertex.label"));
				this.edgePopup.setLabel(b.getString("edge.label"));
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
