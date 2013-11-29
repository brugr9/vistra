package ch.bfh.bti7301.hs2013.gravis.gui.visualization;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeLabelTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeStrokeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.PointTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.ShapeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexLabelTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexStrokeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexToolTipTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ConstantDirectionalEdgeValueTransformer;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class GravisVisualizationViewer extends
		VisualizationViewer<IVertex, IEdge> implements Observer {

	private static final long serialVersionUID = 1145648259547595925L;

	/**
	 * 
	 * @param layout
	 */
	public GravisVisualizationViewer(Layout<IVertex, IEdge> layout) {
		super(layout);

		// TODO bitte an dieser Klasse nichts ändern (pk)

		// TODO preferredSize bitte nur auskommentieren und nicht löschen
		this.setPreferredSize(new Dimension(1350, 430));
		this.setBackground(Color.white);

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
		this.getRenderContext().setEdgeLabelTransformer(new EdgeLabelTransformer());
		this.getRenderContext().setEdgeStrokeTransformer(new EdgeStrokeTransformer());
		this.getRenderContext().setEdgeArrowStrokeTransformer(new EdgeStrokeTransformer());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {

		// TODO bitte an dieser Klasse nichts ändern (pk)

		// if (o instanceof GuiModel && arg instanceof IGravisGraph) {
		// GuiModel m = (GuiModel) o;
		if (arg instanceof IGravisGraph) {
			// GuiModel m = (GuiModel) o;

			try {
				IGravisGraph graph = (IGravisGraph) arg;

				// TODO add dynamic layout
				Layout<IVertex, IEdge> layout = GuiFactory.createLayout(graph,
						new PointTransformer());
				// layout.setSize(new Dimension(250, 350));
				this.setGraphLayout(layout);
			} catch (Exception e) {
				// TODO Exception handling
				e.printStackTrace();
			}
		}

		this.repaint();
	}

}
