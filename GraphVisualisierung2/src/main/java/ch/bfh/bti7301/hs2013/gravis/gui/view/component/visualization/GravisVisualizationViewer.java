package ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeLabelTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeStrokeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.ShapeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexLabelTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexStrokeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexToolTipTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.IModel;
import ch.bfh.bti7301.hs2013.gravis.util.GravisColor;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
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
	 * Main constructor.
	 * 
	 * @param layout
	 *            the JUNG layout
	 * @param dimension
	 *            the dimension
	 */
	public GravisVisualizationViewer(Layout<IVertex, IEdge> layout,
			Dimension dimension) {
		super(layout, dimension);
		super.setBackground(GravisColor.WHITE);

		// vertex visualization
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

		// edge visualization
		this.getRenderContext().setEdgeShapeTransformer(
				new EdgeShape.Line<IVertex, IEdge>());
		this.getRenderContext().setEdgeDrawPaintTransformer(
				new EdgeColorTransformer());
		this.getRenderContext().setArrowDrawPaintTransformer(
				new EdgeColorTransformer());
		// centers edge label
		this.getRenderContext().setEdgeLabelClosenessTransformer(
				new ConstantDirectionalEdgeValueTransformer<IVertex, IEdge>(
						0.5, 0.5));
		this.getRenderContext().setEdgeLabelTransformer(
				new EdgeLabelTransformer());
		this.getRenderContext().setEdgeStrokeTransformer(
				new EdgeStrokeTransformer());
		this.getRenderContext().setEdgeArrowStrokeTransformer(
				new EdgeStrokeTransformer());
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
			this.repaint();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}

}
