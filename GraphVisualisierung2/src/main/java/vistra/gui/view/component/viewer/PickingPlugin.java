package vistra.gui.view.component.viewer;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.PickingGraphMousePlugin;
import edu.uci.ics.jung.visualization.picking.PickedState;

/**
 * An adapted JUNG mouse plug-in for picking a graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class PickingPlugin extends PickingGraphMousePlugin<IVertexLayout, IEdgeLayout> {

	/**
	 * Main constructor.
	 */
	public PickingPlugin() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void mouseDragged(MouseEvent e) {
		if (this.locked == false) {
			VisualizationViewer<IVertexLayout, IEdgeLayout> vv = (VisualizationViewer<IVertexLayout, IEdgeLayout>) e
					.getSource();
			if (this.vertex != null) {
				Point p = e.getPoint();
				Point2D graphPoint = vv.getRenderContext()
						.getMultiLayerTransformer().inverseTransform(p);
				Point2D graphDown = vv.getRenderContext()
						.getMultiLayerTransformer().inverseTransform(this.down);
				Layout<IVertexLayout, IEdgeLayout> layout = vv.getGraphLayout();
				double dx = graphPoint.getX() - graphDown.getX();
				double dy = graphPoint.getY() - graphDown.getY();
				PickedState<IVertexLayout> ps = vv.getPickedVertexState();

				for (IVertexLayout v : ps.getPicked()) {
					Point2D vp = layout.transform(v);
					vp.setLocation(vp.getX() + dx, vp.getY() + dy);
					layout.setLocation(v, vp);
					// update the vertex location
					v.setLocation(vp);
				}
				this.down = p;

			} else {
				Point2D out = e.getPoint();
				if (e.getModifiers() == this.addToSelectionModifiers
						|| e.getModifiers() == this.modifiers) {
					this.rect.setFrameFromDiagonal(this.down, out);
				}
			}
			if (this.vertex != null)
				e.consume();
			vv.repaint();
		}
	}

}
