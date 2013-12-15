package ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.IModel;
import ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.popup.EdgeMenu;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.popup.VertexMenu;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.popup.VertexMenuFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer.EdgeColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer.EdgeLabelTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer.EdgeStrokeTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer.ShapeTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer.VertexColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer.VertexLabelTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer.VertexStrokeTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer.VertexToolTipTransformer;
import ch.bfh.bti7301.hs2013.gravis.util.GravisColor;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;
import edu.uci.ics.jung.visualization.decorators.ConstantDirectionalEdgeValueTransformer;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * A JUNG visualization viewer adapted for GRAVIS.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GravisVisualizationViewer extends
		VisualizationViewer<IVertex, IEdge> implements Observer {

	private static final long serialVersionUID = 1145648259547595925L;

	/**
	 * A field for a vertex menu.
	 */
	private VertexMenu vertexMenu;
	/**
	 * A field for an edge menu.
	 */
	private EdgeMenu edgeMenu;
	/**
	 * A field for a vertex-menu factory.
	 */
	private VertexMenuFactory vertexMenuFactory;
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
	public GravisVisualizationViewer(JFrame top, Layout<IVertex, IEdge> layout,
			Dimension dimension) {
		super(layout, dimension);
		super.setBackground(GravisColor.WHITE);

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
		this.vertexMenu = new VertexMenu(this);
		this.vertexMenu.setRootFrame(top);
		this.edgeMenu = new EdgeMenu(this);
		this.edgeMenu.setRootFrame(top);

		/* mouse */
		this.vertexMenuFactory = new VertexMenuFactory(this);
		this.mouse = new GravisModalGraphMouse(this.getRenderContext(),
				new VertexFactory(), new EdgeFactory(), this.edgeMenu,
				this.vertexMenu, this.vertexMenuFactory);
		this.setGraphMouse(this.mouse);
		this.addKeyListener(this.mouse.getModeKeyListener());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
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
