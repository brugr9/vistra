package vistra.gui.view.component.viewer;

import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import edu.uci.ics.jung.algorithms.layout.GraphElementAccessor;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingGraphMousePlugin;

/**
 * An adapted JUNG mouse plug-in for editing a graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EditingPlugin extends
		EditingGraphMousePlugin<IVertexLayout, IEdgeLayout> {

	private VisualizationViewer<IVertexLayout, IEdgeLayout> vv;

	private Layout<IVertexLayout, IEdgeLayout> layout;

	/**
	 * Main constructor.
	 * 
	 * @param vertexFactory
	 *            the vertex factory
	 * @param edgeFactory
	 *            the edge factory
	 */
	public EditingPlugin(Factory<IVertexLayout> vertexFactory,
			Factory<IEdgeLayout> edgeFactory) {
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
		float dx = x2 - x1;
		float dy = y2 - y1;
		AffineTransform xform = AffineTransform.getTranslateInstance(x1, y1);
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
		float dx = x2 - x1;
		float dy = y2 - y1;
		AffineTransform xform = AffineTransform.getTranslateInstance(x2, y2);
		float thetaRadians = (float) Math.atan2(dy, dx);
		xform.rotate(thetaRadians);

		this.arrowShape = xform.createTransformedShape(this.rawArrowShape);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (this.checkModifiers(e)) {
			this.vv = (Viewer) e.getSource();
			this.layout = vv.getModel().getGraphLayout();
			final Point2D p = e.getPoint();
			GraphElementAccessor<IVertexLayout, IEdgeLayout> pickSupport = vv
					.getPickSupport();

			if (pickSupport != null) {
				Graph<IVertexLayout, IEdgeLayout> graph = this.layout
						.getGraph();

				// set default edge type
				this.edgeIsDirected = EdgeType.DIRECTED;
				if (graph instanceof IExtendedGraph) {
					IExtendedGraph eg = (IExtendedGraph) graph;
					if (eg.getEdgeType() == EdgeType.UNDIRECTED) {
						this.edgeIsDirected = EdgeType.UNDIRECTED;
					}
				}

				final IVertexLayout vertex = pickSupport.getVertex(this.layout,
						p.getX(), p.getY());

				if (vertex != null) { // get ready to make an edge
					this.startVertex = vertex;
					this.down = e.getPoint();
					this.transformEdgeShape(this.down, this.down);
					this.vv.addPostRenderPaintable(this.edgePaintable);

					if ((e.getModifiers() & MouseEvent.SHIFT_MASK) != 0
							&& this.layout.getGraph() instanceof UndirectedGraph == false) {
						this.edgeIsDirected = EdgeType.DIRECTED;
					}

					if (this.edgeIsDirected == EdgeType.DIRECTED) {
						this.transformArrowShape(this.down, e.getPoint());
						this.vv.addPostRenderPaintable(this.arrowPaintable);
					}
				} else { // make a new vertex
					IVertexLayout newVertex = this.vertexFactory.create();
					graph.addVertex(newVertex);

					Point2D point = this.vv.getRenderContext()
							.getMultiLayerTransformer()
							.inverseTransform(e.getPoint());
					this.layout.setLocation(newVertex, point);
					newVertex.setLocation(point);
				}
			}
			this.vv.repaint();
		}
	}

	/**
	 * Handles an mouse event: mouse released.
	 * 
	 * @param e
	 *            the mouse event
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.checkModifiers(e)) {
			this.vv = (Viewer) e.getSource();
			final Point2D p = e.getPoint();
			Layout<IVertexLayout, IEdgeLayout> layout = this.vv.getModel()
					.getGraphLayout();
			GraphElementAccessor<IVertexLayout, IEdgeLayout> pickSupport = vv
					.getPickSupport();

			if (pickSupport != null) {
				final IVertexLayout vertex = pickSupport.getVertex(layout,
						p.getX(), p.getY());
				if (vertex != null && this.startVertex != null) {
					Graph<IVertexLayout, IEdgeLayout> graph = vv
							.getGraphLayout().getGraph();
					graph.addEdge(this.edgeFactory.create(), this.startVertex,
							vertex, this.edgeIsDirected);
					this.vv.repaint();
				}
			}
			this.startVertex = null;
			this.down = null;
			// set default edge type
			this.edgeIsDirected = EdgeType.DIRECTED;
			this.vv.removePostRenderPaintable(edgePaintable);
			this.vv.removePostRenderPaintable(arrowPaintable);
		}
	}

}
