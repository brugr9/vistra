package vistra.gui.view.component.viewer;

import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.algorithms.layout.GraphElementAccessor;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingGraphMousePlugin;

/**
 * An adapted JUNG mouse plugin for editing a graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AdaptedEditingGraphMousePlugin extends
		EditingGraphMousePlugin<IVertex, IEdge> {

	/**
	 * Main constructor.
	 * 
	 * @param vertexFactory
	 *            the vertex factory
	 * @param edgeFactory
	 *            the edge factory
	 */
	public AdaptedEditingGraphMousePlugin(Factory<IVertex> vertexFactory,
			Factory<IEdge> edgeFactory) {
		super(vertexFactory, edgeFactory);
	}

	/**
	 * Transforms an edge shape. The code is lifted from PluggableRenderer to
	 * move an edge shape into an arbitrary position.
	 * 
	 * @param down
	 * @param out
	 */
	private void transformEdgeShape(Point2D down, Point2D out) {
		float x1 = (float) down.getX();
		float y1 = (float) down.getY();
		float x2 = (float) out.getX();
		float y2 = (float) out.getY();

		AffineTransform xform = AffineTransform.getTranslateInstance(x1, y1);

		float dx = x2 - x1;
		float dy = y2 - y1;
		float thetaRadians = (float) Math.atan2(dy, dx);
		xform.rotate(thetaRadians);
		float dist = (float) Math.sqrt(dx * dx + dy * dy);
		xform.scale(dist / this.rawEdge.getBounds().getWidth(), 1.0);
		this.edgeShape = xform.createTransformedShape(this.rawEdge);
	}

	/**
	 * Transforms an arrow shape.
	 * 
	 * @param down
	 *            a 2D point
	 * @param out
	 *            a 2D point
	 */
	private void transformArrowShape(Point2D down, Point2D out) {
		float x1 = (float) down.getX();
		float y1 = (float) down.getY();
		float x2 = (float) out.getX();
		float y2 = (float) out.getY();

		AffineTransform xform = AffineTransform.getTranslateInstance(x2, y2);

		float dx = x2 - x1;
		float dy = y2 - y1;
		float thetaRadians = (float) Math.atan2(dy, dx);
		xform.rotate(thetaRadians);
		this.arrowShape = xform.createTransformedShape(this.rawArrowShape);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void mousePressed(MouseEvent e) {
		if (this.checkModifiers(e)) {
			final VisualizationViewer<IVertex, IEdge> vv = (VisualizationViewer<IVertex, IEdge>) e
					.getSource();
			final Point2D p = e.getPoint();
			GraphElementAccessor<IVertex, IEdge> pickSupport = vv
					.getPickSupport();
			if (pickSupport != null) {
				Graph<IVertex, IEdge> graph = vv.getModel().getGraphLayout()
						.getGraph();

				// set default edge type
				this.edgeIsDirected = EdgeType.DIRECTED;
				if (graph instanceof IExtendedGraph) {
					IExtendedGraph gravisGraph = (IExtendedGraph) graph;

					if (gravisGraph.getEdgeType() == EdgeType.UNDIRECTED) {
						this.edgeIsDirected = EdgeType.UNDIRECTED;
					}
				}

				final IVertex vertex = pickSupport.getVertex(vv.getModel()
						.getGraphLayout(), p.getX(), p.getY());

				if (vertex != null) { // get ready to make an edge
					this.startVertex = vertex;
					this.down = e.getPoint();
					this.transformEdgeShape(this.down, this.down);
					vv.addPostRenderPaintable(this.edgePaintable);

					// TODO shift shortcut not supported in GRAVIS application?
					if ((e.getModifiers() & MouseEvent.SHIFT_MASK) != 0
							&& vv.getModel().getGraphLayout().getGraph() instanceof UndirectedGraph == false) {
						this.edgeIsDirected = EdgeType.DIRECTED;
					}

					if (this.edgeIsDirected == EdgeType.DIRECTED) {
						this.transformArrowShape(this.down, e.getPoint());
						vv.addPostRenderPaintable(this.arrowPaintable);
					}
				} else { // make a new vertex
					IVertex newVertex = this.vertexFactory.create();
					Layout<IVertex, IEdge> layout = vv.getModel()
							.getGraphLayout();
					graph.addVertex(newVertex);

					Point2D point = vv.getRenderContext()
							.getMultiLayerTransformer()
							.inverseTransform(e.getPoint());
					layout.setLocation(newVertex, point);
					newVertex.setLocation(point);
				}
			}
			vv.repaint();
		}
	}

	/**
	 * Handles an mouse event: mouse released.
	 * 
	 * @param e
	 *            the mouse event
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void mouseReleased(MouseEvent e) {
		if (this.checkModifiers(e)) {
			final VisualizationViewer<IVertex, IEdge> vv = (VisualizationViewer<IVertex, IEdge>) e
					.getSource();
			final Point2D p = e.getPoint();
			Layout<IVertex, IEdge> layout = vv.getModel().getGraphLayout();
			GraphElementAccessor<IVertex, IEdge> pickSupport = vv
					.getPickSupport();

			if (pickSupport != null) {
				final IVertex vertex = pickSupport.getVertex(layout, p.getX(),
						p.getY());
				if (vertex != null && this.startVertex != null) {
					Graph<IVertex, IEdge> graph = vv.getGraphLayout()
							.getGraph();
					graph.addEdge(this.edgeFactory.create(), this.startVertex,
							vertex, this.edgeIsDirected);
					vv.repaint();
				}
			}
			this.startVertex = null;
			this.down = null;
			// set default edge type
			this.edgeIsDirected = EdgeType.DIRECTED;
			vv.removePostRenderPaintable(edgePaintable);
			vv.removePostRenderPaintable(arrowPaintable);
		}
	}

}
