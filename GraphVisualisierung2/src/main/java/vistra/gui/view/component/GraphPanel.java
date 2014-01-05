package vistra.gui.view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
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
import vistra.gui.GuiModel;
import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.ControlEvent;
import vistra.gui.view.IView;
import vistra.gui.view.mouse.Mouse;
import vistra.util.ColorPalette;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ConstantDirectionalEdgeValueTransformer;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * A graph panel.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GraphPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 177109739873034494L;

	private final static double E_LABEL_CLOSENESS = 0.5;

	/**
	 * A field for a title.
	 */
	private String title;
	/**
	 * A field for a name.
	 */
	private String name;
	/**
	 * A field for a titled border.
	 */
	private TitledBorder border;
	/**
	 * A field for a viewer.
	 */
	private VisualizationViewer<IVertexLayout, IEdgeLayout> viewer;
	/**
	 * A field for a graph zoom scroll pane.
	 */
	private GraphZoomScrollPane zoom;
	/**
	 * A field for a mouse.
	 */
	private final Mouse mouse;

	/**
	 * Main constructor.
	 * 
	 * @param top
	 *            the top frame
	 * @param model
	 *            a model as in MVC
	 * @param layout
	 *            a JUNG layout
	 * @param size
	 *            the panel size
	 */
	public GraphPanel(JFrame top, GuiModel model,
			Layout<IVertexLayout, IEdgeLayout> layout, Dimension size) {
		this.setSize(size);
		this.title = "title";
		this.name = "name";
		this.border = BorderFactory.createTitledBorder(this.title + " "
				+ this.name);
		this.setBorder(border);

		/* viewer */
		this.viewer = new VisualizationViewer<IVertexLayout, IEdgeLayout>(
				layout, new Dimension(size.width, size.height - IView.BORDER));
		this.viewer.setBackground(ColorPalette.WHITE);
		RenderContext<IVertexLayout, IEdgeLayout> rc = this.viewer
				.getRenderContext();
		// transformer: vertex
		this.viewer.getRenderer().getVertexLabelRenderer()
				.setPosition(Position.CNTR);
		rc.setVertexShapeTransformer(new VertexShape());
		rc.setVertexStrokeTransformer(new VertexStroke());
		rc.setVertexDrawPaintTransformer(new VertexStrokeColor());
		rc.setVertexFillPaintTransformer(new VertexFillColor());
		rc.setVertexLabelTransformer(new VertexLabel());
		rc.setVertexFontTransformer(new VertexFont());
		// transformer: edge
		rc.setEdgeLabelClosenessTransformer(new ConstantDirectionalEdgeValueTransformer<IVertexLayout, IEdgeLayout>(
				E_LABEL_CLOSENESS, E_LABEL_CLOSENESS));
		rc.setEdgeShapeTransformer(new EdgeShape.Line<IVertexLayout, IEdgeLayout>());
		rc.setEdgeStrokeTransformer(new EdgeStroke());
		rc.setEdgeArrowStrokeTransformer(new EdgeStroke());
		rc.setEdgeDrawPaintTransformer(new EdgeStrokeColor());
		rc.setArrowDrawPaintTransformer(new EdgeStrokeColor());
		rc.setEdgeLabelTransformer(new EdgeLabel());
		rc.setEdgeFontTransformer(new EdgeFont());

		/* mouse */
		this.mouse = new Mouse(top, model, this.viewer);
		model.addObserver(this.mouse);
		this.viewer.setGraphMouse(this.mouse);
		this.viewer.addKeyListener(this.mouse.getModeKeyListener());

		/* zoom */
		this.zoom = new GraphZoomScrollPane(this.viewer);
		this.zoom.setSize(size);
		/* this */
		this.add(this.zoom, BorderLayout.CENTER);

	}

	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IGuiModel m = (IGuiModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == ControlEvent.I18N)
				this.title = b.getString("graph.label");
			else if (arg == ControlEvent.GRAPH) {
				this.name = m.getGraph().getName();
				if (!m.isGraphSaved())
					this.name += "*";
			}
			this.border.setTitle(this.title + ": " + this.name);
			this.viewer.repaint();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}
}
