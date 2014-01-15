package vistra.app.view.component.mouse;

import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import javax.swing.JButton;

import org.apache.commons.collections15.Factory;

import vistra.app.IModel;
import vistra.app.control.state.ParameterStateHandler.ParameterEvent;
import vistra.framework.graph.ILayoutGraph;
import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutVertex;
import edu.uci.ics.jung.algorithms.layout.GraphElementAccessor;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingGraphMousePlugin;

/**
 * An adapted JUNG mouse plug-in for editing graph items.
 * 
 * This plugin creates vertices and edges and denies self loops.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Editing extends
		EditingGraphMousePlugin<ILayoutVertex, ILayoutEdge> {

	/**
	 * A field for a JUNG visualization viewer.
	 */
	private VisualizationViewer<ILayoutVertex, ILayoutEdge> viewer;

	/**
	 * A field for a JUNG layout.
	 */
	private Layout<ILayoutVertex, ILayoutEdge> layout;

	/**
	 * A field for a button.
	 */
	private JButton virtualButton;

	/**
	 * Main constructor.
	 * 
	 * @param vertexFactory
	 *            the vertex factory
	 * @param edgeFactory
	 *            the edge factory
	 * @param model
	 *            a gui model
	 */
	public Editing(Factory<ILayoutVertex> vertexFactory,
			Factory<ILayoutEdge> edgeFactory, IModel model) {
		super(vertexFactory, edgeFactory);
		this.virtualButton = new JButton();
		// TODO
		// this.virtualButton.addActionListener(model.getParameterStateHandler());
		this.virtualButton.setActionCommand(ParameterEvent.edit);
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

	@SuppressWarnings("unchecked")
	@Override
	public void mousePressed(MouseEvent e) {
		if (this.checkModifiers(e)) {

			this.viewer = (VisualizationViewer<ILayoutVertex, ILayoutEdge>) e
					.getSource();
			this.layout = this.viewer.getModel().getGraphLayout();
			final Point2D p = e.getPoint();
			GraphElementAccessor<ILayoutVertex, ILayoutEdge> pickSupport = this.viewer
					.getPickSupport();

			if (pickSupport != null) {
				Graph<ILayoutVertex, ILayoutEdge> graph = this.layout
						.getGraph();

				// set default edge type
				this.edgeIsDirected = EdgeType.DIRECTED;
				if (graph instanceof ILayoutGraph) {
					ILayoutGraph eg = (ILayoutGraph) graph;
					if (eg.getEdgeType() == EdgeType.UNDIRECTED) {
						this.edgeIsDirected = EdgeType.UNDIRECTED;
					}
				}

				final ILayoutVertex vertex = pickSupport.getVertex(this.layout,
						p.getX(), p.getY());

				if (vertex != null) {
					/* edge */
					this.startVertex = vertex;
					this.down = e.getPoint();
					this.transformEdgeShape(this.down, this.down);
					this.viewer.addPostRenderPaintable(this.edgePaintable);

					if ((e.getModifiers() & MouseEvent.SHIFT_MASK) != 0
							&& this.layout.getGraph() instanceof UndirectedGraph == false) {
						this.edgeIsDirected = EdgeType.DIRECTED;
					}

					if (this.edgeIsDirected == EdgeType.DIRECTED) {
						this.transformArrowShape(this.down, e.getPoint());
						this.viewer.addPostRenderPaintable(this.arrowPaintable);
					}
				} else {
					/* vertex */
					ILayoutVertex newVertex = this.vertexFactory.create();
					graph.addVertex(newVertex);

					Point2D point = this.viewer.getRenderContext()
							.getMultiLayerTransformer()
							.inverseTransform(e.getPoint());
					this.layout.setLocation(newVertex, point);
					newVertex.setLocation(point);
					// event an parameterStateHandler
					this.virtualButton.doClick();
				}
			}
			this.viewer.repaint();
		}
	}

	/**
	 * Handles a mouse event: mouse released.
	 * 
	 * @param e
	 *            the mouse event
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.checkModifiers(e)) {

			this.viewer = (VisualizationViewer<ILayoutVertex, ILayoutEdge>) e
					.getSource();
			final Point2D p = e.getPoint();
			this.layout = this.viewer.getModel().getGraphLayout();
			GraphElementAccessor<ILayoutVertex, ILayoutEdge> pickSupport = this.viewer
					.getPickSupport();

			if (pickSupport != null) {
				final ILayoutVertex vertex = pickSupport.getVertex(layout,
						p.getX(), p.getY());
				if ((vertex != null && this.startVertex != null)
						&& (vertex != this.startVertex) // no self loops
				) {
					Graph<ILayoutVertex, ILayoutEdge> graph = this.viewer
							.getGraphLayout().getGraph();
					graph.addEdge(this.edgeFactory.create(), this.startVertex,
							vertex, this.edgeIsDirected);
					// event
					this.virtualButton.doClick();
				}
				this.viewer.repaint();
			}

			this.startVertex = null;
			this.down = null;
			// set default edge type
			this.edgeIsDirected = EdgeType.DIRECTED;
			this.viewer.removePostRenderPaintable(this.edgePaintable);
			this.viewer.removePostRenderPaintable(this.arrowPaintable);
		}
	}
}
