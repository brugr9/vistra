package vistra.app.view.popup;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.MultiLayerTransformer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.PickingGraphMousePlugin;
import edu.uci.ics.jung.visualization.picking.PickedState;

/**
 * An adapted JUNG mouse plug-in for picking vertices.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Picking extends
		PickingGraphMousePlugin<IVertexLayout, IEdgeLayout> {

	/**
	 * A field for a JUNG visualization viewer.
	 */
	private VisualizationViewer<IVertexLayout, IEdgeLayout> viewer;

	/**
	 * Main constructor.
	 */
	public Picking() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void mouseDragged(MouseEvent e) {
		if (this.locked == false) {
			this.viewer = (VisualizationViewer<IVertexLayout, IEdgeLayout>) e
					.getSource();
			if (this.vertex != null) {
				Point point = e.getPoint();
				MultiLayerTransformer mt = viewer.getRenderContext()
						.getMultiLayerTransformer();
				Point2D graphPoint = mt.inverseTransform(point);
				Point2D graphDown = mt.inverseTransform(this.down);
				Layout<IVertexLayout, IEdgeLayout> layout = viewer
						.getGraphLayout();
				double dx = graphPoint.getX() - graphDown.getX();
				double dy = graphPoint.getY() - graphDown.getY();
				PickedState<IVertexLayout> ps = viewer.getPickedVertexState();

				for (IVertexLayout v : ps.getPicked()) {
					Point2D vp = layout.transform(v);
					vp.setLocation(vp.getX() + dx, vp.getY() + dy);
					layout.setLocation(v, vp);
					// update the vertex location
					v.setLocation(vp);
				}
				this.down = point;

			} else {
				Point2D out = e.getPoint();
				if (e.getModifiers() == this.addToSelectionModifiers
						|| e.getModifiers() == this.modifiers) {
					this.rect.setFrameFromDiagonal(this.down, out);
				}
			}
			if (this.vertex != null)
				e.consume();
			this.viewer.repaint();
		}
	}

}
