package vistra.gui.view.component.adapted;

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
import vistra.gui.IModel;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.view.component.popup.MenuFactory;
import vistra.gui.view.component.popup.PopupMenuEdge;
import vistra.gui.view.component.popup.PopupMenuVertex;
import vistra.util.TravisColor;
import vistra.util.transformer.EdgeColorTransformer;
import vistra.util.transformer.EdgeLabelTransformer;
import vistra.util.transformer.EdgeStrokeTransformer;
import vistra.util.transformer.ShapeTransformer;
import vistra.util.transformer.VertexColorTransformer;
import vistra.util.transformer.VertexLabelTransformer;
import vistra.util.transformer.VertexStrokeTransformer;
import vistra.util.transformer.VertexToolTipTransformer;

import edu.uci.ics.jung.algorithms.layout.Layout;
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
public class AdaptedVisualizationViewer extends
		VisualizationViewer<IVertex, IEdge> implements Observer {

	private static final long serialVersionUID = 1145648259547595925L;

	/**
	 * A field for a vertex menu.
	 */
	private PopupMenuVertex vertexMenu;
	/**
	 * A field for an edge menu.
	 */
	private PopupMenuEdge edgeMenu;
	/**
	 * A field for a vertex-menu factory.
	 */
	private MenuFactory vertexMenuFactory;
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
	public AdaptedVisualizationViewer(JFrame top, Layout<IVertex, IEdge> layout,
			Dimension dimension) {
		super(layout, dimension);
		super.setBackground(TravisColor.WHITE);

		/* Vertex layout */
		this.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		this.getRenderContext().setVertexFillPaintTransformer(
				new VertexColorTransformer());
		this.getRenderContext().setVertexShapeTransformer(
				new ShapeTransformer());
		this.getRenderContext().setVertexLabelTransformer(
				new VertexLabelTransformer());
		this.getRenderContext().setVertexStrokeTransformer(
				new VertexStrokeTransformer());
		this.setVertexToolTipTransformer(new VertexToolTipTransformer());

		/* Edge layout */
		this.getRenderContext().setEdgeShapeTransformer(
				new EdgeShape.Line<IVertex, IEdge>());
		this.getRenderContext().setEdgeDrawPaintTransformer(
				new EdgeColorTransformer());
		this.getRenderContext().setArrowDrawPaintTransformer(
				new EdgeColorTransformer());
		// Edge label: center
		this.getRenderContext().setEdgeLabelClosenessTransformer(
				new ConstantDirectionalEdgeValueTransformer<IVertex, IEdge>(
						0.5, 0.5));
		this.getRenderContext().setEdgeLabelTransformer(
				new EdgeLabelTransformer());
		this.getRenderContext().setEdgeStrokeTransformer(
				new EdgeStrokeTransformer());
		this.getRenderContext().setEdgeArrowStrokeTransformer(
				new EdgeStrokeTransformer());

		/* context menu */
		this.vertexMenu = new PopupMenuVertex(top, this);
		this.edgeMenu = new PopupMenuEdge(top, this);

		/* mouse */
		this.vertexMenuFactory = new MenuFactory(this);
		this.mouse = new AdaptedEditingModalGraphMouse(this.getRenderContext(),
				new VertexFactory(), new EdgeFactory(), this.edgeMenu,
				this.vertexMenu, this.vertexMenuFactory);
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
