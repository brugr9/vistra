package vistra.app.view.component;

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

import vistra.app.IModel;
import vistra.app.Model;
import vistra.app.control.IControl.ControlEvent;
import vistra.app.view.IView;
import vistra.app.view.popup.Mouse;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.item.transformer.EdgeFont;
import vistra.framework.graph.item.transformer.EdgeFontColor;
import vistra.framework.graph.item.transformer.EdgeLabel;
import vistra.framework.graph.item.transformer.EdgeStroke;
import vistra.framework.graph.item.transformer.EdgeStrokeColor;
import vistra.framework.graph.item.transformer.VertexFillColor;
import vistra.framework.graph.item.transformer.VertexFont;
import vistra.framework.graph.item.transformer.VertexFontColor;
import vistra.framework.graph.item.transformer.VertexLabel;
import vistra.framework.graph.item.transformer.VertexLocation;
import vistra.framework.graph.item.transformer.VertexShape;
import vistra.framework.graph.item.transformer.VertexStroke;
import vistra.framework.graph.item.transformer.VertexStrokeColor;
import vistra.framework.util.palette.ColorPalette;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
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
	 * A field for a layout.
	 */
	private Layout<IVertexLayout, IEdgeLayout> layout;
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
	 * @param size
	 *            the panel size
	 */
	public GraphPanel(JFrame top, IModel model, Dimension size) {
		this.setSize(size);
		this.title = "title";
		this.name = "name";
		this.border = BorderFactory.createTitledBorder(this.title + " "
				+ this.name);
		this.setBorder(border);

		/* viewer */
		this.layout = new StaticLayout<IVertexLayout, IEdgeLayout>(
				model.getGraph(), new VertexLocation());
		this.viewer = new VisualizationViewer<IVertexLayout, IEdgeLayout>(
				layout, new Dimension(size.width, size.height - IView.BORDER));
		this.viewer.setBackground(ColorPalette.white);
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
		rc.setVertexDrawPaintTransformer(new VertexFontColor());
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
		rc.setEdgeDrawPaintTransformer(new EdgeFontColor());

		/* mouse */
		this.mouse = new Mouse(model, this.viewer);
		((Model) model).addObserver(this.mouse);
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

		IModel m = (IModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == ControlEvent.I18N)
				this.title = b.getString("graph.label");
			this.name = m.getGraph().getName();
			if (!m.isGraphSaved())
				this.name += "*";
			this.border.setTitle(this.title + ": " + this.name);
			this.layout.setGraph(m.getGraph());
			this.viewer.repaint();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}
}
