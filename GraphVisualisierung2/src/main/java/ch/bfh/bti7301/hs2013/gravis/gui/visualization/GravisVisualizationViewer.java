package ch.bfh.bti7301.hs2013.gravis.gui.visualization;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Stroke;
import java.util.Observable;
import java.util.Observer;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.PointTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.ShapeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.RenderContext;
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

		Transformer<IVertex, String> vertexLabelTransformer = new Transformer<IVertex, String>() {
			@Override
			public String transform(IVertex vertex) {
				return vertex.getId()
						+ (Double.isNaN(vertex.getPaintedResult()) ? "" : ": "
								+ vertex.getPaintedResult());
			}
		};
		this.getRenderContext().setVertexLabelTransformer(
				vertexLabelTransformer);

		this.getRenderContext().setVertexStrokeTransformer(
				new Transformer<IVertex, Stroke>() {
					@Override
					public Stroke transform(IVertex vertex) {
						return new BasicStroke(vertex.getStrokeWidth());
					}
				});

		Transformer<IVertex, String> vertexToolTipTransformer = new Transformer<IVertex, String>() {
			@Override
			public String transform(IVertex vertex) {
				return vertex.getId();
			}
		};
		this.setVertexToolTipTransformer(vertexToolTipTransformer);

		// edge visualization
		EdgeColorTransformer edgeColorTransformer = new EdgeColorTransformer();
		this.getRenderContext().setEdgeShapeTransformer(
				new EdgeShape.Line<IVertex, IEdge>());
		this.getRenderContext().setEdgeDrawPaintTransformer(edgeColorTransformer
				);
		this.getRenderContext().setArrowDrawPaintTransformer(
				edgeColorTransformer);
		// centers edge label
		this.getRenderContext().setEdgeLabelClosenessTransformer(
				new ConstantDirectionalEdgeValueTransformer<IVertex, IEdge>(
						0.5, 0.5));

		Transformer<IEdge, String> edgeLabelTransformer = new Transformer<IEdge, String>() {
			@Override
			public String transform(IEdge edge) {
				return edge.getWeight()
						+ (Double.isNaN(edge.getPaintedResult()) ? "" : "| "
								+ edge.getPaintedResult());
			}
		};
		this.getRenderContext().setEdgeLabelTransformer(edgeLabelTransformer);

		Transformer<IEdge, String> edgeToolTipTransformer = new Transformer<IEdge, String>() {
			@Override
			public String transform(IEdge edge) {
				return edge.getId();
			}
		};
		this.setEdgeToolTipTransformer(edgeToolTipTransformer);

		this.getRenderContext().setEdgeStrokeTransformer(
				new Transformer<IEdge, Stroke>() {
					@Override
					public Stroke transform(IEdge edge) {
						return new BasicStroke(edge.getStrokeWidth());
					}
				});

		this.getRenderContext().setEdgeArrowStrokeTransformer(
				new Transformer<IEdge, Stroke>() {
					@Override
					public Stroke transform(IEdge edge) {
						return new BasicStroke(edge.getStrokeWidth());
					}
				});

		// this.getRenderContext().setEdgeFillPaintTransformer(
		// new EdgeColorTransformer());
		// RenderContext<IVertex, IEdge> context = this.getRenderContext();
		// context.setEdgeDrawPaintTransformer(new
		// KeyframeGradientTransformer());

	}

	class KeyframeGradientTransformer implements Transformer<IEdge, Paint> {
		@Override
		public Paint transform(IEdge edge) {
			// TODO: Here you would determine the gradient information
			// based on the edge.getKeyframe().
			int x = 5;
			int y = 7;
			// fill RoundRectangle2D.Double
			Paint gradient = new GradientPaint(x, y, Color.red, 200, y,
					Color.blue);
			return gradient;
		}
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