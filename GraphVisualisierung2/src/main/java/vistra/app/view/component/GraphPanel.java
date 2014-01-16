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
import vistra.app.view.IView;
import vistra.app.view.component.mouse.Mouse;
import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.transformer.ArrowStroke;
import vistra.framework.graph.item.transformer.EdgeFont;
import vistra.framework.graph.item.transformer.EdgeLabel;
import vistra.framework.graph.item.transformer.EdgeLabelRenderer;
import vistra.framework.graph.item.transformer.EdgeStroke;
import vistra.framework.graph.item.transformer.EdgeStrokeColor;
import vistra.framework.graph.item.transformer.VertexFillColor;
import vistra.framework.graph.item.transformer.VertexFont;
import vistra.framework.graph.item.transformer.VertexLabel;
import vistra.framework.graph.item.transformer.VertexLabelRenderer;
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
	 * A field for a titled border.
	 */
	private TitledBorder border;
	/**
	 * A field for a layout.
	 */
	private Layout<ILayoutVertex, ILayoutEdge> layout;
	/**
	 * A field for a viewer.
	 */
	private VisualizationViewer<ILayoutVertex, ILayoutEdge> viewer;
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
		this.border = BorderFactory.createTitledBorder("title");
		this.setBorder(border);

		/* viewer */
		this.layout = new StaticLayout<ILayoutVertex, ILayoutEdge>(
				model.getGraph());
		this.viewer = new VisualizationViewer<ILayoutVertex, ILayoutEdge>(
				layout, new Dimension(size.width, size.height - IView.BORDER));
		this.viewer.setBackground(ColorPalette.white);
		RenderContext<ILayoutVertex, ILayoutEdge> rc = this.viewer
				.getRenderContext();

		/* transformer: vertex */
		this.viewer.getRenderer().getVertexLabelRenderer()
				.setPosition(Position.CNTR);
		rc.setVertexShapeTransformer(new VertexShape());
		rc.setVertexStrokeTransformer(new VertexStroke());
		rc.setVertexDrawPaintTransformer(new VertexStrokeColor());
		rc.setVertexFillPaintTransformer(new VertexFillColor());
		rc.setVertexLabelTransformer(new VertexLabel());
		rc.setVertexFontTransformer(new VertexFont());
		rc.setVertexLabelRenderer(new VertexLabelRenderer());

		/* transformer: edge */
		rc.setEdgeLabelClosenessTransformer(new ConstantDirectionalEdgeValueTransformer<ILayoutVertex, ILayoutEdge>(
				E_LABEL_CLOSENESS, E_LABEL_CLOSENESS));
		rc.setEdgeShapeTransformer(new EdgeShape.Line<ILayoutVertex, ILayoutEdge>());
		rc.setEdgeStrokeTransformer(new EdgeStroke());
		rc.setEdgeDrawPaintTransformer(new EdgeStrokeColor());
		rc.setEdgeArrowStrokeTransformer(new ArrowStroke());
		rc.setArrowDrawPaintTransformer(new EdgeStrokeColor());
		rc.setEdgeLabelTransformer(new EdgeLabel());
		rc.setEdgeFontTransformer(new EdgeFont());
		rc.setEdgeLabelRenderer(new EdgeLabelRenderer());

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
			this.layout.setGraph(m.getGraph());
			this.border.setTitle(b.getString("graph.label"));
			this.viewer.repaint();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}
}
