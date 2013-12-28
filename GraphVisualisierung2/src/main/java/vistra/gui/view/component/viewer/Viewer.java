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
import vistra.core.graph.item.transformer.EdgeFont;
import vistra.core.graph.item.transformer.EdgeLabel;
import vistra.core.graph.item.transformer.EdgeStroke;
import vistra.core.graph.item.transformer.EdgeStrokeColor;
import vistra.core.graph.item.transformer.VertexFillColor;
import vistra.core.graph.item.transformer.VertexFont;
import vistra.core.graph.item.transformer.VertexLabel;
import vistra.core.graph.item.transformer.VertexShape;
import vistra.core.graph.item.transformer.VertexStroke;
import vistra.core.graph.item.transformer.VertexStrokeColor;
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
	 * A field for a vertex pop-up menu.
	 */
	private final VertexPopup vertexPopup;
	/**
	 * A field for an edge pop-up menu.
	 */
	private final EdgePopup edgePopup;
	/**
	 * A field for a switch-mode pop-up menu.
	 */
	private final SwitchModePopup modePopup;
	/**
	 * A field for an editing modal-graph mouse.
	 */
	private final EditingModalGraphMouse<IVertexLayout, IEdgeLayout> mouse;

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
		this.setBackground(ColorPalette.WHITE);

		/* render context */
		RenderContext<IVertexLayout, IEdgeLayout> rc = this.getRenderContext();
		/* vertex */
		this.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		rc.setVertexShapeTransformer(new VertexShape());
		rc.setVertexStrokeTransformer(new VertexStroke());
		rc.setVertexDrawPaintTransformer(new VertexStrokeColor());
		rc.setVertexFillPaintTransformer(new VertexFillColor());
		rc.setVertexLabelTransformer(new VertexLabel());
		rc.setVertexFontTransformer(new VertexFont());
		/* edge */
		rc.setEdgeLabelClosenessTransformer(new ConstantDirectionalEdgeValueTransformer<IVertexLayout, IEdgeLayout>(
				GraphFactory.E_LABEL_CLOSENESS, GraphFactory.E_LABEL_CLOSENESS));
		rc.setEdgeShapeTransformer(new EdgeShape.Line<IVertexLayout, IEdgeLayout>());
		rc.setEdgeStrokeTransformer(new EdgeStroke());
		rc.setEdgeArrowStrokeTransformer(new EdgeStroke());
		rc.setEdgeDrawPaintTransformer(new EdgeStrokeColor());
		rc.setArrowDrawPaintTransformer(new EdgeStrokeColor());
		rc.setEdgeLabelTransformer(new EdgeLabel());
		rc.setEdgeFontTransformer(new EdgeFont());

		/* mouse and pop-up menu */
		this.vertexPopup = new VertexPopup(top, this);
		this.edgePopup = new EdgePopup(top, this);
		this.modePopup = new SwitchModePopup(this);
		this.mouse = new Mouse(rc, new VertexFactory(), new EdgeFactory(),
				this.edgePopup, this.vertexPopup, this.modePopup);
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
