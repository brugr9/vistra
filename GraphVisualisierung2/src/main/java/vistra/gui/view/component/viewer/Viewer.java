package vistra.gui.view.component.viewer;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.VertexFactory;
import vistra.core.graph.transformer.edge.EdgeLabelTransformer;
import vistra.core.graph.transformer.edge.EdgeLineColorTransformer;
import vistra.core.graph.transformer.edge.EdgeLineWidthTransformer;
import vistra.core.graph.transformer.vertex.VertexFillPaintTransformer;
import vistra.core.graph.transformer.vertex.VertexLabelTransformer;
import vistra.core.graph.transformer.vertex.VertexShapeTransformer;
import vistra.core.graph.transformer.vertex.VertexStrokeTransformer;
import vistra.gui.IModel;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.view.component.viewer.popup.MenuFactory;
import vistra.gui.view.component.viewer.popup.EdgePopup;
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
	 * A field for an editing modal graph mouse.
	 */
	private EditingModalGraphMouse<IVertex, IEdge> mouse;

	/**
	 * Main constructor.
	 * 
	 * @param top
	 *            the top frame
	 * @param layout
	 *            the JUNG layout
	 * @param dimension
	 *            the dimension
	 */
	public Viewer(JFrame top, Layout<IVertex, IEdge> layout, Dimension dimension) {
		super(layout, dimension);
		super.setBackground(ColorPalette.WHITE);

		/* Context */
		RenderContext<IVertex, IEdge> c = this.getRenderContext();
		/* Vertex */
		this.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		c.setVertexShapeTransformer(new VertexShapeTransformer());
		c.setVertexStrokeTransformer(new VertexStrokeTransformer());
		c.setVertexFillPaintTransformer(new VertexFillPaintTransformer());
		c.setVertexLabelTransformer(new VertexLabelTransformer());
		/* Edge */
		c.setEdgeLabelClosenessTransformer(new ConstantDirectionalEdgeValueTransformer<IVertex, IEdge>(
				0.5, 0.5));
		c.setEdgeShapeTransformer(new EdgeShape.Line<IVertex, IEdge>());
		c.setEdgeDrawPaintTransformer(new EdgeLineColorTransformer());
		c.setArrowDrawPaintTransformer(new EdgeLineColorTransformer());
		c.setEdgeLabelTransformer(new EdgeLabelTransformer());
		c.setEdgeStrokeTransformer(new EdgeLineWidthTransformer());
		c.setEdgeArrowStrokeTransformer(new EdgeLineWidthTransformer());

		/* popup menu */
		this.vertexMenu = new VertexPopup(top, this);
		this.edgeMenu = new EdgePopup(top, this);

		/* mouse */
		this.mouse = new AdaptedEditingModalGraphMouse(c, new VertexFactory(),
				new EdgeFactory(), this.edgeMenu, this.vertexMenu,
				new MenuFactory(this));
		this.setGraphMouse(this.mouse);
		this.addKeyListener(this.mouse.getModeKeyListener());

	}

	/**
	 * Updates the visualization viewer.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IModel m = (IModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == EventSource.EDIT_GRAPH) {
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
